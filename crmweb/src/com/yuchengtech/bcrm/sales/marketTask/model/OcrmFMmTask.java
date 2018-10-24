package com.yuchengtech.bcrm.sales.marketTask.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @describtion: autogenerated by lhqheli's Tools
 *
 * @author : lhqheli (email: lhqheli@gmail.com)
 * @date : 2014-07-03 10:19:20
 */
@Entity
@Table(name="OCRM_F_MM_TASK")
public class OcrmFMmTask implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name="OCRM_F_MM_TASK_GENERATOR", sequenceName="ID_SEQUENCE", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCRM_F_MM_TASK_GENERATOR")
    @Column(name="TASK_ID")
    private Long taskId;

    @Column(name="TASK_NAME")
    private String taskName;

    @Column(name="TASK_PARENT_ID")
    private BigDecimal taskParentId;

    @Column(name="TASK_TYPE")
    private String taskType;

    @Column(name="TASK_STAT")
    private String taskStat;

    @Column(name="DIST_ORG")
    private String distOrg;

    @Column(name="DIST_USER")
    private String distUser;

    @Column(name="DIST_TASK_TYPE")
    private String distTaskType;

    @Temporal(TemporalType.DATE)
    @Column(name="TASK_DIST_DATE")
    private Date taskDistDate;

    @Temporal(TemporalType.DATE)
    @Column(name="TASK_BEGIN_DATE")
    private Date taskBeginDate;

    @Temporal(TemporalType.DATE)
    @Column(name="TASK_END_DATE")
    private Date taskEndDate;

    @Column(name="MEMO")
    private String memo;

    @Column(name="CREATE_USER")
    private String createUser;

    @Temporal(TemporalType.DATE)
    @Column(name="CREATE_DATE")
    private Date createDate;

    @Column(name="DIST_ORG_NAME")
    private String distOrgName;

    @Column(name="DIST_USER_NAME")
    private String distUserName;

    @Column(name="OPER_OBJ_ID")
    private String operObjId;

    @Column(name="OPER_OBJ_NAME")
    private String operObjName;

    @Column(name="CREATE_USER_NAME")
    private String createUserName;

    @Column(name="CREATE_ORG_ID")
    private String createOrgId;

    @Column(name="CREATE_ORG_NAME")
    private String createOrgName;

    @Column(name="RECENTLY_UPDATE_ID")
    private String recentlyUpdateId;

    @Column(name="RECENTLY_UPDATE_NAME")
    private String recentlyUpdateName;

    @Temporal(TemporalType.DATE)
    @Column(name="RECENTLY_UPDATE_DATE")
    private Date recentlyUpdateDate;
    
    @Column(name="TARGET_TYPE")
    private String targetType;


    public Long getTaskId(){
        return this.taskId;
    }

    public void setTaskId(Long taskId){
        this.taskId = taskId;
    }

    public String getTaskName(){
        return this.taskName;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public BigDecimal getTaskParentId(){
        return this.taskParentId;
    }

    public void setTaskParentId(BigDecimal taskParentId){
        this.taskParentId = taskParentId;
    }

    public String getTaskType(){
        return this.taskType;
    }

    public void setTaskType(String taskType){
        this.taskType = taskType;
    }

    public String getTaskStat(){
        return this.taskStat;
    }

    public void setTaskStat(String taskStat){
        this.taskStat = taskStat;
    }

    public String getDistOrg(){
        return this.distOrg;
    }

    public void setDistOrg(String distOrg){
        this.distOrg = distOrg;
    }

    public String getDistUser(){
        return this.distUser;
    }

    public void setDistUser(String distUser){
        this.distUser = distUser;
    }

    public String getDistTaskType(){
        return this.distTaskType;
    }

    public void setDistTaskType(String distTaskType){
        this.distTaskType = distTaskType;
    }

    public Date getTaskDistDate(){
        return this.taskDistDate;
    }

    public void setTaskDistDate(Date taskDistDate){
        this.taskDistDate = taskDistDate;
    }

    public Date getTaskBeginDate(){
        return this.taskBeginDate;
    }

    public void setTaskBeginDate(Date taskBeginDate){
        this.taskBeginDate = taskBeginDate;
    }

    public Date getTaskEndDate(){
        return this.taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate){
        this.taskEndDate = taskEndDate;
    }

    public String getMemo(){
        return this.memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public String getCreateUser(){
        return this.createUser;
    }

    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }

    public Date getCreateDate(){
        return this.createDate;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public String getDistOrgName(){
        return this.distOrgName;
    }

    public void setDistOrgName(String distOrgName){
        this.distOrgName = distOrgName;
    }

    public String getDistUserName(){
        return this.distUserName;
    }

    public void setDistUserName(String distUserName){
        this.distUserName = distUserName;
    }

    public String getOperObjId(){
        return this.operObjId;
    }

    public void setOperObjId(String operObjId){
        this.operObjId = operObjId;
    }

    public String getOperObjName(){
        return this.operObjName;
    }

    public void setOperObjName(String operObjName){
        this.operObjName = operObjName;
    }

    public String getCreateUserName(){
        return this.createUserName;
    }

    public void setCreateUserName(String createUserName){
        this.createUserName = createUserName;
    }

    public String getCreateOrgId(){
        return this.createOrgId;
    }

    public void setCreateOrgId(String createOrgId){
        this.createOrgId = createOrgId;
    }

    public String getCreateOrgName(){
        return this.createOrgName;
    }

    public void setCreateOrgName(String createOrgName){
        this.createOrgName = createOrgName;
    }

    public String getRecentlyUpdateId(){
        return this.recentlyUpdateId;
    }

    public void setRecentlyUpdateId(String recentlyUpdateId){
        this.recentlyUpdateId = recentlyUpdateId;
    }

    public String getRecentlyUpdateName(){
        return this.recentlyUpdateName;
    }

    public void setRecentlyUpdateName(String recentlyUpdateName){
        this.recentlyUpdateName = recentlyUpdateName;
    }

    public Date getRecentlyUpdateDate(){
        return this.recentlyUpdateDate;
    }

    public void setRecentlyUpdateDate(Date recentlyUpdateDate){
        this.recentlyUpdateDate = recentlyUpdateDate;
    }

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}


}
