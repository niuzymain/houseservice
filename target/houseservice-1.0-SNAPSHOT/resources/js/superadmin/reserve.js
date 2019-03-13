$(function () {
    var status = 0;
    var head;
    var body;
    $.getJSON("/admin/getreservelist?status=" + status, function (data) {
        if (data.success) {
            head = "<tr>" +
                "<th>预约用户</th>" +
                "<th>预约服务人员</th>" +
                "<th>联系方式</th>" +
                "<th>预约地点</th>" +
                "<th>预约备注</th>" +
                "<th>操作时间</th>" +
                "<th>状态</th>" +
                "<th>操作</th>" +
                "</tr>"
            $("#reservetable table thead").append(head)
            for (var i = 0; i < data.list.length; i++) {
                body = "<tr>" +
                    "<td>" + data.list[i].user.accountname + "</td>" +
                    "<td>" + data.list[i].servicer.servicername + "</td>" +
                    "<td>" + data.list[i].resrevephone + "</td>" +
                    "<td>" + data.list[i].reserveadds + "</td>" +
                    "<td>" + data.list[i].reservedes + "</td>" +
                    "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                    "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                    "<td><a href=\"javascript:void(0);\" class=\"sui-btn btn-xlarge btn-primary handle\">处理</a></td>" +
                    "</tr>"
                $("#reservetable table tbody").append(body)
            }
        }
        else {
            alert(data.errormsg)
        }
    })
/////////////////////////////////////////////////////////绑定选择按钮/////////////////////////////////////////
    $("#status button").click(function () {
        $("#reservetable thead").empty()
        $("#reservetable tbody").empty()
        if ($(this).text() == "已取消") {
            status = -1
        }
        else if ($(this).text() == "待受理") {
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
            alert("操作错误")
            return false;
        }

        $.getJSON("/admin/getreservelist?status=" + status, function (data) {
            if (data.success) {
                switch (status) {
                    case -1:
                        head = "<tr>" +
                            "<th>预约用户</th>" +
                            "<th>预约服务人员</th>" +
                            "<th>联系方式</th>" +
                            "<th>预约地点</th>" +
                            "<th>预约备注</th>" +
                            "<th>操作时间</th>" +
                            "<th>状态</th>" +
                            "<th>取消原因</th>" +
                            "</tr>"
                        $("#reservetable table thead").append(head)
                        for (var i = 0; i < data.list.length; i++) {
                            body = "<tr>" +
                                "<td>" + data.list[i].user.accountname + "</td>" +
                                "<td>" + data.list[i].servicer.servicername + "</td>" +
                                "<td>" + data.list[i].resrevephone + "</td>" +
                                "<td>" + data.list[i].reserveadds + "</td>" +
                                "<td>" + data.list[i].reservedes + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                                "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                                "<td>" + data.list[i].reservemsg + "</td>" +
                                "</tr>"
                            $("#reservetable table tbody").append(body)
                        }
                        break;
                    case 0:
                        head = "<tr>" +
                            "<th>预约用户</th>" +
                            "<th>预约服务人员</th>" +
                            "<th>联系方式</th>" +
                            "<th>预约地点</th>" +
                            "<th>预约备注</th>" +
                            "<th>操作时间</th>" +
                            "<th>状态</th>" +
                            "<th>操作</th>" +
                            "</tr>"
                        $("#reservetable table thead").append(head)
                        for (var i = 0; i < data.list.length; i++) {
                            body = "<tr>" +
                                "<td>" + data.list[i].user.accountname + "</td>" +
                                "<td>" + data.list[i].servicer.servicername + "</td>" +
                                "<td>" + data.list[i].resrevephone + "</td>" +
                                "<td>" + data.list[i].reserveadds + "</td>" +
                                "<td>" + data.list[i].reservedes + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                                "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                                "<td><a href=\"javascript:void(0);\" class=\"sui-btn btn-xlarge btn-primary handle\">处理</a></td>" +
                                "</tr>"
                            $("#reservetable table tbody").append(body)
                        }
                        break;

                    case 1:
                        break;

                    case 2:
                        break
                            ;
                    case 3:
                        break;

                    default:
                        alert("操作错误")
                        window.location.reload()
                }
            }
            else {
                alert(data.errormsg)
            }
        })

    })
//////////////////////////////////////待处理预约操作////////////////////////////////////////////
    $("table tbody").on("click",".handle",function(){
        alert("handle")
    })
})