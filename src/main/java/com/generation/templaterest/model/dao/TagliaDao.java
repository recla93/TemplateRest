package com.generation.templaterest.model.dao;

import com.generation.templaterest.model.entities.Mostro;
import com.generation.templaterest.model.entities.Taglia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagliaDao extends JpaRepository<Taglia,Long>
{
//	List<Taglia> findAllByBersaglio_Id(Long );
}
