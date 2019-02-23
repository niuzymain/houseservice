$(function () {
    $.getJSON("/servicer/getreservelist", function (data) {
        if (data.success) {
            var i;
            for (i = 0; i < data.result.length; i++) {
                var reserveDiv="<div class=reserve>" +
                                    "预约时间:"+timeStamp2String(data.result[i].createtime)+"<br>"+
                                    "预约人:"+data.result[i].user.username+
                                    "<a href=/servicer/reservedetail?reserveid="+data.result[i].reserveid+">查看详情</a>"+
                                "</div>"
                $("#reserves").append(reserveDiv)
            }
        }
        else {
            alert(data.errormsg)
        }
    })
})