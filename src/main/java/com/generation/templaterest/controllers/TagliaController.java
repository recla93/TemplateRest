package com.generation.templaterest.controllers;

import com.generation.templaterest.controllers.exceptions.MostroInesistenteException;
import com.generation.templaterest.controllers.exceptions.TagliaNonEsistenteException;
import com.generation.templaterest.model.dao.MostroDao;
import com.generation.templaterest.model.dao.TagliaDao;
import com.generation.templaterest.model.entities.Mostro;
import com.generation.templaterest.model.entities.Taglia;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagliaController
{
//	Dependency injection tramite annotazione
//	@Autowired
//	private MostroDao mDao;
//	@Autowired
//	private TagliaDao tDao;

	//dependency injection tramite costruttore
	private MostroDao mDao;
	private TagliaDao tDao;
	//se noi scriviamo un costruttore in una classe beanizzata con parametri
	//lui in automatico autowira
	public TagliaController(MostroDao mDao,TagliaDao tDao)
	{
		this.mDao = mDao;
		this.tDao = tDao;
	}

//	Potete fare autowired anche con i setter, anche qui cambia niente
//	@Autowired
//	public void setmDao(MostroDao mDao)
//	{
//		this.mDao = mDao;
//	}
//	@Autowired
//	public void settDao(TagliaDao tDao)
//	{
//		this.tDao = tDao;
//	}

	@GetMapping("/api/taglie")
	public List<Taglia> getAll()
	{
		return tDao.findAll();
	}

	//leggo tutte le taglie del mostro con id={id_mostro}
	@GetMapping("/api/mostri/{id_mostro}/taglie")
	public List<Taglia> getAllFor(@PathVariable Long id_mostro)
	{
		Mostro m = mDao.findById(id_mostro).orElse(null);
		if(m==null)
			throw new MostroInesistenteException("Mostro con id "+id_mostro+" non trovato");

		return m.getTaglie();
	}

	@PostMapping("/api/mostri/{id_mostro}/taglie")
	public Taglia insert(@PathVariable Long id_mostro, @RequestBody Taglia t)
	{
		Mostro m = mDao.findById(id_mostro).orElse(null);
		if(m==null)
			throw new MostroInesistenteException("Mostro con id "+id_mostro+" non trovato");
		//prima di salvare lo lego al padre
		t.setBersaglio(m);
		t = tDao.save(t);
		return t;
	}

	//leggo tutte le taglie del mostro con id={id_mostro}
	@GetMapping("/api/mostri/{id_mostro}/taglie/{id_taglia}")
	public Taglia getOneFor(@PathVariable Long id_mostro,@PathVariable Long id_taglia)
	{
		return trovaTagliaPerIdPadreEIdTaglia(id_mostro,id_taglia);
	}

	@PutMapping("/api/mostri/{id_mostro}/taglie/{id_taglia}")
	public Taglia modify(@PathVariable Long id_mostro,@PathVariable Long id_taglia,@RequestBody Taglia modificata)
	{
		//richiamo il metodo solo per far lanciare eccezione se la taglia non esiste
		Taglia vecchia =trovaTagliaPerIdPadreEIdTaglia(id_mostro,id_taglia);
		modificata.setId(id_taglia);
		modificata = tDao.save(modificata);

		return modificata;
	}

	@DeleteMapping("/api/mostri/{id_mostro}/taglie/{id_taglia}")
	public Taglia cancella(@PathVariable Long id_mostro,@PathVariable Long id_taglia)
	{
		Taglia vecchia =trovaTagliaPerIdPadreEIdTaglia(id_mostro,id_taglia);
		tDao.delete(vecchia);
		return vecchia;
	}

	private Taglia trovaTagliaPerIdPadreEIdTaglia(Long idMostro,Long idTaglia)
	{
		Mostro m = mDao.findById(idMostro).orElse(null);
		if(m==null)
			throw new MostroInesistenteException("Mostro con id "+idMostro+" non trovato");

		Taglia res = m.getTaglie().stream().filter(t->t.getId().equals(idTaglia)).findAny().orElse(null);
		if(res==null)
			throw new TagliaNonEsistenteException("Non esiste taglia con id "+idTaglia);

		return res;
	}
}
