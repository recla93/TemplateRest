package com.generation.templaterest.model.dao;

import com.generation.templaterest.model.entities.Fiera;
import com.generation.templaterest.model.entities.Mostro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieraDao extends JpaRepository<Fiera,Long>
{
}
