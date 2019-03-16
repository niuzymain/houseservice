$(function () {
    var status = 0;
    var head = ""
    var reserverow = ""
    $.getJSON("/user/getuserinfo",function(data){
        if(data.success){
            $("h1 a").append(data.result.accountname)
        }
        else{
            alert(data.errormsg)
        }
    })
    $.getJSON("/user/getuserreserve?status=0", function (data) {
        if (data.success) {
            head = "<tr>" +
                "<th>服务人员</th>" +
                "<th>操作时间</th>" +
                "<th>状态</th>" +
                "<th>预约备注</th>" +
                "<th>操作</th>" +
                "</tr>"
            $("table thead").append(head);
            for (var i = 0; i < data.list.length; i++) {
                reserverow = "<tr>" +
                    "<td>" + data.list[i].servicer.servicername + "</td>" +
                    "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                    "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                    "<td>" + data.list[i].reservedes + "</td>" +
                    "<td><a href=# id=" + data.list[i].reserveid + " class='cancel'>取消</a></td>" +
                    "</tr>"
                $("table tbody").append(reserverow);
            }
        }
    })


    $(".am-btn-group button").click(function () {
        $("table thead").empty()
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
                if (status == -1) {
                    head = "<tr>" +
                        "<th>服务人员</th>" +
                        "<th>操作时间</th>" +
                        "<th>状态</th>" +
                        "<th>预约备注</th>" +
                        "<th>取消原因</th>" +
                        "</tr>"
                    $("table thead").append(head);
                    for (var i = 0; i < data.list.length; i++) {
                        reserverow = "<tr>" +
                            "<td>" + data.list[i].servicer.servicername + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                            "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                            "<td>" + data.list[i].reservedes + "</td>" +
                            "<td>" + data.list[i].reservemsg + "</td>" +
                            "</tr>"
                        $("table tbody").append(reserverow);
                    }
                }

                else if (status == 0) {
                    head = "<tr>" +
                        "<th>服务人员</th>" +
                        "<th>操作时间</th>" +
                        "<th>状态</th>" +
                        "<th>预约备注</th>" +
                        "<th>操作</th>" +
                        "</tr>"
                    $("table thead").append(head);
                    for (var i = 0; i < data.list.length; i++) {
                        reserverow = "<tr>" +
                            "<td>" + data.list[i].servicer.servicername + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                            "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                            "<td>" + data.list[i].reservedes + "</td>" +
                            "<td><a href=# id=" + data.list[i].reserveid + " class='cancel'>取消</a></td>" +
                            "</tr>"
                        $("table tbody").append(reserverow);
                    }
                }

                else if (status == 1) {
                    head = "<tr>" +
                        "<th>服务人员</th>" +
                        "<th>操作时间</th>" +
                        "<th>状态</th>" +
                        "<th>预约备注</th>" +
                        "</tr>"
                    $("table thead").append(head);
                    for (var i = 0; i < data.list.length; i++) {
                        reserverow = "<tr>" +
                            "<td>" + data.list[i].servicer.servicername + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                            "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                            "<td>" + data.list[i].reservedes + "</td>" +
                            "</tr>"
                        $("table tbody").append(reserverow);
                    }
                }

                else if (status == 2) {
                    head = "<tr>" +
                        "<th>服务人员</th>" +
                        "<th>操作时间</th>" +
                        "<th>状态</th>" +
                        "<th>预约备注</th>" +
                        "<th>预约时间</th>" +
                        "<th>结束时间</th>" +
                        "<th>操作</th>" +
                        "</tr>"
                    $("table thead").append(head);
                    for (var i = 0; i < data.list.length; i++) {
                        reserverow = "<tr>" +
                            "<td>" + data.list[i].servicer.servicername + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                            "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                            "<td>" + data.list[i].reservedes + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].reservetime) + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].endtime) + "</td>" +
                            "<td><a href=/file" + data.list[i].reservecontract + ">查看合同</a></td>" +
                            "</tr>"
                        $("table tbody").append(reserverow);
                    }
                }

                else if (status == 3) {
                    head = "<tr>" +
                        "<th>服务人员</th>" +
                        "<th>操作时间</th>" +
                        "<th>状态</th>" +
                        "<th>预约备注</th>" +
                        "<th>预约时间</th>" +
                        "<th>结束时间</th>" +
                        "<th>操作</th>" +
                        "</tr>"
                    $("table thead").append(head);
                    for (var i = 0; i < data.list.length; i++) {
                        reserverow = "<tr>" +
                            "<td>" + data.list[i].servicer.servicername + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                            "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                            "<td>" + data.list[i].reservedes + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].reservetime) + "</td>" +
                            "<td>" + timeStamp2String(data.list[i].endtime) + "</td>"
                        if(data.list[i].evaluate != null){
                            reserverow+="<td><a href=/user/evaluate?evaluateid="+data.list[i].evaluate.evaluateid+">查看评价</a></td></tr>"
                        }
                        else{
                            reserverow+="<td><a href=/user/evaluate?reserveid="+data.list[i].reserveid+">评价</a></td></tr>"
                        }
                        $("table tbody").append(reserverow);
                    }
                }
                else {
                    alert("操作错误")
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
                success: function (data) {
                    if (data.success) {
                        alert("success")
                        window.location.reload()
                    }
                    else {
                        alert(dat.errormsg)
                    }
                }
            })
        }
        else if (msg == "") {
            alert("请输入取消原因")
        }

    })
})