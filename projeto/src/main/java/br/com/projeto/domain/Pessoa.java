package br.com.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.projeto.arq.AbstractEntity;

/**
 * Representa a entidade pessoa no banco de dados
 * 
 * @author andrerafaelmezzalira
 *
 */
@Entity
public class Pessoa implements AbstractEntity<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private Boolean funcionario;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}

	public Boolean getFuncionario() {
		return funcionario;
	}

	@Override
	public String toString() {
		return "id: " + id + ", nome: " + nome + ", funcionario: " + funcionario;
	}
}
