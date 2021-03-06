package com.yuchengtech.emp.ecif.customer.entity.customerevaluate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.yuchengtech.emp.biappframe.base.web.BioneLongSerializer;



/**
 * The persistent class for the ORGSTARLEVEL database table.
 * 
 */
@Entity
@Table(name="ORGSTARLEVEL")
public class Orgstarlevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STAR_LEVEL_ID", unique=true, nullable=false)
	private Long starLevelId;

	@Column(name="CUST_ID")
	private Long custId;


	@Column(name="EFFECTIVE_DATE",length=20)
	private String effectiveDate;


	@Column(name="EVALUATE_DATE",length=20)
	private String evaluateDate;


	@Column(name="EXPIRED_DATE",length=20)
	private String expiredDate;

	@Column(name="LAST_UPDATE_SYS", length=20)
	private String lastUpdateSys;

	@Column(name="LAST_UPDATE_TM",length=20)
	private String lastUpdateTm;

	@Column(name="LAST_UPDATE_USER", length=20)
	private String lastUpdateUser;

	@Column(name="STAR_LEVEL", length=20)
	private String starLevel;

	@Column(name="STAR_TYPE", length=20)
	private String starType;

	@Column(name="TX_SEQ_NO", length=32)
	private String txSeqNo;

    public Orgstarlevel() {
    }

    @JsonSerialize(using=BioneLongSerializer.class)
	public Long getStarLevelId() {
		return this.starLevelId;
	}

	public void setStarLevelId(Long starLevelId) {
		this.starLevelId = starLevelId;
	}

    @JsonSerialize(using=BioneLongSerializer.class)
	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEvaluateDate() {
		return this.evaluateDate;
	}

	public void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate;
	}

	public String getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getLastUpdateSys() {
		return this.lastUpdateSys;
	}

	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys;
	}

	public String getLastUpdateTm() {
		return this.lastUpdateTm;
	}

	public void setLastUpdateTm(String lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}

	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getStarLevel() {
		return this.starLevel;
	}

	public void setStarLevel(String starLevel) {
		this.starLevel = starLevel;
	}

	public String getStarType() {
		return this.starType;
	}

	public void setStarType(String starType) {
		this.starType = starType;
	}

	public String getTxSeqNo() {
		return this.txSeqNo;
	}

	public void setTxSeqNo(String txSeqNo) {
		this.txSeqNo = txSeqNo;
	}

}