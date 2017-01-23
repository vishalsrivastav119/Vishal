/**
 * 
 */
package com.cts.tsp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.cts.tsp.domain.BaseEntity;
import com.cts.tsp.dto.PaginatedList;


/**
 * @author Somnath
 *
 * @param <T>
 * @param <PK>
 */
@Repository
public abstract class GenericDAOImpl<T extends BaseEntity, PK extends Serializable> implements GenericDAO<T, PK> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
		type = (Class<T>) paramType.getActualTypeArguments()[0];
	}

	@Override
	public T create(T domainObj) {
		em.persist(domainObj);

		return domainObj;
	}

	@Override
	public T find(PK id) {
		return (T) em.find(type, id);
	}

	@Override
	public T findRef(PK id) {
		return (T) em.getReference(type, id);
	}

	@Override
	public T update(T domainObj) {
		return em.merge(domainObj);
	}

	/**
	 * @param list
	 * @return
	 */
	protected List<T> getNullSafeList(List<T> list) {
		return (list == null) ? new ArrayList<T>(0) : list;
	}

	public List<T> findAll() {
		TypedQuery<T> query = em.createQuery("from " + type.getName(), type);
		return query.getResultList();
	}

	public PaginatedList<T> findAll(Integer offset, Integer limit) {
		TypedQuery<T> query = em.createQuery("from " + type.getName(), type);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		TypedQuery<Long> countQuery = em.createQuery("SELECT count(t) from " + type.getName() + " t", Long.class);
		Long count = countQuery.getSingleResult();

		PaginatedList<T> list = new PaginatedList<T>();
		list.setSize(count);
		list.setObjectList(query.getResultList());
		return list;
	}

	@Override
	public T queryForObject(String queryIdentifier, Map<String, ?> parameterMap) {
		try {
			TypedQuery<T> query = em.createNamedQuery(queryIdentifier, type);
			for (Map.Entry<String, ?> parameter : parameterMap.entrySet()) {
				query.setParameter(parameter.getKey(), parameter.getValue());
			}
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * 
	 * 
	 */
	@Override
	public List<T> queryForList(String queryIdentifier, Map<String, ?> parameterMap) {
		TypedQuery<T> query = em.createNamedQuery(queryIdentifier, type);
		for (Map.Entry<String, ?> parameter : parameterMap.entrySet()) {
			query.setParameter(parameter.getKey(), parameter.getValue());
		}
		return query.getResultList();
	}

	/**
	 * 
	 * 
	 * 
	 */
	@Override
	public <P> List<P> queryForCustomList(String queryIdentifier, Map<String, ?> parameterMap, Class<P> clazz) {
		TypedQuery<P> query = em.createNamedQuery(queryIdentifier, clazz);
		for (Map.Entry<String, ?> parameter : parameterMap.entrySet()) {
			query.setParameter(parameter.getKey(), parameter.getValue());
		}
		return query.getResultList();
	}

	/**
	 * There is semantic connect to the count query. You could write a utility
	 * method to extract the count query from the original JPQL, I did not find
	 * time to do it, but you are welcome to do so. Till such time ensure the
	 * original named query along with the count query is available while
	 * involing this method
	 */
	@Override
	public PaginatedList<T> queryForPaginatedList(String queryIdentifier, Map<String, ?> parameterMap, Integer offset,
			Integer length) {
		PaginatedList<T> paginatedList = new PaginatedList<T>();
		TypedQuery<Long> countQuery = em.createNamedQuery(queryIdentifier + ".count", Long.class);

		TypedQuery<T> query = em.createNamedQuery(queryIdentifier, type);

		for (Map.Entry<String, ?> parameter : parameterMap.entrySet()) {
			query.setParameter(parameter.getKey(), parameter.getValue());
			countQuery.setParameter(parameter.getKey(), parameter.getValue());
		}

		query.setFirstResult(offset);
		query.setMaxResults(length);
		paginatedList.setObjectList(query.getResultList());
		paginatedList.setSize(countQuery.getSingleResult());
		return paginatedList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sfsquares.marketplace.dao.GenericDAO#executeUpdateQuery(java.util.
	 * Map, java.lang.String)
	 */
	@Override
	public Integer executeUpdateQuery(Map<String, ?> parameterMap, String queryIdentifier) {
		Query query = em.createNamedQuery(queryIdentifier);

		for (Map.Entry<String, ?> parameter : parameterMap.entrySet()) {
			query.setParameter(parameter.getKey(), parameter.getValue());
		}

		return query.executeUpdate();

	}

	public CriteriaQuery<T> getCriteriaQuery() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		return cb.createQuery(type);
	}
}