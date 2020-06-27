package br.com.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.algafood.AlgafoodApiTreinamentoAlgaworksApplication;
import br.com.algafood.domain.entity.TipoCozinha;

public class TipoCozinhaJpaMain {

	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiTreinamentoAlgaworksApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		TipoCozinhaJpa cozinhaJpa = context.getBean(TipoCozinhaJpa.class);
		
		List<TipoCozinha> cozinhas = cozinhaJpa.listarTodos();
		
		for (TipoCozinha tipo : cozinhas) {
			System.out.println(tipo.getUuidTipoCozinha() + " - "+ tipo.getNomeTipoCozinha());
		}
		
		TipoCozinha cozinha = new TipoCozinha("Paraguaia");
		cozinhaJpa.adicionar(cozinha);
		
		TipoCozinha cozinhaBusca = cozinhaJpa.buscarPorId(5L);
		System.out.println(cozinhaBusca.getUuidTipoCozinha() + " - " +  cozinhaBusca.getNomeTipoCozinha());
	
		TipoCozinha cozinhaChilena = new TipoCozinha(1L,  "Chilena");
		cozinhaJpa.atualizar(cozinhaChilena);
		
		cozinhaJpa.remover(cozinhaChilena);
	}
}
