package com.cts.tsp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the t_464_detokenize_resp_field database table.
 * 
 */
@Entity
@Table(name="t_464_detokenize_resp_field")
@NamedQuery(name="DetokenizeResponseField.findAll", query="SELECT d FROM DetokenizeResponseField d")
public class DetokenizeResponseField extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String detokenizeRespFieldDesc;
	private String detokenizeRespFieldName;

	private List<IssuerDetokenResponseField> t468IssuerDetokenRespFields;

	public DetokenizeResponseField() {
	}


	@Id
	@Column(name="RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}




	@Column(name="DETOKENIZE_RESP_FIELD_DESC")
	public String getDetokenizeRespFieldDesc() {
		return this.detokenizeRespFieldDesc;
	}

	public void setDetokenizeRespFieldDesc(String detokenizeRespFieldDesc) {
		this.detokenizeRespFieldDesc = detokenizeRespFieldDesc;
	}


	@Column(name="DETOKENIZE_RESP_FIELD_NAME")
	public String getDetokenizeRespFieldName() {
		return this.detokenizeRespFieldName;
	}

	public void setDetokenizeRespFieldName(String detokenizeRespFieldName) {
		this.detokenizeRespFieldName = detokenizeRespFieldName;
	}



	//bi-directional many-to-one association to IssuerDetokenResponseField
	@OneToMany(mappedBy="t464DetokenizeRespField")
	public List<IssuerDetokenResponseField> getT468IssuerDetokenRespFields() {
		return this.t468IssuerDetokenRespFields;
	}

	public void setT468IssuerDetokenRespFields(List<IssuerDetokenResponseField> t468IssuerDetokenRespFields) {
		this.t468IssuerDetokenRespFields = t468IssuerDetokenRespFields;
	}

	public IssuerDetokenResponseField addT468IssuerDetokenRespField(IssuerDetokenResponseField t468IssuerDetokenRespField) {
		getT468IssuerDetokenRespFields().add(t468IssuerDetokenRespField);
		t468IssuerDetokenRespField.setT464DetokenizeRespField(this);

		return t468IssuerDetokenRespField;
	}

	public IssuerDetokenResponseField removeT468IssuerDetokenRespField(IssuerDetokenResponseField t468IssuerDetokenRespField) {
		getT468IssuerDetokenRespFields().remove(t468IssuerDetokenRespField);
		t468IssuerDetokenRespField.setT464DetokenizeRespField(null);

		return t468IssuerDetokenRespField;
	}

}