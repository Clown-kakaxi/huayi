package com.yuchengtech.bcrm.payOrRepay.model;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OCRM_F_MK_TMU_OTHER database table.
 * TMU、投行及其他手续费收入表
 */
@Entity
@Table(name="OCRM_F_MK_TMU_OTHER")
public class OcrmFMkTmuOther implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "CommonSequnce", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;

	@Column(name="AMOUNT")
	private BigDecimal amount;

	@Column(name="APPLY_NO")
	private String applyNo;

	@Column(name="APPROVE_STATE")
	private String approveState;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="CREATE_TM")
	private Date createTm;

	@Column(name="CREATE_ORG")
	private String createOrg;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="CUST_ID")
	private String custId;

	@Column(name="CUST_NAME")
	private String custName;

	@Column(name="CUST_TYPE")
	private String custType;

	@Column(name="DISCOUNT_OCCUR_AMT")
	private BigDecimal discountOccurAmt;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="ESTIMATE_DATE")
	private Date estimateDate;

	@Column(name="GATHER_OR_BACK")
	private String gatherOrBack;

	@Column(name="GATHER_TYPE")
	private String gatherType;

	@Column(name="IF_RE")
	private String ifRe;
	
	@Column(name="IF_TAIWAN")
	private String ifTaiwan;

	@Column(name="LAST_UPDATE_ORG")
	private String lastUpdateOrg;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_TM")
	private Date lastUpdateTm;

	@Column(name="LAST_UPDATE_USER")
	private String lastUpdateUser;

	@Column(name="ORG_ID")
	private String orgId;

	private String probability;

	private String progress;

	private String region;

	private String remark;

    public OcrmFMkTmuOther() {
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getApplyNo() {
		return this.applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getApproveState() {
		return this.approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}

	public Date getCreateTm() {
		return this.createTm;
	}

	public void setCreateTm(Date createTm) {
		this.createTm = createTm;
	}

	public String getCreateOrg() {
		return this.createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public BigDecimal getDiscountOccurAmt() {
		return this.discountOccurAmt;
	}

	public void setDiscountOccurAmt(BigDecimal discountOccurAmt) {
		this.discountOccurAmt = discountOccurAmt;
	}

	public Date getEstimateDate() {
		return this.estimateDate;
	}

	public void setEstimateDate(Date estimateDate) {
		this.estimateDate = estimateDate;
	}

	public String getGatherOrBack() {
		return this.gatherOrBack;
	}

	public void setGatherOrBack(String gatherOrBack) {
		this.gatherOrBack = gatherOrBack;
	}

	public String getGatherType() {
		return this.gatherType;
	}

	public void setGatherType(String gatherType) {
		this.gatherType = gatherType;
	}
	public String getIfRe() {
		return this.ifRe;
	}

	public void setIfRe(String ifRe) {
		this.ifRe = ifRe;
	}
	public String getIfTaiwan() {
		return this.ifTaiwan;
	}

	public void setIfTaiwan(String ifTaiwan) {
		this.ifTaiwan = ifTaiwan;
	}

	public String getLastUpdateOrg() {
		return this.lastUpdateOrg;
	}

	public void setLastUpdateOrg(String lastUpdateOrg) {
		this.lastUpdateOrg = lastUpdateOrg;
	}

	public Date getLastUpdateTm() {
		return this.lastUpdateTm;
	}

	public void setLastUpdateTm(Date lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}

	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getProbability() {
		return this.probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	public String getProgress() {
		return this.progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}