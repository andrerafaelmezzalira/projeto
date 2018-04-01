package br.com.projeto.arq;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AbstractRepository<T extends AbstractEntity<?>> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> entityClass;

	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	private Class<T> getEntityClass() {
		return this.entityClass;
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	public T insert(T entity) {
		entityManager.persist(entity);
		entityManager.flush();

		return entity;
	}

	public T update(T entity) {
		entityManager.merge(entity);
		entityManager.flush();

		return entity;
	}

	public T delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		entityManager.flush();

		return entity;
	}

	public T findById(Serializable id) {
		return entityManager.find(getEntityClass(), id);
	}

	public List<T> listAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(getEntityClass());
		Root<T> c = q.from(getEntityClass());
		TypedQuery<T> tq = entityManager.createQuery(q.select(c));
		return tq.getResultList();
	}
}
