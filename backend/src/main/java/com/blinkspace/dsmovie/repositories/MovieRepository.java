package com.blinkspace.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkspace.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	
}
