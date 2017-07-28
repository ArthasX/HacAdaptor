Ext.define('BudgetMS.view.pro.proInfo.baseProInfoWin', {
	extend : 'Ext.window.Window',
	name : 'proInfo',
//	layout : {
//		type : 'hbox',
//		align : 'stretch'
//	},
//	height : 500,
//	width : 800,
	autoShow : true,
	initComponent : function() {
		// debugger;
		this.items = proInfoFormItems;
		this.callParent(arguments);
		var form = this.items.items[0].getForm();
	}
});

var proInfoFormItems = [ {
	flex : 1,
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'proInfoId',
		fieldLabel : '项目信息编号'
	},{
		xtype : 'textfield',
		name : 'proId',
		fieldLabel : '项目编号'
	}, {
		xtype : 'textfield',
		name : 'proAmt',
		fieldLabel : '项目金额',
		vtype:'money'
	}, {
		xtype : 'combo',
		name : 'proStatus',
		fieldLabel : '项目类型',
		valueField : 'typeId',
		displayField : 'typeName',
		store : {
			fields : [ 'typeId', 'typeName' ],
			data : [ {
				"typeId" : "正常",
				"typeName" : "正常"
			}, {
				"typeId" : "取消",
				"typeName" : "取消"
			} ]
		}

	}, {
		xtype : 'textfield',
		name : 'year',
		fieldLabel : '年度'
	}, {
		xtype : 'textfield',
		name : 'remark',
		fieldLabel : '备注'
	} ]
} ];