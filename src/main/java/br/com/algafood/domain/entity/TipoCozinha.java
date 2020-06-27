package br.com.algafood.domain.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoCozinha")
public class TipoCozinha {

	@Id
	@Column(name = "codigo")
	private UUID uuidTipoCozinha;
	
	@Column(name = "nome_tipo_cozinha")
	private String nomeTipoCozinha;	
	
	
	public TipoCozinha(UUID uuidTipoCozinha, String nomeTipoCozinha) {
		super();
		this.uuidTipoCozinha = uuidTipoCozinha;
		this.nomeTipoCozinha = nomeTipoCozinha;
	}
	
	public TipoCozinha(String nomeTipoCozinha) {
		super();
		this.nomeTipoCozinha = nomeTipoCozinha;
	}


	public UUID getUuidTipoCozinha() {
		return uuidTipoCozinha;
	}

	public String getNomeTipoCozinha() {
		return nomeTipoCozinha;
	}
	
}
