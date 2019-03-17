$(function () {
    var checkstatus = 0;
    getlist(checkstatus);
    $("#r-check").click(function(){
        checkstatus = 0;
        $("#qualifylist tbody").empty();
        getlist(checkstatus);
    })
    $("#r-contract").click(function(){
        checkstatus = 1;
        $("#qualifylist tbody").empty();
        getlist(checkstatus);
    })
})
function getlist(checkstatus){
    $.getJSON("/admin/getqualifylist?checkstatus="+checkstatus,function(data){
        if(data.success){
            for(var i=0;i<data.result.length;i++){
                var body = "<tr>" +
                    "<td>"+data.result[i].servicername+"</td>" +
                    "<td>"+timeStamp2String(data.result[i].lastedittime)+"</td>" +
                    "<td>"+checkinfo(data.result[i].checkstatus)+"</td>" +
                    "<td><a href=/admin/qualifydetail?servicerid="+data.result[i].servicerid+"&checkstatus="+data.result[i].checkstatus+">查看详情</a></td>" +
                    "</tr>"
                $("#qualifylist tbody").append(body);
            }

        }
        else{
            alert(data.errormsg)
        }
    })
}