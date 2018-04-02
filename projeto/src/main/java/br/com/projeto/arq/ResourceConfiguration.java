package br.com.projeto.arq;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Mapeia que todas as rotas deverao acessar a aplicacao atraves do mapeador
 * 'resources'
 * 
 * @author andrerafaelmezzalira
 *
 */
@ApplicationPath("resources")
public class ResourceConfiguration extends Application {

}
