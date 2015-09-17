function initCombobox(id, code, params, init) {
    var url = '/wanma/param/json/combo/' + code;
    $.get(url, params, function(data){
        var _data = [];
        $.each(data, function(i, item){
            _data.push({'id': item[0], 'text': item[1]});
        });

        $('#' + id).combobox( {
                    panelHeight: '120px',
                    valueField: 'id',
                    textField: 'text',
                    data: _data
                });

        if(data[init]) {
            $('#' + id).combobox('setValue', data[init][0]);
        }
    });
}

var cmenu;
function createColumnMenu(){
    cmenu = $('<div/>').appendTo('body');
    cmenu.menu({
        onClick: function(item){
            if (item.iconCls == 'icon-ok'){
                $('#t1').datagrid('hideColumn', item.name);
                cmenu.menu('setIcon', {
                    target: item.target,
                    iconCls: 'icon-empty'
                });
            } else {
                $('#t1').datagrid('showColumn', item.name);
                cmenu.menu('setIcon', {
                    target: item.target,
                    iconCls: 'icon-ok'
                });
            }
        }
    });
    var fields = $('#t1').datagrid('getColumnFields');
    for(var i=0; i<fields.length; i++){
        var field = fields[i];
        var col = $('#t1').datagrid('getColumnOption', field);
        cmenu.menu('appendItem', {
            text: col.title,
            name: field,
            iconCls: 'icon-ok'
        });
    }
}

function _export() {

}