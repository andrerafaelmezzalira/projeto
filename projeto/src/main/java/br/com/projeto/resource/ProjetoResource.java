package br.com.projeto.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.com.projeto.domain.Pessoa;
import br.com.projeto.domain.Projeto;
import br.com.projeto.exception.CamposObrigatoriosException;
import br.com.projeto.exception.InserePessoaException;
import br.com.projeto.exception.StatusProjetoException;
import br.com.projeto.service.PessoaService;
import br.com.projeto.service.ProjetoService;

/**
 * Representa o acesso ao serviço de gestao de projetos
 * 
 * @author andrerafaelmezzalira
 *
 */
@Path("/projeto")
public class ProjetoResource {

	Logger log = Logger.getLogger(this.getClass().getName());

	@Inject
	private ProjetoService projetoService;

	@Inject
	private PessoaService pessoaService;

	/**
	 * Lista todos os projetos
	 * 
	 * @return
	 */
	@GET
	public Response listar() {

		log.info(" rodando método listar()  ");

		List<Projeto> projetos = projetoService.listar();
		List<Pessoa> pessoas = pessoaService.listar();

		Map<String, Object> response = new HashMap<>();
		response.put("projetos", projetos);
		response.put("pessoas", pessoas);

		return Response.ok(response).build();
	}

	/**
	 * Representa a inclusao de um projeto
	 * 
	 * @param projeto
	 * @return
	 */
	@POST
	public Response insert(Projeto projeto) {

		log.info(" rodando método insert(Projeto projeto)  ");
		try {
			projetoService.salvar(projeto);

			log.info(" projeto de id  " + projeto.getId() + " criado com sucesso ");

			return Response.ok().entity(projeto).build();
		} catch (CamposObrigatoriosException | InserePessoaException e) {
			return Response.ok().entity(e.getMessage()).build();
		}

	}

	/**
	 * Representa a alteracao de um projeto
	 * 
	 * @param projeto
	 * @return
	 */
	@PUT
	public Response update(Projeto projeto) {

		log.info(" rodando método update(Projeto projeto)  " + projeto.getId());

		try {
			projetoService.salvar(projeto);

			log.info(" projeto de id  " + projeto.getId() + " alterado com sucesso ");

			return Response.ok().entity(projeto).build();
		} catch (CamposObrigatoriosException | InserePessoaException e) {
			return Response.ok().entity(e.getMessage()).build();
		}
	}

	/**
	 * Representa a exclusao de um projeto
	 * 
	 * @param id
	 * @return
	 */
	@DELETE
	public Response delete(@QueryParam("id") Integer id) {

		log.info(" rodando método delete(@QueryParam(\"id\") Integer id)  " + id);
		try {
			Projeto projeto = projetoService.excluir(id);
			log.info(" projeto de id  " + projeto.getId() + " excluido com sucesso ");
			return Response.ok().entity(projeto).build();
		} catch (StatusProjetoException e) {
			return Response.ok().entity(e.getMessage()).build();
		}

	}
}
