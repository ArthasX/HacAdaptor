/**
 * 项目表头
 * 
 */
var proInfoAdjColum = [ {
	header : '项目信息调整编号',
	dataIndex : 'proInfoAdjId',
	width : 150
}, {
	header : '项目信息编号',
	dataIndex : 'proInfoId',
	width : 150
}, {
	header : '调整类型',
	dataIndex : 'adjType',
	renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		var items = typeInfoStore.data.items;
		var l = items.length;
		for (var i = 0; i < l; i++) {
			if (value == items[i].data.typeId)
				return items[i].data.typeName;
			else
				continue;
		}
		return '数据有误';
	}
}, {
	header : '调整金额',
	dataIndex : 'AdjAmt'

}, {
	header : '操作日期',
	dataIndex : 'optDate'
}, {
	header : '备注',
	dataIndex : 'remark',

} ];

Ext.define('BudgetMS.view.pro.proInfoAdj.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.proInfoAdjList',
	id : 'proInfoAdjList',
	name : 'proInfoAdj',// Ext.widget(name+'Edit') name+'Add'
	store : 'proInfoAdjStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'proInfoAdjTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'proInfoAdjStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {
		this.columns = proInfoAdjColum;
		this.callParent(arguments);
		console.log(this.name);
		// Ext.apply(this.down('pagingToolbar').store,Ext.create('BudgetMS.store.proStore'));
	}

});
