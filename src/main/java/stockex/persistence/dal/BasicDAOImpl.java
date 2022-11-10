package stockex.persistence.dal;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class BasicDAOImpl<T> implements BasicDAO<T>{

	@Inject
	protected EntityManager entityManager;

	@Override
	public T save(T entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	@Override
	public T findById(Class<T> clazz, Serializable id) {
		return this.entityManager.find(clazz, id);
	}

	@Override
	public List<T> findAll(Class<T> clazz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		cq.from(clazz);
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public T update(T entity) {
		return this.entityManager.merge(entity);		
	}
}

