package com.generation.templaterest.model.entities;

import com.generation.templaterest.model.entities.enums.Elemento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Entity
@Data
public class Drago extends Mostro
{
	@Enumerated(EnumType.STRING)
	private Elemento elemento;
	private boolean volante;
}
