Ext.define('Ext.form.ComboBox', {
    fieldLabel: '',//在实例化的时候设置
    store: typeComboStore,
    queryMode: 'local',
    displayField: 'typeName',
    valueField: 'tpyeId',
     
});

Ext.define('Ext.data.Store', {
    fields: ['tpyeId', 'typeName'],
    proxy:{
    	type:'ajax',
    	url:''
    }
});



var PAGE_SIZE = 25;

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
function genInvoId() {

}
