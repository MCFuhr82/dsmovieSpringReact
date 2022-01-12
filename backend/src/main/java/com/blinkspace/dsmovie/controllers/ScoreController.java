/* Classe que irá implementar um endpoint. É o endereço que vai acessar do navegador ou do Postman */

package com.blinkspace.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blinkspace.dsmovie.dto.MovieDTO;
import com.blinkspace.dsmovie.dto.ScoreDTO;
import com.blinkspace.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {//anotação para pegar o corpo da requisição
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}
	
	
}
