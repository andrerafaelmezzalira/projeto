package br.com.projeto.repository;

import br.com.projeto.arq.AbstractRepository;
import br.com.projeto.domain.Projeto;

public class ProjetoRepository extends AbstractRepository<Projeto> {

	public ProjetoRepository() {
		super(Projeto.class);
	}

}