/**
 * 请示表头
 * 
 */
var instAdjColum = [ {
	header : '请示调整编号',
	dataIndex : 'instAdjId',
	width : 150
}, {
	header : '请示编号',
	dataIndex : 'instId',
	width : 150
}, {
	header : '请示拆分编号',
	dataIndex : 'instDivideId',
	width : 150
}, {
	header : '请示调整金额',
	dataIndex : 'instAdjAmt'
}, {
	header : '备注',
	dataIndex : 'remark',

}];

Ext.define('BudgetMS.view.inst.adj.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.instAdjList',
	id : 'instAdjList',
	name : 'instAdj',// Ext.widget(name+'Edit') name+'Add'
	store : 'instAdjStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'instAdjTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'instAdjStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {
		this.columns = instAdjColum;
		this.callParent(arguments);
		// Ext.apply(this.down('pagingToolbar').store,Ext.create('BudgetMS.store.instAdjStore'));
	}

});
