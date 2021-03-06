/**
*@description 归属信息(对私) .360客户视图
*@author: fan zheming
*@since: 2014-07-23
*/
Ext.QuickTips.init();

var needGrid = false;
WLJUTIL.suspendViews=false;  //自定义面板是否浮动

var _custId;
var url = basepath + "/custRetailBelongInfo.json";

//field
var fields = [
          	{name: 'TEST',text:'此文件fields必须要有一个无用字段', resutlWidth:80}
];

/**
 * 推荐人表格
 */
var recrownum = new Ext.grid.RowNumberer( {
	header : 'No.',
	width : 35
});
var reccm = new Ext.grid.ColumnModel( [
    recrownum,
    {header:'推荐人', dataIndex:'RECOMMENDER', sortable:true, align:'left', width : 180}
]);
var recstore = new Ext.data.Store( {
	restful : true,
	proxy : new Ext.data.HttpProxy( {
		url : basepath + '/custRetailBelongInfo!findREC.json?custId='+_custId,
		method: 'POST',
		failure : function(response) {//状态码解码.
			var resultArray = Ext.util.JSON
					.decode(response.status);
			if (resultArray == 403) {
				Ext.Msg.alert('提示', response.responseText);
			}
		}
	}),
	reader : new Ext.data.JsonReader( {
		successProperty : 'success',
		totalProperty : 'json.count',
		root : 'json.data'
	}, [ {
		name : 'RECOMMENDER'
	}])
});
recstore.load();
var recGrid = new Ext.grid.GridPanel( {
	title : '推荐人',
	height : 90,
	frame : true,
	overflow : 'auto',
	autoScroll : true,
	store : recstore, // 数据存储
	stripeRows : true, // 斑马线
	cm : reccm, // 列模型
	//bbar : bbar,
	loadMask : {
		msg : '正在加载表格数据,请稍等...'
	}
});

/**
 * 归属机构+归属客户经理 表格
 */
var omrownum = new Ext.grid.RowNumberer( {
	header : 'No.',
	width : 35
});
var omcm = new Ext.grid.ColumnModel( [
    omrownum,
    {header:'归属机构', dataIndex:'INSTITUTION_NAME', sortable:true, align:'left', width : 180},
    {header:'归属客户经理', dataIndex:'MGR_NAME', sortable:true, align:'left', width : 180}
]);
var omstore = new Ext.data.Store( {
	restful : true,
	proxy : new Ext.data.HttpProxy( {
		url : basepath + '/custRetailBelongInfo!findOM.json?custId='+_custId,
		method: 'POST',
		failure : function(response) {//状态码解码.
			var resultArray = Ext.util.JSON
					.decode(response.status);
			if (resultArray == 403) {
				Ext.Msg.alert('提示', response.responseText);
			}
		}
	}),
	reader : new Ext.data.JsonReader( {
		successProperty : 'success',
		totalProperty : 'json.count',
		root : 'json.data'
	}, [ 
	    {name : 'CUST_ID'},
		{name : 'INSTITUTION_NAME'},
		{name : 'MGR_NAME'}
	])
});
omstore.load();
var omGrid = new Ext.grid.GridPanel( {
	title : '归属机构以及归属客户经理',
	height : 113,
	frame : true,
	overflow : 'auto',
	autoScroll : true,
	store : omstore, // 数据存储
	stripeRows : true, // 斑马线
	cm : omcm, // 列模型
	//bbar : bbar,
	loadMask : {
		msg : '正在加载表格数据,请稍等...'
	}
});

/**
 * 归属客户经理团队
 */
var mtrownum = new Ext.grid.RowNumberer( {
	header : 'No.',
	width : 35
});
var mtcm = new Ext.grid.ColumnModel( [
    mtrownum,
    {header:'团队名', dataIndex:'TEAM_NAME', sortable:true, align:'left', width : 180},
    {header:'所属机构', dataIndex:'ORG_NAME', sortable:true, align:'left', width : 180},
    {header:'批准人', dataIndex:'USERNAME', sortable:true, align:'left', width : 180},
    {header:'时间！时间！', dataIndex:'JOIN_DATE', sortable:true, align:'left', width : 180,hidden:true}
]);
var mtstore = new Ext.data.Store( {
	restful : true,
	proxy : new Ext.data.HttpProxy( {
		url : basepath + '/custRetailBelongInfo!findMTeam.json?custId='+_custId,
		method: 'POST',
		failure : function(response) {//状态码解码.
			var resultArray = Ext.util.JSON
					.decode(response.status);
			if (resultArray == 403) {
				Ext.Msg.alert('提示', response.responseText);
			}
		}
	}),
	reader : new Ext.data.JsonReader( {
		successProperty : 'success',
		totalProperty : 'json.count',
		root : 'json.data'
	}, [ 
	    {name : 'TEAM_NAME'},
		{name : 'ORG_NAME'},
		{name : 'USERNAME'},
		{name : 'JOIN_DATE'}
	])
});
mtstore.load();

/*以下是combo-分页代码*/
var mtpagesize_combo = new Ext.form.ComboBox({//“一页几行”下拉选
	name : 'pagesize',
	triggerAction : 'all',
	mode : 'local',
	store : new Ext.data.ArrayStore({//页行下拉选的 store
		fields : [ 'value', 'text' ],
		data : [ [ 10, '10条/页' ], [ 20, '20条/页' ], [ 50, '50条/页' ],
				[ 100, '100条/页' ], [ 250, '250条/页' ], [ 500, '500条/页' ] ]
	}),
	valueField : 'value',
	displayField : 'text',
	value : '20',
	editable : false,
	width : 85
});
mtpagesize_combo.on("select", function(comboBox) { //激发时...
	mtbbar.pageSize = parseInt(mtpagesize_combo.getValue()), //bbar显示进程
	mtstore.reload({//grid更新显示进程
		params : {
			start : 0,
			limit : parseInt(mtpagesize_combo.getValue())//就是number
		}
	});
});

var mtnumber = parseInt(mtpagesize_combo.getValue());

var mtbbar = new Ext.PagingToolbar({//箭头前进后退一页, 为内置
	pageSize : mtnumber,//对应number
	store : mtstore,//正store
	displayInfo : true,
	displayMsg : '显示{0}条到{1}条,共{2}条',
	emptyMsg : "没有符合条件的记录",
	items : [ '-', '&nbsp;&nbsp;', mtpagesize_combo ]//“一页几行”下拉选
});
/*combo-分页代码   到此*/

var mtGrid = new Ext.grid.GridPanel( {
	title : '归属客户经理团队',
	height : 180,
	frame : true,
	overflow : 'auto',
	autoScroll : true,
	store : mtstore, // 数据存储
	stripeRows : true, // 斑马线
	cm : mtcm, // 列模型
	bbar : mtbbar,
	loadMask : {
		msg : '正在加载表格数据,请稍等...'
	}
});

/**
 * 归属客户群
 */
var cbrownum = new Ext.grid.RowNumberer( {
	header : 'No.',
	width : 35
});
var cbcm = new Ext.grid.ColumnModel( [
    cbrownum,
    {header:'客户群名', dataIndex:'CUST_BASE_NAME', sortable:true, align:'left', width : 180},
    {header:'客户群创建人', dataIndex:'CUST_BASE_CREATE_NAME', sortable:true, align:'left', width : 180},
    {header:'创建机构', dataIndex:'ORG_NAME', sortable:true, align:'left', width : 180},
    {header:'时间！时间！', dataIndex:'CUST_BASE_CREATE_DATE', sortable:true, align:'left', width : 180,hidden:true}
]);
var cbstore = new Ext.data.Store( {
	restful : true,
	proxy : new Ext.data.HttpProxy( {
		url : basepath + '/custRetailBelongInfo!findCBase.json?custId='+_custId,
		method: 'POST',
		failure : function(response) {//状态码解码.
			var resultArray = Ext.util.JSON
					.decode(response.status);
			if (resultArray == 403) {
				Ext.Msg.alert('提示', response.responseText);
			}
		}
	}),
	reader : new Ext.data.JsonReader( {
		successProperty : 'success',
		totalProperty : 'json.count',
		root : 'json.data'
	}, [ 
	    {name : 'CUST_BASE_NAME'},
		{name : 'CUST_BASE_CREATE_NAME'},
		{name : 'ORG_NAME'},
		{name : 'CUST_BASE_CREATE_DATE'}
	])
});
cbstore.load();

/*以下是combo-分页代码*/
var cbpagesize_combo = new Ext.form.ComboBox({//“一页几行”下拉选
	name : 'pagesize',
	triggerAction : 'all',
	mode : 'local',
	store : new Ext.data.ArrayStore({//页行下拉选的 store
		fields : [ 'value', 'text' ],
		data : [ [ 10, '10条/页' ], [ 20, '20条/页' ], [ 50, '50条/页' ],
				[ 100, '100条/页' ], [ 250, '250条/页' ], [ 500, '500条/页' ] ]
	}),
	valueField : 'value',
	displayField : 'text',
	value : '20',
	editable : false,
	width : 85
});
cbpagesize_combo.on("select", function(comboBox) { //激发时...
	cbbbar.pageSize = parseInt(cbpagesize_combo.getValue()), //bbar显示进程
	cbstore.reload({//grid更新显示进程
		params : {
			start : 0,
			limit : parseInt(cbpagesize_combo.getValue())//就是number
		}
	});
});

var cbnumber = parseInt(cbpagesize_combo.getValue());

var cbbbar = new Ext.PagingToolbar({//箭头前进后退一页, 为内置
	pageSize : cbnumber,//对应number
	store : cbstore,//正store
	displayInfo : true,
	displayMsg : '显示{0}条到{1}条,共{2}条',
	emptyMsg : "没有符合条件的记录",
	items : [ '-', '&nbsp;&nbsp;', cbpagesize_combo ]//“一页几行”下拉选
});
/*combo-分页代码   到此*/

var cbGrid = new Ext.grid.GridPanel( {
	title : '归属客户群',
	height : 180,
	frame : true,
	overflow : 'auto',
	autoScroll : true,
	store : cbstore, // 数据存储
	stripeRows : true, // 斑马线
	cm : cbcm, // 列模型
	bbar : cbbbar,
	loadMask : {
		msg : '正在加载表格数据,请稍等...'
	}
});

//结果域扩展功能面板
var customerView = [{
	/**
	 * 自定义面板
	 */
	title:'归属信息面板',
	hideTitle: true,
	layout: 'form',
	items: [recGrid, omGrid, mtGrid, cbGrid]
}];