package br.com.algafood.domain.processor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.algafood.domain.entity.Restaurante;
import br.com.algafood.domain.processor.RestauranteProcessor;
import br.com.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteProcessorImlp implements RestauranteProcessor{

	@Autowired
	private RestauranteRepository restauranteReposity;
	
	@Override
	public List<Restaurante> listar() {
		return restauranteReposity.listaTodos();
	}

}
