package br.com.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.algafood.AlgafoodApiTreinamentoAlgaworksApplication;
import br.com.algafood.domain.entity.Restaurante;
import br.com.algafood.domain.repository.RestauranteRepository;

public class RestauranteRepositoryMain {

	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiTreinamentoAlgaworksApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		RestauranteRepository restauranteRepository = context.getBean(RestauranteRepository.class);
		
		List<Restaurante> restaurantes = restauranteRepository.listaTodos();
		
		for (Restaurante restaurante : restaurantes) {
			System.out.println(restaurante.getUuidRestaurante() + " - " +  restaurante.getNomeRestaurante() + " - " + restaurante.getTaxaFrete() + " - " + restaurante.getTipoCozinha().getNomeTipoCozinha());
		}
	}
}
