package br.com.projeto.arq;

import java.io.Serializable;

public interface AbstractEntity<T> extends Serializable {

	T getId();

	void setId(T id);

}
