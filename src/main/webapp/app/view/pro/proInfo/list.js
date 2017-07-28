/**
 * 项目表头
 * 
 */
var proInfoColum = [ {
	header : '项目信息编号',
	dataIndex : 'proInfoId',
	width : 150
}, {
	header : '项目金额',
	dataIndex : 'proAmt',
	width : 150
}, {
	header : '项目状态',
	dataIndex : 'proStatus'
}, {
	header : '项目编号',
	dataIndex : 'proId'

}, {
	header : '年度',
	dataIndex : 'year',

} , {
	header : '备注',
	dataIndex : 'remark',

} ];

Ext.define('BudgetMS.view.pro.proInfo.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.proInfoList',
	id : 'proInfoList',
	name : 'proInfo',// Ext.widget(name+'Edit') name+'Add'
	store : 'proInfoStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'proInfoTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'proInfoStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {
		this.columns = proInfoColum;
		this.callParent(arguments);
		console.log(this.name);
		// Ext.apply(this.down('pagingToolbar').store,Ext.create('BudgetMS.store.proInfoStore'));
	}

});
 