package br.com.algafood.domain.processor;

import java.util.List;

import javax.validation.Valid;

import br.com.algafood.controller.dto.request.TipoCozinhaFormRequestDto;
import br.com.algafood.controller.dto.response.TipoCozinhaFormResponseDto;
import br.com.algafood.exception.RecursoNaoEncontradoException;

public interface TipoCozinhaProcessor {

	List<TipoCozinhaFormResponseDto> listar();

	TipoCozinhaFormResponseDto listarPorId(Long id);

	TipoCozinhaFormResponseDto adicionar(TipoCozinhaFormRequestDto request);

	TipoCozinhaFormResponseDto atualizar(@Valid TipoCozinhaFormRequestDto request, Long id);

	void remover(Long id) throws RecursoNaoEncontradoException;

}
