function initCombobox(id, code, params) {
    var url = '../param/json/combo/' + code;
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
    });
}