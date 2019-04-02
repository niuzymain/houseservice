$(function(){
    $("#logout").click(function(){
        $.getJSON("/servicer/logout",function(data){
            if(data.success){
                alert("退出成功")
                window.location.href="/login/servicer"
            }
        })
    })
    $.getJSON("/servicer/getservicerinfo", function (data) {
        if(data.success){
            $("h1 a").append(data.result.servicername)
        }
        else{
            alert(data.errormsg)
        }
    })
    $.getJSON("/servicer/getmessagelist",function(data){
        if(data.success){
            // for(var i=0;i<data.result.length;i++){
            //     var divli = "<li>" +
            //                     "<div>" +
            //                         "<p>创建时间:"+timeStamp2String(data.result[i].createtime)+"</p>"+
            //                         "<p>详情："+data.result[i].adminmsgdes+"</p>"+
            //                     "</div>"
            //                 "</li>"
            //     $("#messagelist").append(divli);
            // }
            for (var i = 0; i < data.result.length; i++) {
                var divli = "<li class=\"am-comment\">\n" +
                    "                <div class=\"am-comment-main\">\n" +
                    "                    <header class=\"am-comment-hd\">\n" +
                    "                        <div class=\"am-comment-meta\">\n" +
                    "                            <span class=\"c-time\">创建时间:" + timeStamp2String(data.result[i].createtime) + "</span>"+
                    "                        </div>\n" +
                    "                    </header>\n" +
                    "                    <div class=\"am-comment-bd\">\n" +
                    "详情："+data.result[i].adminmsgdes +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "        </li>"
                $("#messagelist").append(divli)
            }
        }
        else{
            alert(data.errormsg)
        }
    })
})