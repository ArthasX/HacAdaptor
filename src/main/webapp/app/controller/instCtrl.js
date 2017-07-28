Ext.define('BudgetMS.controller.instCtrl',
		{
			extend : 'BudgetMS.controller.baseController',
			stores : [ 'instStore', 'instAdjStore', 'instDivideStore' ],
			views : [ 'inst.list', 'inst.editInstWin', 'inst.addInstWin',
					'inst.instTbarForm', 'inst.adj.list',
					'inst.adj.editInstAdjWin', 'inst.adj.addInstAdjWin',
					'inst.adj.instAdjTbarForm', 'inst.divide.list',
					'inst.divide.editInstDivideWin',
					'inst.divide.addInstDivideWin',
					'inst.divide.instDivideTbarForm', ],
			models : [ 'inst', 'instAdj', 'instDivide' ],
			init : function() {
				this.control({

				});
			},

		});
