package br.com.algafood.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurante")
public class Restaurante {

	@Id
	@Column(name = "codigo")
	private UUID uuidRestaurante;
	
	@Column(name = "nome_restaurante")
	private String nomeRestaurante;
	
	@Column(name = "taxa_frete")
	private BigDecimal TaxaFrete;

	public Restaurante(UUID uuidRestaurante, String nomeRestaurante, BigDecimal taxaFrete) {
		super();
		this.uuidRestaurante = uuidRestaurante;
		this.nomeRestaurante = nomeRestaurante;
		TaxaFrete = taxaFrete;
	}
	
	public Restaurante(String nomeRestaurante, BigDecimal taxaFrete) {
		super();
		this.nomeRestaurante = nomeRestaurante;
		TaxaFrete = taxaFrete;
	}

	public UUID getUuidRestaurante() {
		return uuidRestaurante;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public BigDecimal getTaxaFrete() {
		return TaxaFrete;
	}
		
}
