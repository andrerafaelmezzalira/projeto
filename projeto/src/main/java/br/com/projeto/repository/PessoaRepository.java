package br.com.projeto.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.projeto.arq.AbstractRepository;
import br.com.projeto.domain.Pessoa;

/**
 * Representa o acesso a tabela pessoa no banco de dados
 * 
 * @author andrerafaelmezzalira
 *
 */
public class PessoaRepository extends AbstractRepository<Pessoa> {

	public PessoaRepository() {
		super(Pessoa.class);
	}

	/**
	 * Traz uma lista de funcionarios da tabela pessoa (q tenha o boolean
	 * funcionario igual a true
	 * 
	 * @return
	 */
	public List<Pessoa> listarFuncionarios() {
		TypedQuery<Pessoa> typedQuery = getEntityManager().createNamedQuery(Pessoa.LISTAR_FUNCIONARIOS, Pessoa.class);
		return typedQuery.getResultList();
	}

}