Ext.define('BudgetMS.view.cont.adj.baseContAdjWin', {
	extend : 'Ext.window.Window',
	// layout : {
	// type : 'hbox',
	// align : 'stretch'
	// },
	// autoShow : true,
	// height : 500,
	// width : 800,
	initComponent : function() {
		this.items = contAdjFormItems;
		this.callParent(arguments);
		// this.down('form').getForm().findField('contId').setValue(genContAdjId());
	}
});

var contAdjFormItems = [ {
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'contAdjId',
		fieldLabel : '合同调整编号',
	}, {
		xtype : 'textfield',
		name : 'contPaymentId',
		fieldLabel : '合同付款编号',
	}, {
		xtype : 'combo',
		name : 'adjType',
		fieldLabel : '调整类型',
		valueField : 'typeId',
		displayField : 'typeName',
		store : {
			fields : [ 'typeId', 'typeName' ],
			data : [ {
				"typeId" : "金额",
				"typeName" : "金额"
			}, {
				"typeId" : "日期",
				"typeName" : "日期"
			} ]
		}
	}, {
		xtype : 'datefield',
		name : 'adjDate',
		fieldLabel : '调整日期',
		editable : true,
		emptyText : "--请选择--",
		format : "Y-m-d"
	}, {
		xtype : 'textfield',
		name : 'adjAmt',
		fieldLabel : '调整金额'
	}, {
		xtype : 'textarea',
		name : 'remark',
		fieldLabel : '备注'
	} ]
} ];
