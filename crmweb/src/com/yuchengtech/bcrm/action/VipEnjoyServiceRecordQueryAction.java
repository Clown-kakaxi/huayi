package com.yuchengtech.bcrm.action;

import javax.sql.DataSource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.yuchengtech.bob.common.CommonAction;

@ParentPackage("json-default")
@Action(value="/vipEnjoyServiceRecordQueryAction", results={
    @Result(name="success", type="json"),
})
/**
 * 
 * 贵宾客户享受增值服务记录查询action
 * @author hujun
 * 2014-06-20
 */
public class VipEnjoyServiceRecordQueryAction extends CommonAction{
	@Autowired
	@Qualifier("dsOracle")	
	private DataSource dsOracle;   
 	public void prepare() {
// 		ActionContext ctx = ActionContext.getContext();
 		//HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        StringBuilder sb = new StringBuilder("select t.* from OCRM_F_CI_VIP_ENJOY_SERVICE t " +
        		"where 1>0");
        for(String key:this.getJson().keySet()){
            if(null!=this.getJson().get(key)&&!this.getJson().get(key).equals("")){
                if(key.equals("CUST_ID"))
                    sb.append(" and t.CUST_ID ='"+this.getJson().get(key)+"'");
                else if(key.equals("CUST_NAME")){
                	sb.append(" and t."+key+" = '"+this.getJson().get(key)+"'");
                }else if(key.equals("ALIANCE_PROGRAM_ID")){
                	sb.append(" and t."+key+" = '"+this.getJson().get(key)+"'");
                }else if(key.equals("ALIANCE_PROGRAM_NAME")){
                	sb.append(" and t."+key+" = '"+this.getJson().get(key)+"'");
                }else if(key.equals("ADD_SERVICE_IDENTIFY")){
                	sb.append(" and t."+key+" = '"+this.getJson().get(key)+"'");
                }else if(key.equals("ENJOY_SERVICE_DATE1")){
                	sb.append(" and t.ENJOY_SERVICE_DATE > to_date('" + this.getJson().get(key).toString().substring(0, 10)
							+ "','yyyy-MM-dd')");
                }else if(key.equals("ENJOY_SERVICE_DATE2")){
                	sb.append(" and t.ENJOY_SERVICE_DATE < to_date('" + this.getJson().get(key).toString().substring(0, 10)
							+ "','yyyy-MM-dd')");
                }
            }
        }
        setPrimaryKey("t.ID,t.ENJOY_SERVICE_DATE desc");
		SQL = sb.toString();
		datasource = dsOracle;
	}
}
