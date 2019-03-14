$(function () {
    $("#logout button").click(function(){
        $.getJSON("/user/userlogout",function(data){
            if(data.success){
                alert("退出成功")
                window.location.href="/user/main"
            }
        })
    })
    $.getJSON("/user/getusermessagelist", function (data) {
        if (data.success) {
            for (var i = 0; i < data.list.length; i++) {
                var body = "<tr>" +
                    "<td>" + data.list[i].adminmsgdes + "</td>" +
                    "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                    "</tr>"
                $("#messagelist table tbody").append(body);
            }
        }
    })
})