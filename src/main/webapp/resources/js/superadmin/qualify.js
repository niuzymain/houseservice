$(function () {
    $.getJSON("/admin/getqualifylist",function(data){
        if(data.success){
            for(var i=0;i<data.result.length;i++){
                var body = "<tr>" +
                                "<td>"+data.result[i].servicername+"</td>" +
                                "<td>"+timeStamp2String(data.result[i].lastedittime)+"</td>" +
                                "<td><a href=/admin/qualifydetail?servicerid="+data.result[i].servicerid+">查看详情</a></td>" +
                            "</tr>"
                $("#qualifylist tbody").append(body);
            }

        }
        else{
            alert(data.errormsg)
        }
    })
})