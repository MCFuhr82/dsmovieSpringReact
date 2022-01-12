package com.blinkspace.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score { //quando tem uma associação de muitos para muitos entre classe, fazer uma outra classe para associa-las

	@EmbeddedId //anotação para chave primária quando a chave é composta
	private ScorePK id = new ScorePK(); //quando tem uma chave composta no Java, instanciar com new
	private Double value;
	
	public Score() {
	}

	public void setMovie(Movie movie) { //criado na mão para associar o filme ao score
		id.setMovie(movie);
	}
	
	public void setUser(User user) { //criado na mão para associar o usuário ao score
		id.setUser(user);
	}
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
