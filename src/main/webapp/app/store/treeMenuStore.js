Ext.define('BudgetMS.store.treeMenuStore', {
	extend : 'Ext.data.TreeStore',
	root : {
		expanded : true,
		children : [ {
			id : 'budgetInfoList',
			name : 'budgetInfo',
			text : "预算信息",
			expanded : true,
			children : [ {
				id : 'budgetTypeList',
				name : 'budgetType',
				text : "预算类型",
				leaf : true
			}]
		}, {
			id : 'proList',
			name : 'pro',
			text : "项目",
			expanded : true,
			children : [ {
				id : 'proInfoList',
				name : 'proInfo',
				text : "项目信息",
				leaf : true
			}, {
				id : 'proInfoAdjList',
				name : 'proInfoAdj',
				text : "项目信息调整",
				leaf : true
			} ]
		}, {
			id : 'instList',
			name : 'inst',
			text : "请示",
			expanded : true,
			children : [ {
				id : 'instDivideList',
				name : 'instDivide',
				text : "请示拆分",
				leaf : true
			}, {
				id : 'instAdjList',
				name : 'instAdj',
				text : "请示调整",
				leaf : true
			} ]
		}, {
			id : 'contList',
			name : 'cont',
			text : "合同",
			expanded : true,
			children : [ {
				id : 'contPaymentList',
				name : 'contPayment',
				text : "合同分期付款",
				leaf : true
			}, {
				id : 'contAdjList',
				name : 'contAdj',
				text : "合同调整",
				leaf : true
			} ]
		}, {
			id : 'invoList',
			name : 'invo',
			text : "发票",
			leaf : true
		} , {
			id : 'tenderList',
			name : 'tender',
			text : "招标",
			leaf : true
		} ]
	}

})