/* Reponsável por fazer a transação de buscar os filmes */

package com.blinkspace.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blinkspace.dsmovie.dto.MovieDTO;
import com.blinkspace.dsmovie.entities.Movie;
import com.blinkspace.dsmovie.repositories.MovieRepository;

/* @Service = anotação para registrar o MovieService como sendo um componente do sistema.
 * Esse registro de componente é necessário quando a classe é customizada  */

@Service
public class MovieService {

	@Autowired //anotação para injeção de dependencia. Não precisa instanciar com "new MovieRepository()"
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) { 
		//a resposta do método tem que ser uma lista de MovieDTO, e não de Movie
		//List<Movie> result = repository.findAll(); //o serviço conversa com o banco de dados atráves de entidade. Por isso que é uma lista de Movie.
		Page<Movie> result = repository.findAll(pageable);
		/* essa anotação do Pageable e page é interessante porque como o frontend está separando os filmes por páginas, 
		 * a aplicação findAll não irá buscar todos os filmes que estão no banco de dados, mas somente aqueles que 
		 * estão aparecendo na página do frontend. Conforme passa para outra página, o findAll automaticamente muda.
		 * Se não fosse desta forma, onde está Page mudaria para List e não precisava colocar o argumento no método.
		 */
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x)); //funçao de alta ordem
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
}
