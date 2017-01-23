package com.cts.tsp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * The persistent class for the t_475_token_prefix_counter database table.
 * 
 */
@Entity
@Table(name = "t_475_token_prefix_counter")
@NamedQuery(name = "TokenPrefixCounter.findAll", query = "SELECT t FROM TokenPrefixCounter t")
public class TokenPrefixCounter extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private int counter;
	private String tokenBin;

	public TokenPrefixCounter() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public int getCounter() {
		return this.counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Column(name = "TOKEN_BIN")
	public String getTokenBin() {
		return this.tokenBin;
	}

	public void setTokenBin(String tokenBin) {
		this.tokenBin = tokenBin;
	}

	@PrePersist
	public void setRecordId(){
		this.setRecordId("475" + (long)((Math.random()*10000000000L)+10L));
		this.setCreatedBy("111033");
		this.setUpdatedBy("111033");
		this.setCreatedTs(new Timestamp( new Date().getTime()));
		this.setUpdatedTs(this.getCreatedTs());
	}
}