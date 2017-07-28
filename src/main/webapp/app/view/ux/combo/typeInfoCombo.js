Ext.define('BudgetMS.view.ux.combo.typeInfoCombo', {
    extend: 'Ext.form.field.ComboBox',
    alias: 'widget.typeInfoCombo',
    // allowBlank: false,
    // fieldLabel : 'xx类型',
    valueField: 'typeId',
    displayField: 'typeName',
    emptyText: "--请选择--",
    mode: 'local',
    initComponent: function () {
        console.log("initComponent:" + this.getFieldLabel())
        var category = this.category;
        var store = Ext.create('BudgetMS.store.typeInfoStore');
        store.filter('typeCategory', category);
        store.load();
        this.store = store;
        this.callParent(arguments);
    }
})
