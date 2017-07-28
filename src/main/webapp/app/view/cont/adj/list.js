var contAdjColumn = [ {
	header : '合同调整编号',
	dataIndex : 'contAdjId',
	width : 150
}, {
	header : '合同付款编号',
	dataIndex : 'contPaymentId',
	width : 150
}, {
	header : '调整类型',
	dataIndex : 'adjType',
	width : 150
}, {
	header : '调整日期',
	dataIndex : 'adjDate',
	width : 150
}, {
	header : '调整金额',
	dataIndex : 'adjAmt',
	width : 150
}, {
	header : '备注',
	dataIndex : 'remark',

}];

Ext.define('BudgetMS.view.cont.adj.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.contAdjList',
	id : 'contAdjList',
	name : 'contAdj',// Ext.widget(name+'Edit') name+'Add'
	store : 'contAdjStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'contAdjTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'contAdjStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {
		this.columns = contAdjColumn;
		this.callParent(arguments);
	}

});
