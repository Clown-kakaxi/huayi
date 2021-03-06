package com.ecc.echain.wf;

import java.sql.SQLException;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.ecc.echain.workflow.engine.EVO;
import com.yuchengtech.bcrm.common.DateUtils;
import com.yuchengtech.bcrm.custmanager.model.AcrmAAntiChangeGradeHi;
import com.yuchengtech.bcrm.echain.EChainCallbackCommon;

/**
 * 
 * @description : 反洗钱风险等级调整处理流程  AntMoneyAdjust --流程限制长度问题 AMAdjust
 *
 * @author : zhaolong
 * @date : 2016-1-25 下午4:34:54
 */
public class AMAdjust extends EChainCallbackCommon{
	
	//通过处理
	public void endY(EVO vo){		
		try {
			//instanceids[]  0是标示，1是用户ID,2调整前的的风险等级，3是调整后的风险等级，4 最后更新人ID，5客户类型（流程处理中显示客户信息分辨是个人还是企业）   6.是审核结束表中的数据总数
	
			String instanceid = vo.getInstanceID();
			String instanceids[] = instanceid.split("_");
			if(!"".equals(instanceids[1])&instanceids[1]!=null){
				
				//获取当前时间
				String evaluateDateNew=(new DateUtils().getCurrentDateTimeF().toString());
				
				//查询出历史风险等级
				SQL = "select *from  ACRM_F_CI_GRADE where cust_grade_type='01' and cust_id='"+instanceids[1]+"'";
				Result result=querySQL(vo);
				AcrmAAntiChangeGradeHi ws=new AcrmAAntiChangeGradeHi();
				for (SortedMap<?, ?> row  : result.getRows()){
					ws.setCustId((String)row.get("CUST_ID"));
					ws.setCustGradeType((String)row.get("CUST_GRADE_TYPE"));//调整前等级 
					
					ws.setCustGradeOld((String)row.get("CUST_GRADE"));//客户等级类型 
					
					ws.setEvaluateDateOld(row.get("EVALUATE_DATE").toString());// 取等级表等级评定时间 
					ws.setLastUpdateUserOld((String)row.get("LAST_UPDATE_USER"));	//取等级表等级评定人  
					
					ws.setCustGradeNew(instanceids[3]);	//调整后等级 
					ws.setEvaluateDateNew(evaluateDateNew);	//调整等级后等级评级时间
					ws.setLastUpdateUserNew(instanceids[4]);	//调整等级后等级评级人  
					break;
					
				}
				//查询风险等级调整说明
				SQL=" select *from OCRM_F_CHANGE_GRADE_TEMP where INSTANCEID='"+instanceid+"'";
				Result result2=querySQL(vo);
				String instruction="";
				for (SortedMap<?, ?> row  : result2.getRows()){
					instruction=row.get("INSTRUCTION").toString();
				}
				//不删除临时记录表中的信息 提供流程结束后的查询
//				SQL=" delete OCRM_F_CHANGE_GRADE_TEMP where INSTANCEID='"+instanceid+"'";
//				execteSQL(vo);
				//添加修改记录
				SQL="insert into  ACRM_A_ANTI_CHANGE_GRADE_HIS("+
								" GRADE_HIS_ID,"+//ID 
								" CUST_ID,"+//客户号 
								" CUST_GRADE_TYPE,"+//客户等级类型 
								" CUST_GRADE_OLD,"+//调整前等级 
								" EVALUATE_DATE_OLD,"+//调整等级前等级评级时间
								" LAST_UPDATE_USER_OLD,"+//调整等级前等级评级人 
								" CUST_GRADE_NEW,"+//调整后等级 
								" EVALUATE_DATE_NEW,"+//调整等级后等级评级时间
								" LAST_UPDATE_USER_NEW," +//调整等级后等级评级人 
								" INSTANCE_ID," +//流程ID
								" INSTANCE_TYPE," +//流程类型,1：定期审核，2：等级调整，3：复评
								" INSTRUCTION"+//等级调整说明		
								" )"+
								" values(" +
								"ID_INDEX_INSTRUCTION.Nextval,"+
								"'"+ws.getCustId()+"'" +
								",'"+ws.getCustGradeType()+"'" +
								",'"+ws.getCustGradeOld()+"'" +
								",'"+ws.getEvaluateDateOld()+"'" +
								",'"+ws.getLastUpdateUserOld()+"'" +
								",'"+instanceids[3]+"'" +
								",'"+evaluateDateNew+"'" +
								",'"+instanceids[4]+"'"+
								",'"+instanceid+"'"+
								",'2'"+
								",'"+instruction+"')";
				execteSQL(vo);//通过是审批修改客户等级表
				SQL="update ACRM_F_CI_GRADE set cust_grade= '"+instanceids[3]+"',LAST_UPDATE_TM=SYSDATE,EFFECTIVE_DATE=SYSDATE,EVALUATE_DATE=SYSDATE,LAST_UPDATE_USER='"+instanceids[4]+"'  where cust_id='"+instanceids[1]+"' and cust_grade_type='01'";
				execteSQL(vo);//通过是审批修改客户等级表
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行SQL出错");
		}
		
		
	}
	//拒绝处理
	public void endN(EVO vo){		
		try {
		//删除流程调整说明信息
		String instanceid = vo.getInstanceID();
		SQL=" delete OCRM_F_CHANGE_GRADE_TEMP where INSTANCEID='"+instanceid+"'";
		execteSQL(vo);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行SQL出错");
		}
		//不做任何操作
//		try {
//			String instanceid = vo.getInstanceID();
//			String instanceids[] = instanceid.split("_");
//			if(!"".equals(instanceids[1])&instanceids[1]!=null){
//				SQL="update ACRM_F_CI_GRADE_DQ set check_result='1',check_end_date=sysdate,CHECK_STATUS='2' where cust_id='"+instanceids[1]+"' and instanceid='"+instanceid+"'"; 
//				execteSQL(vo);//审批修改客户等级表--否决
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("执行SQL出错");
//		}
	}
	



}
