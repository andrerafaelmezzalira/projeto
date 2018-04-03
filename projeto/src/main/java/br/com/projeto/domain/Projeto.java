package br.com.projeto.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.com.projeto.arq.AbstractEntity;

/**
 * Representa a entidae Projeto no banco de dados
 * 
 * @author andrerafaelmezzalira
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = Projeto.LISTAR, query = "select p from Projeto p order by p.nome"), })
public class Projeto implements AbstractEntity<Integer> {

	private static final long serialVersionUID = 1L;
	public static final String LISTAR = "listar";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nome;

	private Integer status;

	@ManyToOne
	private Pessoa gerente;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Pessoa> funcionarios;

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

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setGerente(Pessoa gerente) {
		this.gerente = gerente;
	}

	public Pessoa getGerente() {
		return gerente;
	}

	public void setFuncionarios(List<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pessoa> getFuncionarios() {
		return funcionarios;
	}
}
