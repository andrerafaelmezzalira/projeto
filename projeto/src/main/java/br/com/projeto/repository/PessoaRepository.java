package br.com.projeto.repository;

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

}