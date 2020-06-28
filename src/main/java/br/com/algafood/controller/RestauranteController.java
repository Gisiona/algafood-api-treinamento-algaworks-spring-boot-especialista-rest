package br.com.algafood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.algafood.domain.entity.Restaurante;
import br.com.algafood.domain.entity.TipoCozinha;
import br.com.algafood.domain.processor.RestauranteProcessor;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteProcessor restauranteProcessor;
	
	@GetMapping()
	private List<Restaurante> listar(){		
		return restauranteProcessor.listar();
	}
}
