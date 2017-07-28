var tenderColum = [{
    header: '招标编号',
    dataIndex: 'tenderId'
}, {
    header: '请示拆分编号',
    dataIndex: 'instDivideId'
}, {
    header: '中标金额',
    dataIndex: 'tenderAmt'
}, {
    header: '中标公司',
    dataIndex: 'company'
}, {
    header: '项目名称',
    dataIndex: 'tenderName',

}, {
    header: '招标类型',
    dataIndex: 'type',
    renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
        var items = typeInfoStore.data.items;
        for (var i in items) {
            if (value == items[i].data.typeId)
                return items[i].data.typeName;
            else
                continue;
        }
        return '数据有误';
    }

}, {
    header: '当前阶段',
    dataIndex: 'status',
    renderer: function (value, cellmeta, record, rowIndex, columnIndex, store) {
        var items = typeInfoStore.data.items;
        for (var i in items) {
            if (value == items[i].data.typeId)
                return items[i].data.typeName;
            else
                continue;
        }
        return '数据有误';
    }

}, {
    header: '招标开始日期',
    dataIndex: 'startDate',

}, {
    header: '招标结束日期',
    dataIndex: 'endDate',

}, {
    header: '开标日期',
    dataIndex: 'openDate',

}, {
    header: '谈判日期',
    dataIndex: 'negoDate',

}, {
    header: '评审上会日期',
    dataIndex: 'approvalDate',

}, {
    header: '定标（批准）日期',
    dataIndex: 'finalDate',

},{
    header : '备注',
    dataIndex : 'remark',

}];

Ext.define('BudgetMS.view.tender.list', {
    extend: 'BudgetMS.view.ux.baseGrid',
    alias: 'widget.tenderList',
    id: 'tenderList',
    name: 'tender',// Ext.widget(name+'Edit') name+'Add'
    store: 'tenderStore',
    border: false,
    enableKeyNav: true,// 键盘控制
    columnLines: true,// 竖线
    tbar: {
        items: [{
            xtype: 'tenderTbarForm'
        }]
    },
    dockedItems: [{
        xtype: 'pagingtoolbar',
        store: 'tenderStore',
        dock: 'bottom',
        displayInfo: true
    }],
    initComponent: function () {
        this.columns = tenderColum;
        this.callParent(arguments);
    }

});
