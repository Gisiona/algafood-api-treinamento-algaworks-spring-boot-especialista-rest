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
@Table(name = "permissao")
public class Permissao {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPermissao;
	
	@Column(name = "nome_permissao", length = 30, nullable = false)
	private String nomePermissao;	
	
	@Column(name = "descricao_permissao", length = 50, nullable = false)
	private String descricaoPermissao;	
}
