package com.generation.templaterest.model.entities;

import com.generation.templaterest.model.entities.enums.Pericolosita;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
//La avremo una singola tabella chiamata Mostro che conterrà i dati
//di tutte le sottoclassi
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public abstract class Mostro extends BaseEntity
{
	private String nome,ubicazione;

	@Enumerated(EnumType.STRING)
	private Pericolosita pericolosita;

	@OneToMany(mappedBy = "bersaglio",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Taglia> taglie = new ArrayList<>();

	public boolean isAbbattuto()
	{
		for(Taglia t:taglie)
			if(t.isCompletata())
				return true;

		return false;
	}
}
