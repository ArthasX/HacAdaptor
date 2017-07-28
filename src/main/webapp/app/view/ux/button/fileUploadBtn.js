Ext.define('BudgetMS.view.ux.button.fileUploadBtn', {
    extend: 'BudgetMS.view.ux.button.baseBtn',
    alias: 'widget.fileUploadBtn',
    text: '上传',
    listeners: {
        'click': function (btn, e) {
            var form = btn.up('form').getForm();
            console.log(btn, btn.ownerCt, btn.ownerCt.ownerCt);
            var grid = btn.up('baseFileGrid');
            var attachType = grid.name;
            var store = grid.getStore();
            var count = store.getCount();
            var recordId = btn.up('window').down('form').getForm().findField(attachType + 'Id').getValue()
            var fileName = form.findField('fileUpload').getRawValue();// 上传文件名称的路径
            if(recordId==""){
                Ext.Msg.show({
                    title:'提示',
                    msg:'编号不能为空',
                    button:Ext.Msg.OK,
                    icon:Ext.MessageBox.INFOR
                });
                return;
            }
            if (fileName == "") {
                Ext.Msg.show({
                    title: '提示',
                    msg: '请选择文件!',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFOR
                });
                return;
            } else {
                var array = fileName.split("\\");
                var fileName = "";
                for (var index in array) {
                    if (fileName == "") {
                        fileName = array[index];
                    } else {
                        fileName = fileName + "/" + array[index];
                    }
                }
            }
            console.log('filename:', fileName, 'count:', count);
            form.submit({
                url: 'attach/upload.do',
                params: {recordId: recordId, attachType: attachType, count: count},
                method: 'POST',
                waitMsg: '数据上传中, 请稍等...',
                success: function (form, action) {
                    Ext.MessageBox.alert("提示信息", action.result.msg);
                    grid.loadFile();
                },
                failure: function (form, action) {
                    // if (action.failureType === Ext.form.action.Action.CONNECT_FAILURE) {
                    //     Ext.Msg.alert('提示信息',
                    //         'Status:' + action.response.status + ': ' +
                    //         action.response.statusText);
                    // }
                    // if (action.failureType === Ext.form.action.Action.SERVER_INVALID) {
                    //     // server responded with success = false
                    //     Ext.Msg.alert('提示信息', action.result.msg);
                    // }
                    Ext.Msg.alert('提示信息',
                        action.result.msg + '\n\r failure type:' + action.failureType
                        + '\n Status:' + action.response.status
                        + ',' + action.response.statusText);
                }
            });
        }
    }
})