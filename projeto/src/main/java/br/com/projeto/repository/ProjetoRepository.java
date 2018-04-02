package br.com.projeto.repository;

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

}