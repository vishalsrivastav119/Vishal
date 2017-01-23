/**
 * 
 */
package com.cts.tsp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cts.tsp.domain.BaseEntity;
import com.cts.tsp.dto.PaginatedList;

public interface GenericDAO<T extends BaseEntity, PK extends Serializable> {

	public T find(PK id);

	public T findRef(PK id);

	public T create(T domainObj);

	public T update(T domainObj);

	public List<T> findAll();

	public PaginatedList<T> findAll(Integer offset, Integer limit);

	public T queryForObject(String queryIdentifier, Map<String, ?> parameterMap);

	public List<T> queryForList(String queryIdentifier, Map<String, ?> parameterMap);

	public <P> List<P> queryForCustomList(String queryIdentifier,
			Map<String, ?> parameterMap, Class<P> clazz);

	public PaginatedList<T> queryForPaginatedList(String queryIdentifier,
			Map<String, ?> parameterMap, Integer offset, Integer length);

	public Integer executeUpdateQuery(Map<String, ?> parameterMap, String queryIdentifier);
}