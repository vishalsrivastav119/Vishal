/**
 * 
 */
package com.cts.tsp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Somnath
 *
 */
@Entity
@Table(name="TOKEN_POOL")
public class TokenPool extends BaseEntity{
	private static final long serialVersionUID = 8227537026592191039L;
	private Long id;
	private String tokenBin;
	private String token;
	private TokenStatus status;
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the tokenBin
	 */
	@Column(name="TOKEN_BIN")
	public String getTokenBin() {
		return tokenBin;
	}
	/**
	 * @param tokenBin the tokenBin to set
	 */
	public void setTokenBin(String tokenBin) {
		this.tokenBin = tokenBin;
	}
	/**
	 * @return the token
	 */
	@Column(name="TOKEN")
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the status
	 */
	@Enumerated
	@Column(name="STATUS")
	public TokenStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(TokenStatus status) {
		this.status = status;
	}
}
