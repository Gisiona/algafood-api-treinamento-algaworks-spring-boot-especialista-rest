package br.com.algafood.domain.repository;

import java.util.List;

import br.com.algafood.domain.entity.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> listaTodos();
	Restaurante adicionar(Restaurante restaurante);
	Restaurante atualizar(Restaurante restaurante);
	void remover(Restaurante restaurante);
	Restaurante buscarPorId(Long id);
}
