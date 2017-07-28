/**
 * Created by KJB-001064 on 2017/5/17.
 */
Ext.define('BudgetMS.view.ux.button.doPostBtn', {
    extend: 'BudgetMS.view.ux.button.baseBtn',
    listeners: {
        'click': function (btn, e, eOpts) {
            this.addorupdate(btn,e,eOpts);
        }
    }
});