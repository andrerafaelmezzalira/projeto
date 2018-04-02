package br.com.projeto.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.projeto.domain.Pessoa;
import br.com.projeto.exception.CamposObrigatoriosException;
import br.com.projeto.repository.PessoaRepository;

/**
 * Representa o servico que representa a entidade Pessoa
 * 
 * @author andrerafaelmezzalira
 *
 */
@Stateless
public class PessoaService {

	@Inject
	private PessoaRepository repository;

	/**
	 * Metodo responsavel por efetuar as validacoes e gravar um objeto pessoa
	 * 
	 * @param pessoa
	 * @return
	 * @throws CamposObrigatoriosException
	 */
	public Pessoa salvar(Pessoa pessoa) throws CamposObrigatoriosException {

		boolean nomeValido = pessoa.getNome() != null && !"".equals(pessoa.getNome());
		boolean funcionarioValido = pessoa.getFuncionario() != null;

		if (!nomeValido || !funcionarioValido) {
			throw new CamposObrigatoriosException("Existem campos obrigatórios");
		}

		return repository.insert(pessoa);
	}

	/**
	 * Retorna uma lista de funcionarios
	 * 
	 * @return
	 */
	public List<Pessoa> listarFuncionarios() {
		return repository.listarFuncionarios();
	}

	/**
	 * Obtem uma pessoa pelo seu id
	 * 
	 * @param id
	 * @return
	 */
	public Pessoa find(Integer id) {
		return repository.findById(id);
	}
}