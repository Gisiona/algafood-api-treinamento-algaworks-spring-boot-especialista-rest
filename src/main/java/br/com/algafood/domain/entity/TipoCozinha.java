package br.com.algafood.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder @ToString @Getter
@Entity
@Table(name = "tipo_cozinha")
public class TipoCozinha {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uuidTipoCozinha;
	
	@Column(name = "nome_tipo_cozinha", length = 50)
	private String nomeTipoCozinha;	
	
	
	public TipoCozinha(Long uuidTipoCozinha, String nomeTipoCozinha) {
		super();
		this.uuidTipoCozinha = uuidTipoCozinha;
		this.nomeTipoCozinha = nomeTipoCozinha;
	}
	
	public TipoCozinha(String nomeTipoCozinha) {
		super();
		this.nomeTipoCozinha = nomeTipoCozinha;
	}

	public TipoCozinha() {}
	
}
