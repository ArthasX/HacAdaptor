Ext.define('BudgetMS.view.ux.combo.budgetTypeCombo', {
	extend : 'Ext.form.field.ComboBox',
	alias : 'widget.budgetTypeCombo',
	//allowBlank : false,
	fieldLabel : '预算类型',
	valueField : 'budgetType',
	displayField : 'budgetName',
	name:'budgetType',
	store : 'budgetTypeStore'
})