$(function(){
  $('#frm_${(data_pf.id)!}').submit(function(){
    $.ajax({
      url: './frm_${(data_pf.id)!}',
      type: 'POST',
      dataType: 'JSON',
      data: $('#frm_${(data_pf.id)!}').serializeObjectForm(),
      success: function(data){
        if(data.success){
          alert('操作成功');
          return;
        }
        if(data.msg) alert(data.msg);
      },
      error: function(){
        alert(arguments[2]);
      }
    });
  });
});