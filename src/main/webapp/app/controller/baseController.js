/**
 * 等待初始化 name: ,stores : [], views : [], models : [], init : function() .....
 */
Ext.define('BudgetMS.controller.baseController', {
	extend : 'Ext.app.Controller',
	stores : [ 'fileStore', 'deptStore', 'typeInfoStore','deptMemoryStore'],
	views : [ 'ux.button.showAddBtn', 'ux.button.doAddBtn',
			'ux.button.showUpdBtn', 'ux.button.doUpdBtn',
			'ux.button.doFindBtn', 'ux.button.doDelBtn','ux.button.doTransferBtn',
			'ux.button.fileUploadBtn', 'ux.baseFileGrid', 'dashbord',
			'ux.combo.deptCombo', 'ux.combo.typeInfoCombo' ,'ux.combo.budgetTypeCombo' ],
	init : function() {
		console.log('baseController init...')
		
	},

});
