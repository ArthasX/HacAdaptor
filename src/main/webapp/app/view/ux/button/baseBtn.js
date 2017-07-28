Ext.define('BudgetMS.view.ux.button.baseBtn', {
    extend: 'Ext.button.Button',
    // alias:'widget.baseBtn',
    // .init..configs..
    listeners: {
        // init listeners
        // 'click' : function(btn, e, eOpts) {
        // var record = btn.up('window').down('form').getForm()
        // .getFieldValues();
        // console.log(record);
        // var tabpanel = Ext.getCmp('mainTabpanel');
        // var tab = tabpanel.getActiveTab();
        // var grid = tab.down('gridview');
        // var url = btn.action;
        // doCRUDAjax(record, url, grid);
        // }
    },
    addorupdate: function (btn, e, eOpts) {
        var win = btn.up('window');
        var form = win.down('form').getForm();
        if (!form.isValid()) {
            Ext.Msg.alert('注意', '红框处不能为空或格式错误');
            return;
        }
        var record = form.getFieldValues();
        var tabpanel = Ext.getCmp('mainTabpanel');
        var tab = tabpanel.getActiveTab();
        var grid = tab.down('gridview');
        var url = btn.action;
        this.doCRUDAjax(record, url, grid, win);
    },
    test: function () {
        console.log(this, this.test);
    },
    doCRUDAjax: function (params, url, grid, win) {
//		 debugger;
        console.log('doCRUDAjax')
        console.log(params);
        var p = {
            obj: Ext.JSON.encode(params)
        };
        Ext.Ajax.request({
            url: url,
            params: p,
            success: function (response) {
                var text = response.responseText;
                console.log(text);
                var msg = Ext.JSON.decode(text);
                if (msg.success) {
                    Ext.Msg.alert('成功', msg.msg);
                    grid.store.reload();
                    //win.close(); 暂时不要自动关闭
                } else
                    Ext.Msg.alert('失败', msg.msg);
            },
            failure: function (response) {
                Ext.Msg.alert('状态', response.statusText + "\n timedout:"
                    + response.timedout + "\n 请联系管理员");

            }
        });
    }

});

