package br.com.projeto.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.projeto.domain.Pessoa;
import br.com.projeto.exception.CamposObrigatoriosException;
import br.com.projeto.repository.PessoaRepository;

@Stateless
public class PessoaService {

	@Inject
	private PessoaRepository repository;

	public Pessoa salvar(Pessoa pessoa) throws CamposObrigatoriosException {

		boolean nomeValido = pessoa.getNome() != null && !"".equals(pessoa.getNome());
		boolean funcionarioValido = pessoa.getFuncionario() != null;

		if (!nomeValido || !funcionarioValido) {
			throw new CamposObrigatoriosException("Existem campos obrigatórios");
		}

		return repository.insert(pessoa);
	}

	public List<Pessoa> listarFuncionarios() {
		return repository.listarFuncionarios();
	}

	public Pessoa find(Integer id) {
		return repository.findById(id);
	}
}