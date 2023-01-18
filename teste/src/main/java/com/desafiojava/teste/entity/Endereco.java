package com.desafiojava.teste.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco  implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "cep")
	private String cep;
	@Column(name = "numero")
	private String numero;
	@Column(name = "cidade")
	private String cidade;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pessoa_id",referencedColumnName = "id")
	private Pessoa pessoa;
	
  	public Endereco(Long id, String logradouro, String cep, String numero, String cidade,Pessoa pessoa) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.pessoa = pessoa;
	}

	public Endereco() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public Pessoa getIdPessoa() {
		return pessoa;
	}

	public void setIdPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	  	 	
	

}
