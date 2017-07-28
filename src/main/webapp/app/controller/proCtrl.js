Ext.define('BudgetMS.controller.proCtrl', {
	extend : 'BudgetMS.controller.baseController',
	stores : [ 'proStore', 'proInfoStore', 'proInfoAdjStore' ],
	views : [ 'pro.list', 'pro.editProWin', 'pro.addProWin', 'pro.proTbarForm',
			'pro.proInfo.list', 'pro.proInfo.editProInfoWin',
			'pro.proInfo.addProInfoWin', 'pro.proInfo.proInfoTbarForm',
			'pro.proInfoAdj.list', 'pro.proInfoAdj.editProInfoAdjWin',
			'pro.proInfoAdj.addProInfoAdjWin',
			'pro.proInfoAdj.proInfoAdjTbarForm' ],
	models : [ 'project', 'proInfo', 'proInfoAdj' ],
	init : function() {
		this.control({

		});
	},

});
