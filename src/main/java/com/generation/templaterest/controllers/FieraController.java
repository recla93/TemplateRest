package com.generation.templaterest.controllers;

import com.generation.templaterest.controllers.exceptions.MostroInesistenteException;
import com.generation.templaterest.model.dao.FieraDao;
import com.generation.templaterest.model.entities.Fiera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fiere")            // es.: /api/fiere/…
public class FieraController
{
	@Autowired
	private FieraDao dao;

	// ── CRUD ──────────────────────────────────────────────────────────────

	@GetMapping
	public List<Fiera> getAll()
	{
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Fiera getOne(@PathVariable Long id)
	{
		return dao.findById(id).orElse(null);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Fiera insert(@RequestBody Fiera f)
	{
		return dao.save(f);
	}

	@PutMapping("/{id}")
	public Fiera modify(@PathVariable Long id, @RequestBody Fiera f)
	{
		f.setId(id);
		return dao.save(f);
	}

	@DeleteMapping("/{id}")
	public Fiera delete(@PathVariable Long id)
	{
		Fiera f = dao.findById(id).orElse(null);
		if (f == null)
			throw new MostroInesistenteException("La fiera con id " + id + " non esiste");

		dao.delete(f);
		return f;
	}
}
