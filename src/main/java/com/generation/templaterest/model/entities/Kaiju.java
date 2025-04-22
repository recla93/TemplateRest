package com.generation.templaterest.model.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Kaiju extends Mostro
{
	private double altezza;
	private boolean scaglie;
}
