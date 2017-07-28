Ext.define('BudgetMS.view.ux.button.doFindBtn', {
	extend : 'BudgetMS.view.ux.button.baseBtn',
	alias : 'widget.doFindBtn',
	listeners : {
		'click' : function(btn, e, eOpts) {
			var tabpanel = Ext.getCmp('mainTabpanel');
			var tab = tabpanel.getActiveTab();
			var form = tab.down('form').getForm();
			var grid = tab.down('gridview');
			if (!form.isValid()) {
				Ext.Msg.alert('注意', '请按正确的格式输入')
				return;
			}
            // grid.store.currentPage=1;
			// grid.store.reload({start:0,limit:PAGE_SIZE});
			grid.store.loadPage(1,{start:0,limit:PAGE_SIZE});
		}
	}
});