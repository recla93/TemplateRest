package com.generation.templaterest.model.entities;

import com.generation.templaterest.model.entities.enums.Elemento;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Drago extends Mostro
{
	private Elemento elemento;
	private boolean volante;
}
