package com.generation.templaterest.model.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Fiera extends Mostro
{
	private boolean commestibile;
	private double peso;
}
