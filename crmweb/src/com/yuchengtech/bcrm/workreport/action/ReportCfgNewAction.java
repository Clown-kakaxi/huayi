package com.yuchengtech.bcrm.workreport.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionContext;
import com.yuchengtech.bcrm.workreport.model.OcrmFSysReport;
import com.yuchengtech.bcrm.workreport.service.ReportCfgNewService;
import com.yuchengtech.bob.common.CommonAction;
import com.yuchengtech.crm.exception.BizException;
/****
 * 
 * 报表配置New
 * @author ChengMeng
 */
@SuppressWarnings("serial")
@Action("/ReportCfgNewAction")
public class ReportCfgNewAction extends CommonAction 
{
	@Autowired
	@Qualifier("dsOracle")
	private DataSource ds;
	
	@Autowired
	private ReportCfgNewService reportCfgNewService;
	
	@Autowired
	public void init(){
	  	model = new OcrmFSysReport(); 
		setCommonService(reportCfgNewService);
	}
	/**
	 * 拼装查询SQL
	 */
	public void prepare() 
	{ 
		String   reportCode = (String) json.get("REPORT_CODE");//报表编码
		String   reportName = (String) json.get("REPORT_NAME");//报表名称
		String reportStatus = (String) json.get("REPORT_STATUS");//报表状态
		String reportServerType = (String) json.get("REPORT_SERVER_TYPE");//服务类型
		String reportUrl = (String) json.get("REPORT_URL");//报表URL
		String reportDesc = (String) json.get("REPORT_DESC");//备注
		StringBuilder sb = new StringBuilder("SELECT * FROM OCRM_F_SYS_REPORT R WHERE 1=1");
		if(reportCode != null && !"".equals(reportCode)){
			sb.append(" AND R.REPORT_CODE LIKE '%" + reportCode + "%'");
		}
		if(reportName != null && !"".equals(reportName)){
			sb.append(" AND R.REPORT_NAME LIKE '%" + reportName + "%'");
		}
		if(reportStatus != null && !"".equals(reportStatus)){
			sb.append(" AND R.REPORT_STATUS LIKE '%" + reportStatus + "%'");
		}
		if(reportServerType != null && !"".equals(reportServerType)){
			sb.append(" AND R.REPORT_SERVER_TYPE LIKE '%" + reportServerType + "%'");
		}
		if(reportUrl != null && !"".equals(reportUrl)){
			sb.append(" AND R.REPORT_URL = '" + reportUrl + "'");
		}
		if(reportDesc != null && !"".equals(reportDesc)){
			sb.append(" AND R.REPORT_URL = '" + reportDesc + "'");
		}
		SQL = sb.toString() + " ORDER BY R.REPORT_SORT ";
		datasource = ds;
	}
	
	/**
	 * 保存
	 */
	public String saveReport() {
		ActionContext ctx = ActionContext.getContext();
        request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
        Map<String, Object> formPanel = getReportValues(request.getParameter("formPanel"));  
        List reportList = new ArrayList();
        try {
        	/**取报表配置列表中的数据并转换成list*/       	
			reportList  = (List) JSONUtil.deserialize(request.getParameter("reportList"));
			reportCfgNewService.saveReport(formPanel, reportList);
			
		} catch (JSONException e) {			
			e.printStackTrace();
			throw new BizException(1,2,"1002",e.getMessage());
		}  
		
		return "success";
	}
	/**
	 * 转换form数据
	 * @param o
	 * @return
	 */
	private Map<String, Object> getReportValues(String o) {
		Map<String, Object> values = new HashMap<String, Object>();
		try {
        	if(o!=null&&o!="")
        		values = (Map<String, Object>) JSONUtil.deserialize(o);
        } catch (JSONException e) {
            e.printStackTrace();
            return values;
        }  
        	return values;
        
	}
	/**
	 * 删除
	 */
	public String delReport() {
		
		ActionContext ctx = ActionContext.getContext();
        request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
   		String id = request.getParameter("id");   		
   		reportCfgNewService.batchRemove(id);
		return "success";
	}
	/**
	 * 修改状态
	 */
	public String updateReportStatus() {
		ActionContext ctx = ActionContext.getContext();
        request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
   		String reportStatus = request.getParameter("reportStatus");
   		String id = request.getParameter("id");   		
   		reportCfgNewService.updateReportStatus(Long.parseLong(id), Long.parseLong(reportStatus));
		return "success";
	}
	/**
	 * 查询报表配置项
	 * @return
	 */
	public String getCfgItems() {
		ActionContext ctx = ActionContext.getContext();
        request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
   		String reportCode = request.getParameter("reportCode");
		StringBuilder jql = new StringBuilder("select o from OcrmFSysReportCfg o where o.reportCode='"+reportCode+"' order by o.id");
		Map<String,Object> values = new HashMap<String,Object>();
		indexPageByJql(jql.toString(), values);
		return "success";
	}
}
