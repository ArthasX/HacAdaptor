Ext.define('BudgetMS.view.inst.baseInstWin', {
    extend: 'Ext.window.Window',
    name: 'inst',
    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    height: 500,
    width: 800,
    autoShow: true,
    initComponent: function () {
        this.items = instFormItems;
        this.callParent(arguments);
        // var form = this.items.items[0].getForm();
    }
});

var instFormItems = [{
    flex: 1,
    xtype: 'form',
    layout: 'auto',
    items: [{
        xtype: 'textfield',
        name: 'instId',
        fieldLabel: '请示编号'
    }, {
        xtype: 'textfield',
        name: 'instTitle',
        fieldLabel: '请示标题'
    }, {
        xtype: 'textarea',
        name: 'instContent',
        fieldLabel: '请示内容'
    }, {
        xtype: 'typeInfoCombo',
        name: 'instType',
        category: 'instType',
        fieldLabel: '请示类型'
    }, {
        xtype: 'combo',
        name: 'instStatus',
        fieldLabel: '请示状态',
        valueField: 'typeId',
        displayField: 'typeName',
        store: {
            fields: ['typeId', 'typeName'],
            data: [{
                "typeId": "在途",
                "typeName": "在途"
            }, {
                "typeId": "审批结束",
                "typeName": "审批结束"
            }]
        }
    }, {
        xtype: 'deptCombo',
        name: 'applyDept'
    }, {
        xtype: 'textfield',
        name: 'instAmt',
        fieldLabel: '请示金额',
        vtype: 'money'
    }, {
        xtype: 'textfield',
        name: 'softAmt',
        fieldLabel: '软件金额',
        vtype: 'money'
    }, {
        xtype: 'textfield',
        name: 'hardAmt',
        fieldLabel: '硬件金额',
        vtype: 'money'
    }, {
        xtype: 'textfield',
        name: 'applyUserName',
        fieldLabel: '申请人'
    }, {
        xtype: 'textfield',
        name: 'remark',
        fieldLabel: '备注'
    }]
}, {// 上传文件的组件
    flex: 1,
    xtype: 'baseFileGrid',
    name: 'inst'
}];