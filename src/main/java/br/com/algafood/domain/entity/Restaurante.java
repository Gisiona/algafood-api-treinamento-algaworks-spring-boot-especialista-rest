package br.com.algafood.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name = "Restaurante")
public class Restaurante {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uuidRestaurante;
	
	@Column(name = "nome_restaurante")
	private String nomeRestaurante;
	
	@Column(name = "taxa_frete")
	private BigDecimal TaxaFrete;

	@ManyToOne
	private TipoCozinha tipoCozinha;

	public Restaurante(Long uuidRestaurante, String nomeRestaurante, BigDecimal taxaFrete) {
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
		
	public Restaurante() {}
}
