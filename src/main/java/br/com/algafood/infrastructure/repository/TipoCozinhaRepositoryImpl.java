package br.com.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.algafood.domain.entity.TipoCozinha;
import br.com.algafood.domain.repository.TipoCozinhaRepository;

@Component
public class TipoCozinhaRepositoryImpl implements TipoCozinhaRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<TipoCozinha> listaTodos() {
		return manager.createQuery("from TipoCozinha", TipoCozinha.class)
				.getResultList();
	}

	@Override
	@Transactional
	public TipoCozinha adicionar(TipoCozinha cozinha) {
		return manager.merge(cozinha);
	}

	@Override
	@Transactional
	public TipoCozinha atualizar(TipoCozinha cozinha) {
		return manager.merge(cozinha);	
	}

	@Override
	@Transactional
	public void remover(TipoCozinha cozinha) {
		cozinha = buscarPorId(cozinha.getUuidTipoCozinha());
		manager.remove(cozinha);
	}

	@Override
	public TipoCozinha buscarPorId(Long id) {
		return manager.find(TipoCozinha.class, id);	
	}

}
