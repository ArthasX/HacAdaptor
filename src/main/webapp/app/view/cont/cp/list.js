var contPaymentColumn = [ {
	header : '合同付款编号',
	dataIndex : 'contPaymentId',
	width : 150
}, {
	header : '合同编号',
	dataIndex : 'contId',
	width : 150
}, {
	header : '期数',
	dataIndex : 'period',
	width : 150
}, {
	header : '付款金额',
	dataIndex : 'payAmt',
	width : 150
}, {
	header : '预计付款日期',
	dataIndex : 'expectPayDate',
	width : 150
}, {
	header : '是否付款',
	dataIndex : 'isPaid'
}, {
	header : '备注',
	dataIndex : 'remark',

}, {

} ];

Ext.define('BudgetMS.view.cont.cp.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.contPaymentList',
	id : 'contPaymentList',
	name : 'contPayment',// Ext.widget(name+'Edit') name+'Add'
	store : 'contPaymentStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'contPaymentTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'contPaymentStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {
		this.columns = contPaymentColumn;
		this.callParent(arguments);
	}

});
