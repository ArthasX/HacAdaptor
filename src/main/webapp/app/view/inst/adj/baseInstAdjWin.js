Ext.define('BudgetMS.view.inst.adj.baseInstAdjWin', {
	extend : 'Ext.window.Window',
	name : 'instAdj',
//	layout : {
//		type : 'hbox',
//		align : 'stretch'
//	},
//	height : 500,
//	width : 800,
	autoShow : true,
	initComponent : function() {
		// debugger;
		this.items = instAdjFormItems;
		this.callParent(arguments);
	}
});

var instAdjFormItems = [ {
	flex : 1,
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'instAdjId',
		fieldLabel : '请示调整编号'
	}, {
		xtype : 'textfield',
		name : 'instId',
		fieldLabel : '请示编号'
	}, {
		xtype : 'textfield',
		name : 'instDivideId',
		fieldLabel : '请示拆分编号'
	}, {
		xtype : 'textfield',
		name : 'instAdjAmt',
		fieldLabel : '请示调整金额',
		vtype : 'money'
	}, {
		xtype : 'textfield',
		name : 'remark',
		fieldLabel : '备注'
	} ]
} ];