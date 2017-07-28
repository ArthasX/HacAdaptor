Ext.define('BudgetMS.view.ux.combo.deptCombo', {
	extend : 'Ext.form.field.ComboBox',
	alias : 'widget.deptCombo',
	allowBlank : false,
	fieldLabel : '申请部门',
	valueField : 'deptId',
	displayField : 'deptName',
	//name:'applyDept',
	//store : 'deptMemoryStore'
	store : 'deptStore' //取消缓存
})