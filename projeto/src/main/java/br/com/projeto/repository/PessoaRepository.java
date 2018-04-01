package br.com.projeto.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.projeto.arq.AbstractRepository;
import br.com.projeto.domain.Pessoa;

public class PessoaRepository extends AbstractRepository<Pessoa> {

	public PessoaRepository() {
		super(Pessoa.class);
	}

	public List<Pessoa> listarFuncionarios() {
		TypedQuery<Pessoa> typedQuery = getEntityManager().createNamedQuery(Pessoa.LISTAR_FUNCIONARIOS, Pessoa.class);
		return typedQuery.getResultList();
	}

}