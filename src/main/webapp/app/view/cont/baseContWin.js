Ext.define('BudgetMS.view.cont.baseContWin', {
    extend: 'Ext.window.Window',
    title: '合同新增',
    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    autoShow: true,
    height: 500,
    width: 800,
    initComponent: function () {
        this.items = contFormItems;
        this.callParent(arguments);
        //this.down('form').getForm().findField('contId').setValue(genContId());
    }
});

var contFormItems = [{
    xtype: 'form',
    layout: 'auto',
    items: [{
        xtype: 'textfield',
        name: 'contId',
        fieldLabel: '合同编号',
        readOnly: true
    }, {
        xtype: 'textfield',
        name: 'contName',
        fieldLabel: '合同名称'
    }, {
        xtype: 'textfield',
        name: 'instDivideId',
        fieldLabel: '请示拆分编号'
    }, {
        xtype: 'textfield',
        name: 'tenderId',
        fieldLabel: '招标编号',
        allowBlank: false
    }, {
        xtype: 'typeInfoCombo',//自定义的combo  typeInfo表 category 区分
        name: 'contType',
        category: 'cont',
        fieldLabel: '合同类型'
    }, {
        xtype: 'textfield',
        name: 'contCompany',
        fieldLabel: '公司'
    }, {
        xtype: 'textfield',
        name: 'contAmt',
        fieldLabel: '合同金额',
        vtype: 'money'
    }, {
        xtype: 'datefield',
        name: 'signedDate',
        fieldLabel: '签订日期',
        editable: true,
        emptyText: "--请选择--",
        format: "Y-m-d"
    }, {
        xtype: 'textfield',
        name: 'signedPerson',
        fieldLabel: '签订人'
    }, {
        xtype: 'textfield',
        name: 'remark',
        fieldLabel: '备注'
    }]
// 上传文件的组件
}, {
    flex: 1,
    xtype: 'baseFileGrid',
    name: 'cont'
}];
