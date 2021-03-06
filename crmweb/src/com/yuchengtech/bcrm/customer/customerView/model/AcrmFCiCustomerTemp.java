package com.yuchengtech.bcrm.customer.customerView.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ACRM_F_CI_CUSTOMER_TEMP database table.
 * 统一客户临时表
 */
@Entity
@Table(name="ACRM_F_CI_CUSTOMER_TEMP")
public class AcrmFCiCustomerTemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACRM_F_CI_CUSTOMER_TEMP_CUSTID_GENERATOR", sequenceName="ID_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACRM_F_CI_CUSTOMER_TEMP_CUSTID_GENERATOR")
	@Column(name="CUST_ID")
	private String custId;

	@Column(name="APPROVAL_STATUS")
	private String approvalStatus;

	@Column(name="AR_CUST_FLAG")
	private String arCustFlag;

	@Column(name="AR_CUST_TYPE")
	private String arCustType;

	@Column(name="BLANK_FLAG")
	private String blankFlag;

	@Column(name="CORE_NO")
	private String coreNo;

	@Column(name="CREATE_BRANCH_NO")
	private String createBranchNo;

    @Temporal( TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_TELLER_NO")
	private String createTellerNo;

	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	@Column(name="CUST_GRADE")
	private String custGrade;

	@Column(name="CUST_NAME")
	private String custName;

	@Column(name="CUST_STAT")
	private String custStat;

	@Column(name="CUST_TYPE")
	private String custType;

	@Column(name="EBANK_FLAG")
	private String ebankFlag;

	@Column(name="EN_NAME")
	private String enName;

	@Column(name="EN_SHORT_NAME")
	private String enShortName;

    @Temporal( TemporalType.DATE)
	@Column(name="FIRST_LOAN_DATE")
	private Date firstLoanDate;

	@Column(name="IDENT_NO")
	private String identNo;

	@Column(name="IDENT_TYPE")
	private String identType;

	@Column(name="INOUT_FLAG")
	private String inoutFlag;

	@Column(name="IS_APPROVAL")
	private String isApproval;

	@Column(name="LAST_UPDATE_SYS")
	private String lastUpdateSys;

	@Column(name="LAST_UPDATE_TM")
	private Timestamp lastUpdateTm;

	@Column(name="LAST_UPDATE_USER")
	private String lastUpdateUser;

	@Column(name="LINKMAN_NAME")
	private String linkmanName;

	@Column(name="LINKMAN_TEL")
	private String linkmanTel;

	@Column(name="LOAN_CUST_MGR")
	private String loanCustMgr;

	@Column(name="LOAN_MAIN_BR_ID")
	private String loanMainBrId;

	@Column(name="MERGE_FLAG")
	private String mergeFlag;

	@Column(name="POST_NAME")
	private String postName;

	@Column(name="POTENTIAL_FLAG")
	private String potentialFlag;

	@Column(name="REAL_FLAG")
	private String realFlag;

	private String recommender;

	@Column(name="RISK_LEVEL")
	private String riskLevel;

	@Column(name="RISK_NATION_CODE")
	private String riskNationCode;

	@Column(name="SHORT_NAME")
	private String shortName;

	@Column(name="SOURCE_CHANNEL")
	private String sourceChannel;

	@Column(name="TX_SEQ_NO")
	private String txSeqNo;

	@Column(name="VIP_FLAG")
	private String vipFlag;

    public AcrmFCiCustomerTemp() {
    }

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getArCustFlag() {
		return this.arCustFlag;
	}

	public void setArCustFlag(String arCustFlag) {
		this.arCustFlag = arCustFlag;
	}

	public String getArCustType() {
		return this.arCustType;
	}

	public void setArCustType(String arCustType) {
		this.arCustType = arCustType;
	}

	public String getBlankFlag() {
		return this.blankFlag;
	}

	public void setBlankFlag(String blankFlag) {
		this.blankFlag = blankFlag;
	}

	public String getCoreNo() {
		return this.coreNo;
	}

	public void setCoreNo(String coreNo) {
		this.coreNo = coreNo;
	}

	public String getCreateBranchNo() {
		return this.createBranchNo;
	}

	public void setCreateBranchNo(String createBranchNo) {
		this.createBranchNo = createBranchNo;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateTellerNo() {
		return this.createTellerNo;
	}

	public void setCreateTellerNo(String createTellerNo) {
		this.createTellerNo = createTellerNo;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCustGrade() {
		return this.custGrade;
	}

	public void setCustGrade(String custGrade) {
		this.custGrade = custGrade;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustStat() {
		return this.custStat;
	}

	public void setCustStat(String custStat) {
		this.custStat = custStat;
	}

	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getEbankFlag() {
		return this.ebankFlag;
	}

	public void setEbankFlag(String ebankFlag) {
		this.ebankFlag = ebankFlag;
	}

	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getEnShortName() {
		return this.enShortName;
	}

	public void setEnShortName(String enShortName) {
		this.enShortName = enShortName;
	}

	public Date getFirstLoanDate() {
		return this.firstLoanDate;
	}

	public void setFirstLoanDate(Date firstLoanDate) {
		this.firstLoanDate = firstLoanDate;
	}

	public String getIdentNo() {
		return this.identNo;
	}

	public void setIdentNo(String identNo) {
		this.identNo = identNo;
	}

	public String getIdentType() {
		return this.identType;
	}

	public void setIdentType(String identType) {
		this.identType = identType;
	}

	public String getInoutFlag() {
		return this.inoutFlag;
	}

	public void setInoutFlag(String inoutFlag) {
		this.inoutFlag = inoutFlag;
	}

	public String getIsApproval() {
		return this.isApproval;
	}

	public void setIsApproval(String isApproval) {
		this.isApproval = isApproval;
	}

	public String getLastUpdateSys() {
		return this.lastUpdateSys;
	}

	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys;
	}

	public Timestamp getLastUpdateTm() {
		return this.lastUpdateTm;
	}

	public void setLastUpdateTm(Timestamp lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}

	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getLinkmanName() {
		return this.linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanTel() {
		return this.linkmanTel;
	}

	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
	}

	public String getLoanCustMgr() {
		return this.loanCustMgr;
	}

	public void setLoanCustMgr(String loanCustMgr) {
		this.loanCustMgr = loanCustMgr;
	}

	public String getLoanMainBrId() {
		return this.loanMainBrId;
	}

	public void setLoanMainBrId(String loanMainBrId) {
		this.loanMainBrId = loanMainBrId;
	}

	public String getMergeFlag() {
		return this.mergeFlag;
	}

	public void setMergeFlag(String mergeFlag) {
		this.mergeFlag = mergeFlag;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPotentialFlag() {
		return this.potentialFlag;
	}

	public void setPotentialFlag(String potentialFlag) {
		this.potentialFlag = potentialFlag;
	}

	public String getRealFlag() {
		return this.realFlag;
	}

	public void setRealFlag(String realFlag) {
		this.realFlag = realFlag;
	}

	public String getRecommender() {
		return this.recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public String getRiskLevel() {
		return this.riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRiskNationCode() {
		return this.riskNationCode;
	}

	public void setRiskNationCode(String riskNationCode) {
		this.riskNationCode = riskNationCode;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getSourceChannel() {
		return this.sourceChannel;
	}

	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel;
	}

	public String getTxSeqNo() {
		return this.txSeqNo;
	}

	public void setTxSeqNo(String txSeqNo) {
		this.txSeqNo = txSeqNo;
	}

	public String getVipFlag() {
		return this.vipFlag;
	}

	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}

}