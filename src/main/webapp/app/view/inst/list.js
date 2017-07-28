/**
 * 请示表头
 * 
 */
var instColum = [ {
	header : '请示编号',
	dataIndex : 'instId',
	width : 150
}, {
	header : '请示标题',
	dataIndex : 'instTitle',
	width : 150
}, {
	header : '请示内容',
	dataIndex : 'instContent',
	width : 150
}, {
	header : '请示类型',
	dataIndex : 'instType',
	renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		var items=typeInfoStore.data.items;
		for(var i in items){
			if(value==items[i].data.typeId)
				return items[i].data.typeName;
			else
				continue;
		}
		return '数据有误';
	}
}, {
	header : '请示状态',
	dataIndex : 'instStatus'
}, {
	header : '申请部门',
	dataIndex : 'applyDept',
	renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
//		debugger;
		var l=deptStore.data.items.length;
		var items=deptStore.data.items;
		for(var i=0;i<l;i++){
			if(value==items[i].data.deptId)
				return items[i].data.deptName;
			else
				continue;
		}
		return '数据有误';
	}

}, {
	header : '请示金额',
	dataIndex : 'instAmt'
}, {
	header : '软件金额',
	dataIndex : 'softAmt'

}, {
	header : '硬件金额',
	dataIndex : 'hardAmt'
},
// {
// header : '申请人',
// dataIndex : 'applyUser',
//	
// },
{
	header : '申请人',
	dataIndex : 'applyUserName',

}, {
	header : '操作时间',
	dataIndex : 'optDate',

}, {
	header : '操作人',
	dataIndex : 'optUser',

}, {
	header : '备注',
	dataIndex : 'remark',

}, {

} ];

Ext.define('BudgetMS.view.inst.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.instList',
	id : 'instList',
	name : 'inst',// Ext.widget(name+'Edit') name+'Add'
	store : 'instStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'instTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'instStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {
		this.columns = instColum;
		this.callParent(arguments);
		// Ext.apply(this.down('pagingToolbar').store,Ext.create('BudgetMS.store.instStore'));
	}

});
