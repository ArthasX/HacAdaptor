Ext.define('BudgetMS.view.pro.proInfoAdj.proInfoAdjTbarForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.proInfoAdjTbarForm',
	layout : {
		type : 'hbox',
		align : 'stretch'
	},
	border : false,
	items : [ {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'textfield',
			name : 'proInfoAdjId',
			fieldLabel : '项目信息调整编号'
		}, {
			xtype : 'textfield',
			name : 'proInfoId',
			fieldLabel : '项目信息编号'
		}, {
			xtype : 'doFindBtn',
			text : '查询',
			name : 'findProInfoAdj',
			action : 'pro/findProInfoAdjByPage.do'
		}, {
			xtype : 'showAddBtn',
			text : '添加',
			name : 'showAddProInfoAdj'

		}, {
			xtype : 'showUpdBtn',
			text : '修改',
			name : 'showUpdateProInfoAdj'

		}, {
			xtype : 'doDelBtn',
			text : '刪除',
			name : 'deleteProInfoAdj',
			action : 'pro/deleteProInfoAdj.do'
		} ]
	}, {
		flex : 1,
		border : false,
		items : [ {
			xtype : 'typeInfoCombo',
			name : 'adjType',
			fieldLabel : '调整类型',
			category : 'proInfoAdj',
			emptyText : "请选择...",
			allowBlank : true
		// xtype : 'combo',
		// name : 'proType',
		// fieldLabel : '项目类型',
		// valueField : 'typeId',
		// displayField : 'typeName',
		// emptyText : "请选择...",
		// allowBlank:true,
		// store : {
		// fields : [ 'typeId', 'typeName' ],
		// data : [ {
		// "typeId" : "项目建设",
		// "typeName" : "项目建设"
		// }, {
		// "typeId" : "全行维保",
		// "typeName" : "全行维保"
		// }, {
		// "typeId" : "基础运营",
		// "typeName" : "基础运营"
		// } ]
		// }
		} ]
	} ]
});