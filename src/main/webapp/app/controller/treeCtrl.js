Ext.define('BudgetMS.controller.treeCtrl', {
	extend : 'Ext.app.Controller',
	stores : [ 'treeMenuStore' ],
	views : [ 'ux.treeMenu' ],
	models : [],
	init : function() {
		this.control({
			'treeMenu' : {
				itemclick : this.treeItemClick
			}
		});
	},
	treeItemClick : function(tr, record, item, index, e, eOpts) {
		var treeNode = record.raw;
		var id = treeNode.id;
		var name = treeNode.name;
		var text = treeNode.text;
		var tabs = tr.ownerCt.ownerCt.ownerCt.child('tabpanel');
		var tab = tabs.getComponent(id);
		console.log("id:", id, "text:", text, "tab:", tab);
		try {
			if (!tab) {
				var t = {
					id : id,
					name : name,
					closable : true,
					title : text,
					iconCls : id,
					xtype : id,
					closeAction : 'hide'
				};
				tabs.add(t);
				tabs.setActiveTab(tabs.getComponent(id));
			} else {
				tabs.setActiveTab(tab);
			}
		} catch (e) {
			console.log(e);
		}
	},
	expand : function(tr, record) {
		tr.expandNode(record);
	}
});