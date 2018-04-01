package br.com.projeto.resource;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import br.com.projeto.domain.Pessoa;
import br.com.projeto.exception.CamposObrigatoriosException;
import br.com.projeto.service.PessoaService;

@Path("/pessoa")
public class PessoaResource {

	Logger log = Logger.getLogger(this.getClass().getName());

	@Inject
	private PessoaService service;

	@POST
	public Response insert(Pessoa pessoa) {

		log.info(" rodando método insert(Pessoa pessoa)  ");

		try {
			service.salvar(pessoa);

			log.info(" pessoa de id  " + pessoa.getId() + " criada com sucesso ");

			return Response.ok().entity(pessoa).build();
		} catch (CamposObrigatoriosException e) {
			return Response.ok().entity(e.getMessage()).build();
		}

	}
}
