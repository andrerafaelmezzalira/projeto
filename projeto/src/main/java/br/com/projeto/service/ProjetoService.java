package br.com.projeto.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.projeto.domain.Pessoa;
import br.com.projeto.domain.Projeto;
import br.com.projeto.domain.Status;
import br.com.projeto.exception.CamposObrigatoriosException;
import br.com.projeto.exception.InserePessoaException;
import br.com.projeto.exception.StatusProjetoException;
import br.com.projeto.repository.ProjetoRepository;

@Stateless
public class ProjetoService {

	@Inject
	private ProjetoRepository repository;

	@Inject
	private PessoaService service;

	public List<Projeto> listar() {
		return repository.listAll();
	}

	public void salvar(Projeto projeto) throws CamposObrigatoriosException, InserePessoaException {

		// valida os campos obrigatorios

		boolean nomeValido = projeto.getNome() != null && !"".equals(projeto.getNome());
		boolean statusValido = projeto.getStatus() != null;

		if (!nomeValido || !statusValido) {
			throw new CamposObrigatoriosException("Existem campos obrigatórios");
		}

		// valida se as pessoas sao apenas funcionarios
		if (projeto.getPessoas() != null && !projeto.getPessoas().isEmpty()) {
			for (Pessoa pessoa : projeto.getPessoas()) {
				if (pessoa.getId() == null) {
					throw new InserePessoaException("Pessoa não existe no banco");
				}

				pessoa = service.find(pessoa.getId());

				if (pessoa == null) {
					throw new InserePessoaException("Pessoa não existe no banco");
				}

				if (!pessoa.getFuncionario()) {
					throw new InserePessoaException("Pessoa não é um funcionario");
				}
			}
		}

		if (projeto.getId() != null) {
			repository.update(projeto);
		} else {
			repository.insert(projeto);
		}
	}

	public Projeto excluir(Integer id) throws StatusProjetoException {
		Projeto projeto = repository.findById(id);

		if (Status.INICIADO.equals(projeto.getStatus()) || Status.EM_ANDAMENTO.equals(projeto.getStatus())
				|| Status.ENCERRADO.equals(projeto.getStatus())) {
			throw new StatusProjetoException("Não pode remover o projeto para o status atual");
		}

		return repository.delete(projeto);
	}

}