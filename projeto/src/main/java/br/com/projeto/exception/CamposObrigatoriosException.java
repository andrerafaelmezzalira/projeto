package br.com.projeto.exception;

/**
 * Representa a excecao para campos obrigatorios
 * 
 * @author andrerafaelmezzalira
 *
 */
public class CamposObrigatoriosException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Mensagem definida para excecao
	 * 
	 * @param message
	 */
	public CamposObrigatoriosException(String message) {
		super(message);
	}
}
