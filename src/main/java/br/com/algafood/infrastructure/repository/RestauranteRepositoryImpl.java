package br.com.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.algafood.domain.entity.Restaurante;
import br.com.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listaTodos() {		
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante adicionar(Restaurante restaurante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurante atualizar(Restaurante restaurante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Restaurante restaurante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Restaurante buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
