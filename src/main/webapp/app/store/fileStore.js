Ext.define('BudgetMS.store.fileStore', {
    name: 'file',
    extend: 'Ext.data.Store',
    model: 'BudgetMS.model.file',
    proxy: {
        type: 'ajax',
        url: 'attach/getAttachByIdType.do',
        reader: {
            type: 'json'
        }
    }
});
