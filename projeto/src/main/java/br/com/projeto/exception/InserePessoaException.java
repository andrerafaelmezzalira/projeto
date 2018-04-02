package br.com.projeto.exception;

/**
 * Representa uma excecao para cadastro de pessoas
 * 
 * @author andrerafaelmezzalira
 *
 */
public class InserePessoaException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Mensagem definida para excecao
	 * 
	 * @param message
	 */
	public InserePessoaException(String message) {
		super(message);
	}
}
