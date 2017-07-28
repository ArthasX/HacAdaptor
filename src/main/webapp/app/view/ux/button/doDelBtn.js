Ext.define('BudgetMS.view.ux.button.doDelBtn', {
    extend: 'BudgetMS.view.ux.button.baseBtn',
    alias: 'widget.doDelBtn',
    listeners: {// 暂时就写死吧
        'click': function (btn, e, eOpts) {
            // var btnName = btn.name;// 根据button的name来确定他的ownerCt的类型
            var grid = btn.up('grid');// grid组件对象
            var fieldName = grid.name + 'Id';// 字段名称 instId contId invoId
            var record = grid.getSelectionModel().getLastSelected();
            if (!record) {
                Ext.MessageBox.alert('注意', '请选中一条记录!');
                return;
            }
            var id = record.data[fieldName];
            var params = id;
            var url = btn.action;
            var delBtn = this;
            var confirm = Ext.Msg.confirm('确认', '是否删除编号为:' + id + '的记录?',
                function (btn) {
                    if (btn == 'yes') {
                        delBtn.doCRUDAjax(params, url, grid);
                    }
                });
        }
    }
});