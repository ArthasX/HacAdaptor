Ext.define('BudgetMS.view.ux.baseFileGrid', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.baseFileGrid',
	// border : false,
	//store : 'fileStore',
	enableKeyNav : true,// 键盘控制
	columnLines : true,// 竖线
	tbar : [ {
		xtype : 'form',
		border : false,
		items : [ {
			xtype : 'filefield',
			name : 'fileUpload',
			width : 300,
			fieldLabel : '附件',
			msgTarget : 'side',
			allowBlank : false,
			buttonText : '浏览'
		}, {
			xtype : 'fileUploadBtn'
		} ]
	} ],

	fileColumn : [ {
		text : '附件编号',
		dataIndex : 'attachId'
	}, {
		text : '附件名称',
		dataIndex : 'attachName'
	}, {
		text : '下载',
		xtype : 'templatecolumn',
		tpl : '<a href=attach/download.do?fileName={attachName}>下载</a>'
	}, {
		text : '删除',
		xtype : 'actioncolumn',
		items : [ {
			tooltip : 'Delete',
			icon : 'app/view/ux/del.bmp',
			handler : function(gridview, rowIndex, colIndex) {
				debugger;
				var rec = gridview.getStore().getAt(rowIndex);
				var attachId = rec.get('attachId');
				var baseFileGrid = gridview.ownerCt;
				baseFileGrid.deleteFile(baseFileGrid, attachId);
			}
		} ]
	// ,
	// renderer : function(value) {
	// alert(value);
	// return '删除';
	// }
	} ],

	initComponent : function() {
		// 可以考虑在这里 new 一个 store
		this.columns = this.fileColumn;
		var store=Ext.create('BudgetMS.store.fileStore');
		this.store=store;
        this.callParent(arguments);
	},
	listeners : {
		'itemdblclick' : function(grid, record) {
			console.log(record.data)
		}
	},
	loadFile : function() {
		// debugger;
		console.log('loadFile')
		var win = this.up('window');
		var recordId = win.down('form').getForm().findField(this.name + 'Id')
				.getValue();
		var store = this.getStore();
		var obj = {
			recordId : recordId,
			attachType : this.name
		};
		var params = {
			obj : Ext.JSON.encode(obj)
		};
		// var store = Ext.create('BudgetMS.store.fileStore');
		// store.proxy.extraParams = params;

		console.log(recordId, store, obj, params);
		Ext.apply(store.proxy.extraParams, params);
		// Ext.apply(this.store, store);
		store.load();
	},
	deleteFile : function(grid, attachId) {
		console.log('delelte file - attachId:' + attachId);
		// var fileGrid = this;
		var confirm = Ext.Msg.confirm('确认', '是否删除编号为:' + attachId + '的附件记录?',
				function(btn) {
					if (btn == 'yes') {
						var params = {
							attachId : attachId
						};
						grid.doAjax(params, 'attach/delete.do')
					}
				});
	},

	doAjax : function(p, url) {
		var grid=this;
		Ext.Ajax.request({
			url : url,
			params : p,
			success : function(response) {
				var text = response.responseText;
				console.log(text);
				var msg = Ext.JSON.decode(text);
				if (msg.success) {
					debugger;
					console.log(this);
					grid.loadFile();
					Ext.Msg.alert('成功', msg.msg);
					
				} else
					Ext.Msg.alert('失败', msg.msg);
			},
			failure : function(response) {
				Ext.Msg.alert('状态', response.statusText + "->timedout:"
						+ response.timedout + " 请联系管理员");

			}
		});
		
	}
});
