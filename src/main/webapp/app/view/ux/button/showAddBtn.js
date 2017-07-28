Ext.define('BudgetMS.view.ux.button.showAddBtn', {
    extend: 'BudgetMS.view.ux.button.baseBtn',
    alias: 'widget.showAddBtn',
    listeners: {
        'click': function (btn, e) {
            // var tabpanel = Ext.getCmp('mainTabpanel');
            // var tab = tabpanel.getActiveTab();
            // var view = Ext.widget(tab.name + 'Add');
            // var view = Ext.create('BudgetMS.view.inst.add');// = Ext.widget
            // var grid = tab.down('gridview');
            var grid = btn.up('grid');// grid组件对象
            var view = Ext.widget(grid.name + 'Add');
            var fileGrid = view.down('baseFileGrid');
            // fileGrid.loadFile();
            // fileGrid.remove(grid.store.data.items);
            if (fileGrid)
                fileGrid.store.data.removeAll();
        }
    }
});