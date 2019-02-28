$(function(){
    $.getJSON("/servicer/getmessagelist",function(data){
        if(data.success){
            for(var i=0;i<data.result.length;i++){
                var divli = "<li>" +
                                "<div>" +
                                    "<p>创建时间:"+timeStamp2String(data.result[i].createtime)+"</p>"+
                                    "<p>详情："+data.result[i].adminmsgdes+"</p>"+
                                "</div>"
                            "</li>"
                $("#messagelist").append(divli);
            }
        }
        else{
            alert(data.errormsg)
        }
    })
})