package br.com.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.algafood.AlgafoodApiTreinamentoAlgaworksApplication;
import br.com.algafood.domain.entity.TipoCozinha;
import br.com.algafood.domain.repository.TipoCozinhaRepository;

public class TipoCozinhaRepositoryMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiTreinamentoAlgaworksApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		TipoCozinhaRepository cozinhaRepository = context.getBean(TipoCozinhaRepository.class);
		
		List<TipoCozinha> cozinhas = cozinhaRepository.listaTodos();
		
		for (TipoCozinha tipo : cozinhas) {
			System.out.println(tipo.getUuidTipoCozinha() + " - "+ tipo.getNomeTipoCozinha());
		}
		
		TipoCozinha cozinha = new TipoCozinha("Paraguaia");
		cozinhaRepository.adicionar(cozinha);
		
		TipoCozinha cozinhaBusca = cozinhaRepository.buscarPorId(5L);
		System.out.println(cozinhaBusca.getUuidTipoCozinha() + " - " +  cozinhaBusca.getNomeTipoCozinha());
	
		TipoCozinha cozinhaChilena = new TipoCozinha(1L,  "Chilena");
		cozinhaRepository.atualizar(cozinhaChilena);
		
		cozinhaRepository.remover(cozinhaChilena);
	}
}
