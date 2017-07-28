var PAGE_SIZE = 25;
// 只能输入金额 数字 number field ??
Ext.apply(Ext.form.field.VTypes, {
    money: function (val) {
        return /^([1-9]\d{0,7}|0)(\.\d{1,2})?$/.test(val);
    },
    moneyText: '请输入正确的金额'
});

function genDH() {
    var date = new Date();
    var yyyy = date.getFullYear().toString();
    var MM = (date.getMonth() + 1).toString();
    var DD = date.getDate().toString();
    var hh = date.getHours().toString();
    var mm = date.getMinutes().toString();
    var ss = date.getSeconds().toString();
    return yyyy + cl(MM) + cl(DD) + cl(hh) + cl(mm) + cl(ss);
}
function cl(s) {
    if (s.length < 2)
        s = "0" + s;
    return s;
}
function genInstId() {
    return 'QSBH' + genDH();
}
function genContId() {
    return 'HTBH' + genDH();
}
function genTenderId() {
    return 'ZBBH'+genDH();
}
// 定义缓存 。。其实没必要。。
//几个全局的store用来筛选
var deptMemoryStore;
var typeInfoMemoryStore;
var deptCombo;
var deptStore;
var typeInfoStore;
var deptData;
var typeInfoData;
var budgetTypeStore;
function initStores() {
	//debugger;
    budgetTypeStore = Ext.create('BudgetMS.store.budgetTypeStore');
    deptStore = Ext.create('BudgetMS.store.deptStore');
    typeInfoStore = Ext.create('BudgetMS.store.typeInfoStore');
    typeInfoStore.load();
}
Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'BudgetMS',
    appFolder: 'app',
    controllers: ['instCtrl', 'treeCtrl', 'contCtrl', 'invoCtrl', 'proCtrl', 'tenderCtrl',
        'budgetCtrl'],
    launch: function () {

        var page = Ext.create('Ext.container.Viewport', {
            layout: 'border',
            items: [{
                region: 'north',
                html: '<h1 class="x-panel-header">预算管理</h1>',
                border: false,
                margins: '0 0 5 0'
            }, {
                region: 'west',
                collapsible: true,
                title: '菜单',
                width: 150,
                layout: 'fit',
                items: {
                    text: '菜单',
                    xtype: 'treeMenu'

                }
                // could use a TreePanel or AccordionLayout for navigational items
            }, /*
             * { region : 'east', title : 'South Panel', collapsible : true,
             * collapsed : true, split : true, width : 450 },
             */
                {
                    region: 'east',
                    title: '新增',
                    collapsible: true,
                    collapsed: true,
                    split: true,
                    width: 450
                }, {
                    id: 'mainTabpanel',
                    region: 'center',
                    xtype: 'tabpanel', // TabPanel itself has no title
                    // activeTab : 0, // First tab active by default
                    items: [{
                        title: '主页',
                        xtype: 'dashbord'
                    }]
                }],
            listeners: {
                'show': function () {
                    debugger;
                    console.log('show');
                }
            }
        });
        initStores();
    }
})