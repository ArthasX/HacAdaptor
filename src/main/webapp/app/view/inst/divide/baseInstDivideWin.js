Ext.define('BudgetMS.view.inst.divide.baseInstDivideWin', {
	extend : 'Ext.window.Window',
	name : 'instDivide',
	// layout : {
	// type : 'hbox',
	// align : 'stretch'
	// },
	// height : 500,
	// width : 800,
	autoShow : true,
	initComponent : function() {
		// debugger;
		this.items = instDivideFormItems;
		this.callParent(arguments);
	}
});

var instDivideFormItems = [ {
	flex : 1,
	xtype : 'form',
	layout : 'auto',
	items : [ , {
		xtype : 'textfield',
		name : 'instDivideId',
		fieldLabel : '请示拆分编号'
	}, {
		xtype : 'textfield',
		name : 'instId',
		fieldLabel : '请示编号'
	}, {
		xtype : 'textfield',
		name : 'divideNo',
		fieldLabel : '拆分序号'
	}, {
		xtype : 'textfield',
		name : 'divideAmt',
		fieldLabel : '拆分金额',
		vtype : 'money'
	}, {
		xtype : 'combo',
		name : 'divideStatus',
		fieldLabel : '请示拆分使用情况',
		valueField:'typeId',
		displayField:'typeName',
		store : {
			fields : [ 'typeId', 'typeName' ],
			data : [ {
				"typeId" : "已使用",
				"typeName" : "已使用"
			}, {
				"typeId" : "待使用",
				"typeName" : "待使用"
			}, {
				"typeId" : "未使用",
				"typeName" : "未使用"
			} , {
				"typeId" : "不使用",
				"typeName" : "不使用"
			}]
		}
			
	}, {
		xtype : 'textfield',
		name : 'proInfoId',
		fieldLabel : '项目信息编号'
	}, {
		xtype : 'textfield',
		name : 'remark',
		fieldLabel : '备注'
	} ]
} ];