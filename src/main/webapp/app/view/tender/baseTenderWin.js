Ext.define('BudgetMS.view.tender.baseTenderWin', {
    extend: 'Ext.window.Window',
    name: 'tender',
    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    height: 500,
    width: 800,
    autoShow: true,
    initComponent: function () {
        // debugger;
        this.items = tenderFormItems;
        this.callParent(arguments);
        //     var fields=this.down('form').getForm().getFields().items;
        //     for(var index in fields){
        //         if(fields[index].xtype=='typeInfoCombo'){
        //             console.log(this.name+"->typeinfoCombo->"+fields[index].getFieldLabel())
        //             fields[index].doQuery(fields[index].category,true)
        //         }
        //     }
    }
});
var tenderFormItems = [{
    flex: 1,
    xtype: 'form',
    layout: 'auto',
    items: [{
        xtype: 'textfield',
        name: 'tenderId',
        fieldLabel: '招标编号',
        allowBlank: false
    }, {
        xtype: 'textfield',
        name: 'instDivideId',
        fieldLabel: '请示拆分编号',
        allowBlank: false
    }, {
        xtype: 'textfield',
        name: 'tenderAmt',
        fieldLabel: '中标金额',
        vtype: 'money',

    }, {
        xtype: 'textfield',
        name: 'company',
        fieldLabel: '中标公司',

    }, {
        xtype: 'textfield',
        name: 'remark',
        fieldLabel: '备注',

    }, {//20170516
        xtype: 'textfield',
        name: 'tenderName',
        fieldLabel: '项目名称',
        allowBlank: false
    }, {
        xtype: 'typeInfoCombo',
        name: 'type',
        category: 'tenderType',
        fieldLabel: '招标类型'
    }, {
        xtype: 'datefield',
        name: 'startDate',
        fieldLabel: '招标开始日期',
        editable: true,
        emptyText: "--请选择--",
        format: "Y-m-d",
        allowBlank: false
    }, {
        xtype: 'datefield',
        name: 'endDate',
        fieldLabel: '招标结束日期',
        editable: true,
        emptyText: "--请选择--",
        format: "Y-m-d",
        allowBlank: false
    }, {
        xtype: 'datefield',
        name: 'openDate',
        fieldLabel: '开标日期',
        editable: true,
        emptyText: "--请选择--",
        format: "Y-m-d"
    }, {
        xtype: 'datefield',
        name: 'negoDate',
        fieldLabel: '谈判日期',
        editable: true,
        emptyText: "--请选择--",
        format: "Y-m-d"
    }, {
        xtype: 'datefield',
        name: 'approvalDate',
        fieldLabel: '评审上会日期',
        editable: true,
        emptyText: "--请选择--",
        format: "Y-m-d"
    }, {
        xtype: 'datefield',
        name: 'finalDate',
        fieldLabel: '定标（批准）日期',
        editable: true,
        emptyText: "--请选择--",
        format: "Y-m-d"
    }, {
        xtype: 'typeInfoCombo',
        name: 'status',
        category: 'tenderStatus',
        fieldLabel: '当前阶段'
    }]
}, {   // 上传文件的组件
    flex: 1,
    xtype: 'baseFileGrid',
    name: 'tender'
}];