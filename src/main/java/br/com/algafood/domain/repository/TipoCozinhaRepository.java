package br.com.algafood.domain.repository;

import java.util.List;

import br.com.algafood.domain.entity.TipoCozinha;

public interface TipoCozinhaRepository {

	List<TipoCozinha> listaTodos();
	TipoCozinha adicionar(TipoCozinha cozinha);
	TipoCozinha atualizar(TipoCozinha cozinha);
	void remover(TipoCozinha cozinha);
	TipoCozinha buscarPorId(Long id);
}
