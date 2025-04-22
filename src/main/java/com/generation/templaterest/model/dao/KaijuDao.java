package com.generation.templaterest.model.dao;

import com.generation.templaterest.model.entities.Kaiju;
import com.generation.templaterest.model.entities.Mostro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaijuDao extends JpaRepository<Kaiju,Long>
{
}
