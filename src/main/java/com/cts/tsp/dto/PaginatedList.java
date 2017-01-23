/**
 * 
 */
package com.cts.tsp.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Somnath
 *
 */
public class PaginatedList<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<T> objectList;
	private Long size;

	/**
	 * @return the objectList
	 */
	public List<T> getObjectList() {
		return objectList;
	}
	/**
	 * @param objectList the objectList to set
	 */
	public void setObjectList(List<T> objectList) {
		this.objectList = objectList;
	}
	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}
}