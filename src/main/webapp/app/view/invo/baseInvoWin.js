Ext.define('BudgetMS.view.invo.baseInvoWin', {
	extend : 'Ext.window.Window',
	name : 'invo',
	layout : {
		type : 'hbox',
		align : 'stretch'
	},
	height : 500,
	width : 800,
	autoShow : true,
	initComponent : function() {
		this.items = invoFormItems;
		this.callParent(arguments);
	}
});
var invoFormItems = [ {
	flex : 1,
	xtype : 'form',
	layout : 'auto',
	items : [ {
		xtype : 'textfield',
		name : 'invoId',
		fieldLabel : '发票编号'
	}, {
		xtype : 'textfield',
		name : 'invoAmt',
		fieldLabel : '发票金额',
		vtype : 'money'
	}, {
		xtype : 'textfield',
		name : 'contPaymentId',
		fieldLabel : '合同付款编号',
		valueField : 'typeId',
		displayField : 'typeName',
		allowBlank:false
	}, 
//	{
//		xtype : 'combo',
//		name : 'transfered',
//		fieldLabel : '是否移交',
//		valueField : 'typeId',
//		displayField : 'typeName',
//		store : {
//			fields : [ 'typeId', 'typeName' ],
//			data : [ {
//				"typeId" : "0",
//				"typeName" : "否"
//			}, {
//				"typeId" : "1",
//				"typeName" : "是"
//			} ]
//		}
//	},
	,{
		xtype:'textfield',
		name:'invoCompany',
		fieldLabel:'公司'
	},
	{
		xtype : 'textfield',
		name : 'remark',
		fieldLabel : '备注'
	} ]
// 上传文件的组件
}, {
	flex : 1,
	xtype : 'baseFileGrid',
	name : 'invo'
} ];