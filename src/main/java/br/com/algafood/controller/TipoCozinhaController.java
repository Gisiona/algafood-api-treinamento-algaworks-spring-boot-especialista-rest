package br.com.algafood.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.algafood.controller.dto.request.TipoCozinhaFormRequestDto;
import br.com.algafood.controller.dto.response.TipoCozinhaFormResponseDto;
import br.com.algafood.domain.processor.TipoCozinhaProcessor;
import br.com.algafood.exception.RecursoNaoEncontradoException;

@RestController
@RequestMapping("/cozinhas")
public class TipoCozinhaController {

	@Autowired
	private TipoCozinhaProcessor cozinhaProcessor;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<TipoCozinhaFormResponseDto>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(cozinhaProcessor.listar());
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<TipoCozinhaFormResponseDto> listarPorId(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(cozinhaProcessor.listarPorId(id));
	}
	
	@PostMapping()
	private ResponseEntity<TipoCozinhaFormResponseDto> adicionar(@RequestBody @Valid TipoCozinhaFormRequestDto request){
		TipoCozinhaFormResponseDto response = cozinhaProcessor.adicionar(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<TipoCozinhaFormResponseDto> atualizar(@RequestBody @Valid TipoCozinhaFormRequestDto request, @PathVariable("id") Long id){
		TipoCozinhaFormResponseDto response = cozinhaProcessor.atualizar(request, id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> remover(@PathVariable("id") Long id) throws RecursoNaoEncontradoException{
		cozinhaProcessor.remover(id);
		return (ResponseEntity<?>) ResponseEntity.noContent();
	}
}
