$(function(){
    var status = 0;
    $.getJSON("/user/getuserreserve?status=0",function(data){
        if(data.success){
            for(var i=0;i<data.list.length;i++){
                var reserverow = "<tr>" +
                    "<td>"+data.list[i].servicer.servicername+"</td>" +
                    "<td>"+timeStamp2String(data.list[i].reservetime)+"</td>" +
                    "<td>"+reserveinfo(data.list[i].enablestatus)+"</td>"+
                    "<td>无</td>"+
                "</tr>"
                $("table tbody").append(reserverow);
            }
        }
    })

    $(".am-btn-group button").click(function(){
        $("table tbody").empty()
        if($(this).text() == "已失效"){
            status = -1
        }
        else if($(this).text() == "已处理"){
            status = 1
        }
        else{
            status = 0;
        }
        $.getJSON("/user/getuserreserve?status="+status,function(data){
            if(data.success){
                for(var i=0;i<data.list.length;i++){
                    var reserverow = "<tr>" +
                        "<td>"+data.list[i].servicer.servicername+"</td>" +
                        "<td>"+timeStamp2String(data.list[i].reservetime)+"</td>" +
                        "<td>"+reserveinfo(data.list[i].enablestatus)+"</td>"
                    if(data.list[i].enablestatus == -2){
                        reserverow+="<td>"+data.list[i].reservemsg+"</td>"
                    }
                    else if(data.list[i].enablestatus == 2){
                        reserverow+="<td><a href=/user/evaluate?reserveid="+data.list[i].reserveid+"&servicerid="+data.list[i].servicer.servicerid+">评价</a></td>"
                    }
                    else{
                        reserverow+="<td>无</td>"
                    }
                    reserverow+="</tr>"
                    $("table tbody").append(reserverow);
                }
            }
        })
    })
    $("#logout button").click(function(){
        $.getJSON("/user/userlogout",function(data){
            if(data.success){
                alert("退出成功")
                window.location.href="/user/main"
            }
        })
    })
})