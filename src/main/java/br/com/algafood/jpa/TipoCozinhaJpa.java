package br.com.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.algafood.domain.entity.TipoCozinha;

@Component
public class TipoCozinhaJpa {

	@PersistenceContext
	private EntityManager manager;
	
	public List<TipoCozinha> listarTodos() {
		return manager.createQuery("from TipoCozinha", TipoCozinha.class)
				.getResultList();
	}
	
	@Transactional
	public TipoCozinha adicionar(TipoCozinha cozinha) {
		return manager.merge(cozinha);		
	}
	
	public TipoCozinha buscarPorId(Long id) {
		return manager.find(TipoCozinha.class, id);		
	}
	
	@Transactional
	public TipoCozinha atualizar(TipoCozinha cozinha) {
		return manager.merge(cozinha);		
	}
	
	@Transactional
	public void remover(TipoCozinha cozinha) {
		cozinha = buscarPorId(cozinha.getUuidTipoCozinha());
		manager.remove(cozinha);		
	}
}

