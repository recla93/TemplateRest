package com.generation.templaterest.model.dao;

import com.generation.templaterest.model.entities.Drago;
import com.generation.templaterest.model.entities.Mostro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DragoDao extends JpaRepository<Drago,Long>
{
}
