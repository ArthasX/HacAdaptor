Ext.define('BudgetMS.view.pro.baseProWin', {
	extend : 'Ext.window.Window',
	name : 'pro',
//	layout : {
//		type : 'hbox',
//		align : 'stretch'
//	},
//	height : 500,
//	width : 800,
	autoShow : true,
	initComponent : function() {
		// debugger;
		this.items = proFormItems;
		this.callParent(arguments);
		var form = this.items.items[0].getForm();
	}
});

var proFormItems = [ {
	flex : 1,
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'proId',
		fieldLabel : '项目编号'
	}, {
		xtype : 'textfield',
		name : 'proName',
		fieldLabel : '项目名称'
	}, {
		xtype : 'combo',
		name : 'proType',
		fieldLabel : '项目类型',
		valueField : 'typeId',
		displayField : 'typeName',
		store : {
			fields : [ 'typeId', 'typeName' ],
			data : [ {
				"typeId" : "项目建设",
				"typeName" : "项目建设"
			}, {
				"typeId" : "全行维保",
				"typeName" : "全行维保"
			}, {
				"typeId" : "基础运营",
				"typeName" : "基础运营"
			} ]
		}

	}, {
		xtype : 'textfield',
		name : 'budgetInfoId',
		fieldLabel : '预算信息编号'
	}, {
		xtype : 'textfield',
		name : 'remark',
		fieldLabel : '备注'
	} ]
} ];