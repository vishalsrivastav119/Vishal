/**
 * 
 */
package com.cts.tsp.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.cts.tsp.rest.config.Views;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author 111033
 *
 */

@MappedSuperclass
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String createdBy;
	private Timestamp createdTs;
	private String updatedBy;
	private Timestamp updatedTs;

	
	/**
	 * @return the createdBy
	 */
	@JsonView(Views.InternalView.class)
	@Column(name="CREATE_USER", updatable=false, nullable=false)
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdTs
	 */
	@JsonView(Views.InternalView.class)
	@Column(name="CREATE_TIME", updatable=false, nullable=false)
	public Timestamp getCreatedTs() {
		return createdTs;
	}
	/**
	 * @param createdTs the createdTs to set
	 */
	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}
	/**
	 * @return the updatedBy
	 */
	@JsonView(Views.InternalView.class)
	@Column(name="MODIFY_USER")
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the updatedTs
	 */
	@JsonView(Views.InternalView.class)
	@Column(name="MODIFY_TIME")
	public Timestamp getUpdatedTs() {
		return updatedTs;
	}
	/**
	 * @param updatedTs the updatedTs to set
	 */
	public void setUpdatedTs(Timestamp updatedTs) {
		this.updatedTs = updatedTs;
	}
	
	@PrePersist
	public void setDefaults(){
		this.createdTs = new Timestamp(System.currentTimeMillis());
		this.createdBy = "Admin";
	}

	@PreUpdate
	public void setUpdateDefaults(){
		this.updatedTs = new Timestamp(System.currentTimeMillis());
		this.updatedBy = "Admin";
	}
}
