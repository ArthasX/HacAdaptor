Ext.define('BudgetMS.view.pro.proInfoAdj.baseProInfoAdjWin', {
	extend : 'Ext.window.Window',
	name : 'proInfoAdj',
	// layout : {
	// type : 'hbox',
	// align : 'stretch'
	// },
	// height : 500,
	// width : 800,
	autoShow : true,
	initComponent : function() {
		// debugger;
		this.items = proInfoAdjFormItems;
		this.callParent(arguments);
		var form = this.items.items[0].getForm();
	}
});

var proInfoAdjFormItems = [ {
	flex : 1,
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'proInfoAdjId',
		fieldLabel : '项目信息编号'
	}, {
		xtype : 'textfield',
		name : 'proInfoId',
		fieldLabel : '项目信息编号'
	}, {
		xtype : 'textfield',
		name : 'adjAmt',
		fieldLabel : '调整金额',
		vtype : 'money'
	}, {
		xtype : 'typeInfoCombo',
		name : 'adjType',
		category : 'proInfoAdj',
		fieldLabel : '调整类型',
	}, {
		xtype : 'textfield',
		name : 'remark',
		fieldLabel : '备注'
	} ]
} ];