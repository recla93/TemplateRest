package com.generation.templaterest.model.dao;

import com.generation.templaterest.model.entities.Mostro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MostroDao extends JpaRepository<Mostro,Long>
{
	Long id(Long id);
}
