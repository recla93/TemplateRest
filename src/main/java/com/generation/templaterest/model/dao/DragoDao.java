package com.generation.templaterest.model.dao;

import com.generation.templaterest.model.entities.Drago;
import com.generation.templaterest.model.entities.Mostro;
import com.generation.templaterest.model.entities.enums.Elemento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DragoDao extends JpaRepository<Drago,Long>
{

	List<Drago> findAllByElemento(Elemento elemento);
}
