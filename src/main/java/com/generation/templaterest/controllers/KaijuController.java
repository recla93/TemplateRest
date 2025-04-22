package com.generation.templaterest.controllers;

import com.generation.templaterest.controllers.exceptions.MostroInesistenteException;
import com.generation.templaterest.model.dao.KaijuDao;
import com.generation.templaterest.model.entities.Kaiju;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kaiju")            // il plurale “kaiju” resta invariato
public class KaijuController
{
	@Autowired
	private KaijuDao dao;

	// ── CRUD ──────────────────────────────────────────────────────────────

	@GetMapping
	public List<Kaiju> getAll()
	{
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Kaiju getOne(@PathVariable Long id)
	{
		return dao.findById(id).orElse(null);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Kaiju insert(@RequestBody Kaiju k)
	{
		return dao.save(k);
	}

	@PutMapping("/{id}")
	public Kaiju modify(@PathVariable Long id, @RequestBody Kaiju k)
	{
		k.setId(id);
		return dao.save(k);
	}

	@DeleteMapping("/{id}")
	public Kaiju delete(@PathVariable Long id)
	{
		Kaiju k = dao.findById(id).orElse(null);
		if (k == null)
			throw new MostroInesistenteException("Il kaiju con id " + id + " non esiste");

		dao.delete(k);
		return k;
	}
}
