package com.generation.templaterest.model.dao;

import com.generation.templaterest.model.entities.Mostro;
import com.generation.templaterest.model.entities.Taglia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagliaDao extends JpaRepository<Taglia,Long>
{
}
