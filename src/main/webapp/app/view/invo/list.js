/**
 * 发票表头
 * 
 */
var invoColum = [ {
	header : '发票编号',
	dataIndex : 'invoId',
	width : 150
}, {
	header : '发票金额',
	dataIndex : 'invoAmt'
}, {
	header : '合同付款编号',
	dataIndex : 'contPaymentId',
	width : 150
}, {
	header : '公司',
	dataIndex : 'invoCompany'
}, {
	header : '是否移交',
	dataIndex : 'transfered'
}, {
	header : '移交日期',
	dataIndex : 'transDate'

}, {
	header : '操作人',
	dataIndex : 'optUser',

}, {
	header : '操作日期',
	dataIndex : 'optDate',

}, {
	header : '备注',
	dataIndex : 'remark',

} ];

Ext.define('BudgetMS.view.invo.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.invoList',
	id : 'invoList',
	name : 'invo',// Ext.widget(name+'Edit') name+'Add'
	store : 'invoStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'invoTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'invoStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {

		this.columns = invoColum;
		this.callParent(arguments);

		// Ext.apply(this.down('pagingToolbar').store,Ext.create('BudgetMS.store.invoStore'));
	}

});
