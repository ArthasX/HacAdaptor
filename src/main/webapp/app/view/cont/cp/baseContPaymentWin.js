Ext.define('BudgetMS.view.cont.cp.baseContPaymentWin', {
	extend : 'Ext.window.Window',
	// layout : {
	// type : 'hbox',
	// align : 'stretch'
	// },
	// autoShow : true,
	// height : 500,
	// width : 800,
	initComponent : function() {
		this.items = contPaymentFormItems;
		this.callParent(arguments);
		// this.down('form').getForm().findField('contId').setValue(genContPaymentId());
	}
});

var contPaymentFormItems = [ {
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'contPaymentId',
		fieldLabel : '合同付款编号',
	}, {
		xtype : 'textfield',
		name : 'period',
		fieldLabel : '期数',
	}, {
		xtype : 'textfield',
		name : 'contId',
		fieldLabel : '合同编号',
	}, {
		xtype : 'textfield',
		name : 'payAmt',
		fieldLabel : '付款金额'
	}, {
		xtype : 'datefield',
		name : 'expectPayDate',
		fieldLabel : '预计付款日期',
		editable : true,
		emptyText : "--请选择--",
		format : "Y-m-d"
	}, {
		xtype : 'combo',
		name : 'isPaid',
		fieldLabel : '是否付款',
		valueField : 'typeId',
		displayField : 'typeName',
		store : {
			fields : [ 'typeId', 'typeName' ],
			data : [ {
				"typeId" : "是",
				"typeName" : "是"
			}, {
				"typeId" : "否",
				"typeName" : "否"
			} ]
		}
	}, {
		xtype : 'textarea',
		name : 'remark',
		fieldLabel : '备注'
	} ]
} ];
