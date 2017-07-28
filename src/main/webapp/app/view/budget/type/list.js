var budgetTypeColumn = [ {
	header : '预算编号',
	dataIndex : 'budgetTypeId',
}, {
	header : '预算名称',
	dataIndex : 'budgetName',
}, {
	header : '预算类型',
	dataIndex : 'budgetType',
	
}, {
	header : '备注',
	dataIndex : 'remark',
}];

Ext.define('BudgetMS.view.budget.type.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.budgetTypeList',
	id : 'budgetTypeList',
	name : 'budgetType',// Ext.widget(name+'Edit') name+'Add'
	store : 'budgetTypeStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'budgetTypeTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'budgetTypeStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {
		this.columns = budgetTypeColumn;
		this.callParent(arguments);
	}

});
