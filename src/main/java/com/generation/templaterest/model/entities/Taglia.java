package com.generation.templaterest.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Taglia extends BaseEntity
{
	private double ricompensa;
	@Column(nullable = false,columnDefinition = "INT CHECK (difficolta BETWEEN 1 AND 5)")
	private int difficolta; //da 1 (basso) a 5(massimo)
	private LocalDate inizio,fine;//quando è stata emessa, quando scade (se fine è null, è eterna)
	private boolean completata;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_bersaglio")
	@JsonIgnore //con questo non mettiamo i dati del padre nel json della taglia
	private Mostro bersaglio;
}
