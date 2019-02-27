$(function () {
    $.getJSON("/servicer/getreservelist?enablestatus="+0, function (data) {
        if (data.success) {
            var i;
            for (i = 0; i < data.result.length; i++) {
                var reserveDiv="<div class=reserve>" +
                    "预约时间:"+timeStamp2String(data.result[i].reservetime)+"<br>"+
                    "预约人:"+data.result[i].user.username+
                    "<a href=/servicer/reservedetail?reserveid="+data.result[i].reserveid+">查看详情</a>"+
                    "</div>"
                $("#reservelist").append(reserveDiv)
            }
        }
        else {
            alert(data.errormsg)
        }
    })
    ////////////////////////////////////////////////////绑定选择框
    $("select").change(function(){
        $("#reservelist").empty();
        var enablestatus = $("select").val();
        $.getJSON("/servicer/getreservelist?enablestatus="+enablestatus, function (data) {
            if (data.success) {
                var i;
                for (i = 0; i < data.result.length; i++) {
                    var reserveDiv="<div class=reserve>" +
                        "预约时间:"+timeStamp2String(data.result[i].reservetime)+"<br>"+
                        "预约人:"+data.result[i].user.username+
                        "<a href=/servicer/reservedetail?reserveid="+data.result[i].reserveid+">查看详情</a>"+
                        "</div>"
                    $("#reservelist").append(reserveDiv)
                }
            }
            else {
                alert(data.errormsg)
            }
        })
    })

})