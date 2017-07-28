Ext.define('BudgetMS.store.baseStore', {
	extend : 'Ext.data.Store',
	pageSize : PAGE_SIZE,
	listeners : {
		'beforeload' : function(store, operation, eOpts) {
//			debugger;
			// var fname = store.name + 'TbarForm';
			// var form = Ext.widget(fname).getForm();
			var tabpanel = Ext.getCmp('mainTabpanel');
			var tab = tabpanel.getActiveTab();
			var hasForm = tab.down('form');
			var form;
			var params;
			if (hasForm) {
				form=hasForm.getForm();
				params = {
					obj : Ext.JSON.encode(form.getValues())
				};
			} else {
				params = {obj:'{}'};
			}
			console.log('['+this.name+']'+"beforeload set params:");
			console.log(params);
			Ext.apply(store.proxy.extraParams, params);
		}
	}
});

// fields:'',
