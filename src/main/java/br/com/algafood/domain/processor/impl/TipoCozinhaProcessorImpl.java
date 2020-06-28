package br.com.algafood.domain.processor.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.algafood.controller.dto.request.TipoCozinhaFormRequestDto;
import br.com.algafood.controller.dto.response.TipoCozinhaFormResponseDto;
import br.com.algafood.domain.entity.TipoCozinha;
import br.com.algafood.domain.processor.TipoCozinhaProcessor;
import br.com.algafood.domain.repository.TipoCozinhaRepository;
import br.com.algafood.exception.RecursoNaoEncontradoException;

@Component
public class TipoCozinhaProcessorImpl implements TipoCozinhaProcessor{

	@Autowired
	private TipoCozinhaRepository cozinhaRepository;
	
	
	public List<TipoCozinhaFormResponseDto> listar() {
		List<TipoCozinha> cozinhas = cozinhaRepository.listaTodos();
		
		List<TipoCozinhaFormResponseDto> responses = new ArrayList<TipoCozinhaFormResponseDto>();
		
		for (TipoCozinha tipoCozinha : cozinhas) {
			TipoCozinhaFormResponseDto response = TipoCozinhaFormResponseDto.builder()
					.codigoTipoCozinha(tipoCozinha.getUuidTipoCozinha())
					.nomeTipoCozinha(tipoCozinha.getNomeTipoCozinha()).build();
			responses.add(response);
		}							
		return responses;		
	}

	@Override
	public TipoCozinhaFormResponseDto listarPorId(Long id) {
		TipoCozinha cozinha = cozinhaRepository.buscarPorId(id);
		TipoCozinhaFormResponseDto response = TipoCozinhaFormResponseDto.builder()
				.codigoTipoCozinha(cozinha.getUuidTipoCozinha())
				.nomeTipoCozinha(cozinha.getNomeTipoCozinha()).build();
		return response;
	}

	@Override
	public TipoCozinhaFormResponseDto adicionar(TipoCozinhaFormRequestDto request) {
		TipoCozinha cozinha = cozinhaRepository.adicionar(new TipoCozinha(request.getNomeTipoCozinha()));
		TipoCozinhaFormResponseDto response = TipoCozinhaFormResponseDto.builder()
				.codigoTipoCozinha(cozinha.getUuidTipoCozinha())
				.nomeTipoCozinha(cozinha.getNomeTipoCozinha()).build();
		return response;
	}

	public TipoCozinhaFormResponseDto atualizar(TipoCozinhaFormRequestDto request, Long id) {
		TipoCozinha cozinha = cozinhaRepository.atualizar(new TipoCozinha(id, request.getNomeTipoCozinha()));
		TipoCozinhaFormResponseDto response = TipoCozinhaFormResponseDto.builder()
				.codigoTipoCozinha(cozinha.getUuidTipoCozinha())
				.nomeTipoCozinha(cozinha.getNomeTipoCozinha())
				.build();
		return response;
	}

	@Override
	public void remover(Long id) throws RecursoNaoEncontradoException {		
		try {
			TipoCozinha cozinha = cozinhaRepository.buscarPorId(id);
			if(cozinha != null) {
				cozinhaRepository.remover(cozinha);
			}else {
				throw new RecursoNaoEncontradoException();
			}
		} catch (Exception e) {
			throw new RecursoNaoEncontradoException();
		}		
	}	
}
