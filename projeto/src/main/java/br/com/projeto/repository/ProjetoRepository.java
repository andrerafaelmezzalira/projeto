package br.com.projeto.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.projeto.arq.AbstractRepository;
import br.com.projeto.domain.Projeto;

/**
 * Representa o acesso a tabela projeto no banco de dados
 * 
 * @author andrerafaelmezzalira
 *
 */
public class ProjetoRepository extends AbstractRepository<Projeto> {

	public ProjetoRepository() {
		super(Projeto.class);
	}

	/**
	 * Traz uma lista de projetos
	 * 
	 * @return
	 */
	public List<Projeto> listar() {
		TypedQuery<Projeto> typedQuery = getEntityManager().createNamedQuery(Projeto.LISTAR, Projeto.class);
		return typedQuery.getResultList();
	}

}