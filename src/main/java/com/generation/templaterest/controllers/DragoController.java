package com.generation.templaterest.controllers;

import com.generation.templaterest.controllers.exceptions.MostroInesistenteException;
import com.generation.templaterest.model.dao.DragoDao;
import com.generation.templaterest.model.entities.Drago;
import com.generation.templaterest.model.entities.Mostro;
import com.generation.templaterest.model.entities.enums.Elemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/draghi")
public class DragoController
{
	@Autowired
	private DragoDao dao;


	//metodi di CRUD
	@GetMapping
	public List<Drago> getAll()
	{
		return dao.findAll();
	}

	@GetMapping("/elemento/{el}")
	public List<Drago> getAllByElemento(@PathVariable Elemento el)
	{
		return dao.findAllByElemento(el);
	}

	@GetMapping("/{id}")
	public Drago getOne(@PathVariable Long id)
	{
		return dao.findById(id).orElse(null);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Drago insert(@RequestBody Drago d)
	{
		d = dao.save(d);
		return d;
	}

	@PutMapping("/{id}")
	public Drago modify(@PathVariable Long id,@RequestBody Drago d)
	{
		d.setId(id);
		d = dao.save(d);
		return d;
	}

	@DeleteMapping("/{id}")
	public Drago delete(@PathVariable Long id)
	{
		Drago d = dao.findById(id).orElse(null);

		if(d==null)
			throw new MostroInesistenteException("Il drago con id "+id+" non esiste");

		dao.delete(d);

		return d;
	}
}
