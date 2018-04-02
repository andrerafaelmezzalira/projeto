package br.com.projeto.arq;

import java.io.Serializable;

/**
 * Representa uma entidade do banco de dados
 * 
 * @author andrerafaelmezzalira
 *
 * @param <T>
 */
public interface AbstractEntity<T> extends Serializable {

	/**
	 * obtem o id
	 * 
	 * @return
	 */
	T getId();

	/**
	 * seta o id
	 * 
	 * @param id
	 */
	void setId(T id);

}
