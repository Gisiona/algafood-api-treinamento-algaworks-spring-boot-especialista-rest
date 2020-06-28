package br.com.algafood.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class TipoCozinhaFormResponseDto {
	
	@JsonProperty("codigo_tipo_cozinha")
	private Long codigoTipoCozinha;	
	
	@JsonProperty("nome_tipo_cozinha")
	private String nomeTipoCozinha;	
}
