package br.com.projeto.arq;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Disponibiliza o ojbeto de acesso ao banco de dados (entitymanager) e
 * representa as principais operacoes de banco de dados (insert, update, delete,
 * find by id e listall)
 * 
 * @author andrerafaelmezzalira
 *
 * @param <T>
 */
public class AbstractRepository<T extends AbstractEntity<?>> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> entityClass;

	/**
	 * seta o objeto do tipo AbstractEntity
	 * 
	 * @param entityClass
	 */
	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	private Class<T> getEntityClass() {
		return this.entityClass;
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * Insere um registro do tipo AbstractEntity
	 * 
	 * @param entity
	 * @return
	 */
	public T insert(T entity) {
		entityManager.persist(entity);
		entityManager.flush();

		return entity;
	}

	/**
	 * Altera um objeto do tipo AbstractEntity
	 * 
	 * @param entity
	 * @return
	 */
	public T update(T entity) {
		entityManager.merge(entity);
		entityManager.flush();

		return entity;
	}

	/**
	 * Remove um objeto do tipo AbstractEntity
	 * 
	 * @param entity
	 * @return
	 */
	public T delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		entityManager.flush();

		return entity;
	}

	/**
	 * Obtem um objeto do tipo AbstractEntity pelo seu id
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Serializable id) {
		return entityManager.find(getEntityClass(), id);
	}

	/**
	 * Lista todos os registros de uma tabela definido pelo tipo AbstractEntity
	 * chamador
	 * 
	 * @return
	 */
	public List<T> listAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(getEntityClass());
		Root<T> c = q.from(getEntityClass());
		TypedQuery<T> tq = entityManager.createQuery(q.select(c));
		return tq.getResultList();
	}
}
