<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta name="decorator" content="/template/template14.jsp">
<script type="text/javascript">
	var groupicon = "${ctx}/images/classics/icons/communication.gif";
	var mainform;
    var field = [ {
		display : "评价类型",
		name : "evaluateType",
		newline : true,
		type : "text",
		group : "客户评价信息",
		groupicon : groupicon
	}	, {
		display : "评价信息",
		name : "evaluateInfo",
		newline : false,
		type : "text"
	}
	, {
		display : "评价日期",
		name : "evaluateDate",
		newline : false,
		type : "text"
	}
	, {
		display : "最后更新系统",
		name : "lastUpdateSys",
		newline : true,
		type : "text"
	}
	, {
		display : "最后更新人",
		name : "lastUpdateUser",
		newline : false,
		type : "text"
	}
	, {
		display : "最后更新时间",
		name : "lastUpdateTm",
		newline : false,
		type : "text"
	}
	, {
		display : "交易流水号",
		name : "txSeqNo",
		newline : true,
		type : "text"
	}
     ];
	//创建表单结构 
	function ligerFormNow() {
		mainform = $("#mainform").ligerForm({
			     inputWidth : 150,
			    labelWidth : 110,
			    space : 30,
			    fields : field
		});
		jQuery.metadata.setType("attr", "validate");
		BIONE.validate($("#mainform"));
	}
	$(function(){
		ligerFormNow();
		if ("${custId}") {
			BIONE.loadForm(mainform, {
				url : "${ctx}/ecif/perevaluate/evaluate/${custId}"
			});
			$(":input", $("#mainform")).not(":submit, :reset, :image,:button, [disabled]")
			.each(
				function() {
					$(this).attr("readonly","readonly");
					$(this).css({color:"#000000"});
				}
			);
		}
	});
</script>
<title>客户评价信息</title>
</head>
<body>
<div id="template.center">
	<form name="mainform" method="post" id="mainform" action="${ctx}/ecif/orgevaluate">
	</form>
</div>
</body>
</html>

