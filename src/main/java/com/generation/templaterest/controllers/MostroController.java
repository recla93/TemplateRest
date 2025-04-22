package com.generation.templaterest.controllers;

import com.generation.templaterest.model.dao.FieraDao;
import com.generation.templaterest.model.dao.MostroDao;
import com.generation.templaterest.model.entities.Fiera;
import com.generation.templaterest.model.entities.Mostro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mostri")
public class MostroController
{
	@Autowired
	private MostroDao dao;

	@GetMapping
	public List<Mostro> getAll()
	{
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Mostro getOne(@PathVariable Long id)
	{
		return dao.findById(id).orElse(null);
	}
}
