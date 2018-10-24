/**
 * @description 基金赎回计算器
 * @author helin
 * @since 2014-07-02
 */

Ext.QuickTips.init();

var needGrid = false;
WLJUTIL.suspendViews=false;  //自定义面板是否浮动

var fields = [
	{name: 'TEST',text:'此文件fields必须要有一个无用字段', resutlWidth:80}
];

/**
 * 工具说明form
 */
var notesForm = new Ext.Panel({
	title: '工具说明',
	//height:160,
	collapsed:false,
	collapsible:true,
	autoHeight:true,
	padding:'10 20 0',
	html:'赎回总额＝赎回份数×基金单位面值<br>赎回费用＝赎回总额-赎回总额/（1+赎回费率）<br>净赎回金额＝赎回总额－赎回费用'
});

/**
 * 计算器输入项
 */
var inputForm = new Ext.FormPanel({
	title: '基金赎回计算器（仅供参考）',
	height:180,
	collapsible:true,
	padding:'10 0 0',
	labelWidth:120,
	items:[
	{xtype: 'numberfield',name: 'PER',fieldLabel: '赎回份数(份)<font color=red>*</font>',width: 180,allowBlank:false},
	{xtype: 'numberfield',name: 'UNIT_PRICE',fieldLabel: '基金单位面值(元)<font color=red>*</font>',width: 180,allowBlank:false},
	{xtype: 'numberfield',name: 'RATE',fieldLabel: '赎回费率(%)<font color=red>*</font>',width: 180,allowBlank:false},
	{
	    columnWidth:1,
	    layout:'column',
	    padding:'5 115 0',
	    items:[
			{xtype:'button',text:'计算',width:80,style: {marginRight:'10px'},handler:function(){
				calc();
			}},
			{xtype:'button',text:'重置',width:80,handler:function(){
				inputForm.getForm().reset();
				outputForm.getForm().reset();
			}}
		]
	}
	]
});

/**
 * 计算器输出项说明
 */
var outputForm = new Ext.FormPanel({
	title: '计算结果',
	height:160,
	collapsible:true,
	padding:'10 0 0',
	labelWidth:120,
	items:[
		{xtype: 'textfield',name: 'RESULT_MONEY1',fieldLabel: '赎回总额(元)',width: 180,disabled:true},
		{xtype: 'textfield',name: 'RESULT_MONEY2',fieldLabel: '赎回费用(元)',width: 180,disabled:true},
		{xtype: 'textfield',name: 'RESULT_MONEY3',fieldLabel: '净赎回金额(元)',width: 180,disabled:true}
	]
});


//结果域扩展功能面板
var customerView = [{
	/**
	 * 自定义计算器面板
	 */
	title:'计算器面板',
	hideTitle: true,
	layout: 'form',
	items: [inputForm,outputForm,notesForm]
}];

/**
 * 计算方法
 */
var calc = function(){
	if(!inputForm.getForm().isValid()){
		Ext.Msg.alert('提示','输入格式有误或存在漏输入项，请重新输入');
		return false;
	}
	var formValue = inputForm.getForm().getValues();
	
	//赎回总额＝赎回份数×基金单位面值
	//赎回费用＝赎回总额-赎回总额/（1+赎回费率）
	//净赎回金额＝赎回总额－赎回费用
	var resultMoney1 = Number(formValue.PER) * Number(formValue.UNIT_PRICE);
	var resultMoney2 = resultMoney1 - resultMoney1/(1+Number(formValue.RATE) * 0.01);
	var resultMoney3 = resultMoney1- resultMoney2;	
	outputForm.getForm().findField('RESULT_MONEY1').setValue(resultMoney1.toFixed(4));
	outputForm.getForm().findField('RESULT_MONEY2').setValue(resultMoney2.toFixed(4));
	outputForm.getForm().findField('RESULT_MONEY3').setValue(resultMoney3.toFixed(4));
}