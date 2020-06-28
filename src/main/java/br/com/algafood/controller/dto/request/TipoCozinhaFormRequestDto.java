package br.com.algafood.controller.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TipoCozinhaFormRequestDto {

	@NotEmpty(message = "O campo [nome_tipo_cozinha] não pode ser nulo.")
	@NotNull(message = "O campo [nome_tipo_cozinha] não pode ser nulo.")
	@JsonProperty("nome_tipo_cozinha")
	private String nomeTipoCozinha;	
}
