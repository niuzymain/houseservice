$(function(){
    //显示区域列表
    $("#areamanager").click(function(){
        var head = "<tr><td>城市名称</td><td>操作</td></tr>"
        $("#itemlist thead").append(head);
        $.getJSON("/admin/getitems?type=城市",function(data){
            if(data.success){
                for(var i=0;i<data.result.length;i++){
                    var body = "<tr><td>"+data.result[i].workarea.workareaname+"</td><td>操作</td></tr>"
                    $("#itemlist tbody").append(body);
                }
            }
            else{
                alert(data.errormsg);
            }

        })

    })
})