/**
 * 合同表头
 * 
 */
var contColum = [ {
// 	xtype : 'checkcolumn',
// 	text : '选中',
// 	dataIndex : 'active'
// }, {
	header : '合同编号',
	dataIndex : 'contId',
	width : 150
}, {
	header : '请示拆分编号',
	dataIndex : 'instDivideId',
	width : 150
}, {
    header : '招标编号',
    dataIndex : 'tenderId',
    width : 150
} , {
	header : '合同名称',
	dataIndex : 'contName',
	width : 150
},{
	header : '公司',
	dataIndex : 'contCompany',
	width : 150
}, {
	header : '合同类型',
	dataIndex : 'contType',
	renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		var items=typeInfoStore.data.items;
		var l=items.length;
		for(var i=0;i<l;i++){
			if(value==items[i].data.typeId)
				return items[i].data.typeName;
			else
				continue;
		}
		return '数据有误';
	}
}, {
	header : '合同金额',
	dataIndex : 'contAmt'
}, {
	header : '签订日期',
	dataIndex : 'signedDate',

}, {
	header : '签订人',
	dataIndex : 'signedPerson',

}, {
	header : '操作时间',
	dataIndex : 'optDate',

}, {
	header : '操作人',
	dataIndex : 'optUser',

}, {
	header : '备注',
	dataIndex : 'remark',

}];

Ext.define('BudgetMS.view.cont.list', {
	extend : 'BudgetMS.view.ux.baseGrid',
	alias : 'widget.contList',
	id : 'contList',
	name : 'cont',// Ext.widget(name+'Edit') name+'Add'
	store : 'contStore',
	border : false,
	// frame : true,// 渲染
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		items : [ {
			xtype : 'contTbarForm'
		} ]
	},
	dockedItems : [ {
		xtype : 'pagingtoolbar',
		store : 'contStore',
		dock : 'bottom',
		displayInfo : true
	} ],
	initComponent : function() {
		this.columns = contColum;
		this.callParent(arguments);
		// Ext.apply(this.down('pagingToolbar').store,Ext.create('BudgetMS.store.contStore'));
	}

});

/**
 * 分页工具栏
 */

// var pagingToolbar = Ext.create('Ext.PagingToolbar', {
// store : 'contStore',
// displayInfo : true,
// displayMsg : 'Displaying topics {0} - {1} of {2}',
// emptyMsg : "No topics to display",
// items : [ '-', {
// text : 'Show Preview',
// pressed : true,
// enableToggle : true,
// toggleHandler : function(btn, pressed) {
// //var preview = Ext.getCmp('gv').getPlugin('preview');
// //preview.toggleExpanded(pressed);
// }
// } ]
// });
// /**
// * 提取了一个停靠组件的类，方便维护
// */
// Ext.define('oaSystem.view.main.region.GridToolbar', {
// extend : 'Ext.toolbar.Toolbar',
// alias : 'widget.gridtoolbar',
// initComponent : function() {
// this.items = [{
// text : '新增',
// glyph : 0xf016,
// },{
// text : '修改',
// glyph : 0xf044
// },{
// text : '删除',
// glyph : 0xf014
// },{
// text : '查看',
// glyph : 0xf022
// }];
// this.callParent();
// }
// });
//
