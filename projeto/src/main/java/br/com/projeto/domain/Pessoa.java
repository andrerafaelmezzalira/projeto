package br.com.projeto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.com.projeto.arq.AbstractEntity;

@Entity
@NamedQueries({
		@NamedQuery(name = Pessoa.LISTAR_FUNCIONARIOS, query = "select p from Pessoa p where p.funcionario = true order by p.nome"), })
public class Pessoa implements AbstractEntity<Integer> {

	private static final long serialVersionUID = 1L;
	public static final String LISTAR_FUNCIONARIOS = "listarFuncionarios";

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
