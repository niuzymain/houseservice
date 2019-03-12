$(function () {
    var status = 0;
    $.getJSON("/user/getuserreserve?status=0", function (data) {
        if (data.success) {
            for (var i = 0; i < data.list.length; i++) {
                var reserverow = "<tr>" +
                    "<td>" + data.list[i].servicer.servicername + "</td>" +
                    "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                    "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                    "<td><a href=# id=" + data.list[i].reserveid + " class='cancel'>取消</a></td>" +
                    "</tr>"
                $("table tbody").append(reserverow);
            }
        }
    })


    $(".am-btn-group button").click(function () {
        $("table tbody").empty()
        if ($(this).text() == "已取消") {
            status = -1
        }
        else if ($(this).text() == "待处理") {
            status = 0
        }
        else if ($(this).text() == "已受理") {
            status = 1
        }
        else if ($(this).text() == "已确认") {
            status = 2
        }
        else if ($(this).text() == "已完成") {
            status = 3
        }
        else {
            alert("状态异常")
        }
        $.getJSON("/user/getuserreserve?status=" + status, function (data) {
            if (data.success) {
                for (var i = 0; i < data.list.length; i++) {
                    var reserverow = "<tr>" +
                        "<td>" + data.list[i].servicer.servicername + "</td>" +
                        "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                        "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>"
                    if (data.list[i].enablestatus == -1) {
                        reserverow += "<td>" + data.list[i].reservemsg + "</td>"
                    }
                    else if (data.list[i].enablestatus == 0) {
                        reserverow += "<td><a href=# id=" + data.list[i].reserveid + " class='cancel'>取消</a></td>"
                    }
                    else if (data.list[i].enablestatus == 2) {
                        reserverow += "<td><a href=#>查看合同</a></td>"
                    }
                    else if (data.list[i].enablestatus == 3) {
                        reserverow += "<td><a href=/user/evaluate?reserveid=" + data.list[i].reserveid + "&servicerid=" + data.list[i].servicer.servicerid + ">评价</a></td>"
                    }
                    else {
                        reserverow += "<td>无</td>"
                    }
                    reserverow += "</tr>"
                    $("table tbody").append(reserverow);
                }
            }
        })
    })
    $("#logout button").click(function () {
        $.getJSON("/user/userlogout", function (data) {
            if (data.success) {
                alert("退出成功")
                window.location.href = "/user/main"
            }
        })
    })
    $("table tbody").on("click", ".cancel", function (e) {
        var msg = prompt("取消原因")
        if (msg) {
            var target = e.currentTarget;
            var formdata = new FormData
            var reserve = {
                reserveid: target.id,
                reservemsg: msg,
                enablestatus: -1
            }
            formdata.append("reservestr", JSON.stringify(reserve))
            $.ajax({
                url: "/user/cancelreserve",
                data: formdata,
                type: "post",
                contentType: false,
                processData: false,
                cache: false,
                success:function(data){
                    if(data.success){
                        alert("success")
                        window.location.reload()
                    }
                    else{
                        alert(dat.errormsg)
                    }
                }
            })
        }
        else if(msg == ""){
            alert("请输入取消原因")
        }

    })
})