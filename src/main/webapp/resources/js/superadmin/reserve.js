$(function () {
    var status = 0;
    var head;
    var body;
    $.getJSON("/admin/getreservelist?status=" + status, function (data) {
        if (data.success) {
            head = "<tr>" +
                "<th>编号</th>" +
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
                    "<td>" + data.list[i].reserveid + "</td>" +
                    "<td>" + data.list[i].user.accountname + "</td>" +
                    "<td>" + data.list[i].servicer.servicername + "</td>" +
                    "<td>" + data.list[i].reservephone + "</td>" +
                    "<td>" + data.list[i].reserveaddr + "</td>" +
                    "<td>" + data.list[i].reservedes + "</td>" +
                    "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                    "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                    "<td><a href=\"javascript:void(0);\" class=\"sui-btn btn-xlarge btn-primary handle\" onclick=handle(this)>处理</a></td>" +
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
        else if ($(this).text() == "待确认") {
            status = 1
        }
        else if ($(this).text() == "待完成") {
            status = 2
        }
        else if ($(this).text() == "已完成") {
            status = 3
        }
        else {
            alert("操作错误")
            return false;
        }
//////////////////////////////////////////根据状态获取list并展示,不同状态表头有所区别//////////////////////////////////////////////
        $.getJSON("/admin/getreservelist?status=" + status, function (data) {
            if (data.success) {
                switch (status) {
                    case -1:
                        head = "<tr>" +
                            "<th>编号</th>" +
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
                                "<td>" + data.list[i].reserveid + "</td>" +
                                "<td>" + data.list[i].user.accountname + "</td>" +
                                "<td>" + data.list[i].servicer.servicername + "</td>" +
                                "<td>" + data.list[i].reservephone + "</td>" +
                                "<td>" + data.list[i].reserveaddr + "</td>" +
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
                            "<th>编号</th>" +
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
                                "<td>" + data.list[i].reserveid + "</td>" +
                                "<td>" + data.list[i].user.accountname + "</td>" +
                                "<td>" + data.list[i].servicer.servicername + "</td>" +
                                "<td>" + data.list[i].reservephone + "</td>" +
                                "<td>" + data.list[i].reserveaddr + "</td>" +
                                "<td>" + data.list[i].reservedes + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                                "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                                "<td><a href=\"javascript:void(0);\" class=\"sui-btn btn-xlarge btn-primary handle\" onclick=handle(this)>处理</a></td>" +
                                "</tr>"
                            $("#reservetable table tbody").append(body)
                        }
                        break;

                    case 1:
                        head = "<tr>" +
                            "<th>编号</th>" +
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
                                "<td>" + data.list[i].reserveid + "</td>" +
                                "<td>" + data.list[i].user.accountname + "</td>" +
                                "<td>" + data.list[i].servicer.servicername + "</td>" +
                                "<td>" + data.list[i].reservephone + "</td>" +
                                "<td>" + data.list[i].reserveaddr + "</td>" +
                                "<td>" + data.list[i].reservedes + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                                "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                                "<td>" +
                                "<a href=\"javascript:void(0);\" class=\"sui-btn btn-xlarge btn-primary handle\" onclick=confirm(this)>确认预约</a><br><br>" +
                                "<a href=\"javascript:void(0);\" class=\"sui-btn btn-xlarge btn-primary handle\" onclick='cancel(this)'>客户取消</a>" +
                                "</td>" +
                                "</tr>"
                            $("#reservetable table tbody").append(body)
                        }
                        break;

                    case 2:
                        head = "<tr>" +
                            "<th>编号</th>" +
                            "<th>预约用户</th>" +
                            "<th>预约服务人员</th>" +
                            "<th>联系方式</th>" +
                            "<th>预约地点</th>" +
                            "<th>预约备注</th>" +
                            "<th>操作时间</th>" +
                            "<th>预约时间</th>" +
                            "<th>结束时间</th>" +
                            "<th>状态</th>" +
                            "<th>操作</th>" +
                            "</tr>"
                        $("#reservetable table thead").append(head)
                        for (var i = 0; i < data.list.length; i++) {
                            body = "<tr>" +
                                "<td>" + data.list[i].reserveid + "</td>" +
                                "<td>" + data.list[i].user.accountname + "</td>" +
                                "<td>" + data.list[i].servicer.servicername + "</td>" +
                                "<td>" + data.list[i].reservephone + "</td>" +
                                "<td>" + data.list[i].reserveaddr + "</td>" +
                                "<td>" + data.list[i].reservedes + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].reservetime) + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].endtime) + "</td>" +
                                "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                                "<td>" +
                                "<a href=\"javascript:void(0);\" class=\"sui-btn btn-xlarge btn-primary handle\" onclick=over(this)>结束预约</a><br><br>" +
                                "<a href=/file" + data.list[i].reservecontract + " class=\"sui-btn btn-xlarge btn-primary handle\" >查看合同</a>" +
                                "</td>" +
                                "</tr>"
                            $("#reservetable table tbody").append(body)
                        }
                        break;

                    case 3:
                        head = "<tr>" +
                            "<th>编号</th>" +
                            "<th>预约用户</th>" +
                            "<th>预约服务人员</th>" +
                            "<th>联系方式</th>" +
                            "<th>预约地点</th>" +
                            "<th>预约备注</th>" +
                            "<th>操作时间</th>" +
                            "<th>预约时间</th>" +
                            "<th>结束时间</th>" +
                            "<th>状态</th>" +
                            "<th>操作</th>" +
                            "</tr>"
                        $("#reservetable table thead").append(head)
                        for (var i = 0; i < data.list.length; i++) {
                            body = "<tr>" +
                                "<td>" + data.list[i].reserveid + "</td>" +
                                "<td>" + data.list[i].user.accountname + "</td>" +
                                "<td>" + data.list[i].servicer.servicername + "</td>" +
                                "<td>" + data.list[i].reservephone + "</td>" +
                                "<td>" + data.list[i].reserveaddr + "</td>" +
                                "<td>" + data.list[i].reservedes + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].reservetime) + "</td>" +
                                "<td>" + timeStamp2String(data.list[i].endtime) + "</td>" +
                                "<td>" + reserveinfo(data.list[i].enablestatus) + "</td>" +
                                "<td><a href=/file" + data.list[i].reservecontract + " class=\"sui-btn btn-xlarge btn-primary handle\" >查看合同</a></td>" +
                                "</tr>"
                            $("#reservetable table tbody").append(body)
                        }
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
})

//////////////////////////////////////待处理预约操作////////////////////////////////////////////
function handle(e) {
    $.ajax({
        url: "/admin/handlereserve",
        data: {
            reserveid: $(e).parent().parent().children(":first").text()
        },
        type: "post",
        success: function (data) {
            if (data.success) {
                alert("success")
                window.location.reload()
            }
            else {
                alert(data.errormsg)
            }
        }
    })
}

function confirm(e) {
    window.location.href = "/admin/confirmpage?reserveid=" + $(e).parent().parent().children(":first").text()
}

function cancel(e) {
    var reason = prompt("取消预约")
    if (reason) {
        var formdata = new FormData()
        var reserve = {
            reserveid: $(e).parent().parent().children(":first").text(),
            reservemsg: reason,
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
                    alert(data.errormsg)
                }
            }
        })
    }
    else if (reason == "") {
        alert("请输入客户取消原因")
    }
}

function over(e){
    var reserveid = $(e).parent().parent().children(":first").text()
    $.ajax({
        url:"/admin/overreserve",
        data:{
            reserveid:reserveid
        },
        type:"post",
        success:function(data){
         if(data.success){
             alert("success")
             window.location.reload()
         }
         else{
             alert(data.erroemsg)
         }
        }


    })
}