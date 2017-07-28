Ext.define('BudgetMS.view.ux.baseGrid', {
	extend : 'Ext.grid.Panel',
	border : false,
	// frame : true,// 渲染

	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : {
		layout : {
			type : 'hbox',
			align : 'stretch'
		}
	},
	listeners : {
		'itemdblclick' : function(g, record) {
			// debugger;
			console.log('Double clicked on ', record.data);
			var view = Ext.widget(this.name + 'Edit');
			view.down('form').loadRecord(record);
			var fileGrid = view.down('baseFileGrid');
			if (fileGrid)
				view.down('baseFileGrid').loadFile();
		}
	},
	viewConfig : {
		enableTextSelection : true
	},
	initComponent : function() {
		this.callParent(arguments);
		console.log('basegrid', this.down('pagingtoolbar'));
	}

});