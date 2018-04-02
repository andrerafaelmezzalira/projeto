package br.com.projeto.exception;

/**
 * Representa uma excecao dependendo do tipo de status para remoção de projetos
 * 
 * @author andrerafaelmezzalira
 *
 */
public class StatusProjetoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Mensagem definida para excecao
	 * 
	 * @param message
	 */
	public StatusProjetoException(String message) {
		super(message);
	}
}
