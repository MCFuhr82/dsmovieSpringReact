package com.blinkspace.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkspace.dsmovie.entities.Score;
import com.blinkspace.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
	
	
}
