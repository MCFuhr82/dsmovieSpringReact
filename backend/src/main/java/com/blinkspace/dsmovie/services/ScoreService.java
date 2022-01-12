package com.blinkspace.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blinkspace.dsmovie.dto.MovieDTO;
import com.blinkspace.dsmovie.dto.ScoreDTO;
import com.blinkspace.dsmovie.entities.Movie;
import com.blinkspace.dsmovie.entities.Score;
import com.blinkspace.dsmovie.entities.User;
import com.blinkspace.dsmovie.repositories.MovieRepository;
import com.blinkspace.dsmovie.repositories.ScoreRepository;
import com.blinkspace.dsmovie.repositories.UserRepository;

/* @Service = anotação para registrar o MovieService como sendo um componente do sistema.
 * Esse registro de componente é necessário quando a classe é customizada  */

@Service
public class ScoreService {

	@Autowired //anotação para injeção de dependencia. Não precisa instanciar com "new MovieRepository()"
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}
