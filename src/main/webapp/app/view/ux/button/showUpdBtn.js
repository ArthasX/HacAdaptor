Ext.define('BudgetMS.view.ux.button.showUpdBtn', {
    extend: 'BudgetMS.view.ux.button.baseBtn',
    alias: 'widget.showUpdBtn',
    listeners: {
        'click': function (btn, e) {
            // debugger;
            // 使用tabpanel.getActiveTab()。down('gridview')
            // 通过btn获取组件 减少hardcode 实现重用
            // debugger;
            // var tabpanel = Ext.getCmp('mainTabpanel');
            // var tab = tabpanel.getActiveTab();
            // var grid = tab.down('gridview');
            var grid = btn.up('grid');
            var record = grid.getSelectionModel().getLastSelected();
            if (!record) {
                Ext.Msg.alert('注意', '请选中一条数据');
                return;
            }
            grid.fireEvent('itemdblclick', grid, record);
        }
    }
});