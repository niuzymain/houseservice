$(function () {
    //初始显示用户信息
    $.getJSON("/admin/userlist", function (data) {
        if (data.success) {
            var head = "<tr><th>用户名</th><th>性别</th><th>电话</th><th>创建时间</th><th>状态</th></tr>"
            $("#userlist thead").append(head);
            for (var i = 0; i < data.result.length; i++) {
                var body = "<tr>" +
                    "<td>" + data.result[i].accountname + "</td>" +
                    "<td>" + data.result[i].usersex + "</td>" +
                    "<td>" + data.result[i].userphone + "</td>" +
                    "<td>" + timeStamp2String(data.result[i].createtime) + "</td>" +
                    "<td><a href=# onclick=changestatus(this) id=" + data.result[i].userid + ">" + statusinfo(data.result[i].enablestatus) + "</a></td>" +
                    "</tr>"
                $("#userlist tbody").append(body);
            }
        }
        else {
            alert("error:" + data.errormsg)
        }
    })
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    $("#usertype").change(function () {
        $("#userlist thead").empty();
        $("#userlist tbody").empty();
        if ($("#usertype").val() == "user") {
            $.getJSON("/admin/userlist", function (data) {
                if (data.success) {
                    var head = "<tr><th>用户名</th><th>性别</th><th>电话</th><th>创建时间</th><th>状态</th></tr>"
                    $("#userlist thead").append(head);
                    for (var i = 0; i < data.result.length; i++) {
                        var body = "<tr>" +
                                        "<td>" + data.result[i].accountname + "</td>" +
                                        "<td>" + data.result[i].usersex + "</td>" +
                                        "<td>" + data.result[i].userphone + "</td>" +
                                        "<td>" + timeStamp2String(data.result[i].createtime) + "</td>" +
                                        "<td><a href=# onclick=changestatus(this) id=" + data.result[i].userid + ">" + statusinfo(data.result[i].enablestatus) + "</a></td>" +
                                    "</tr>"
                        $("#userlist tbody").append(body);
                    }
                }
                else {
                    alert("error:" + data.errormsg)
                }
            })
        }
        else {
            $("#userlist thead").empty();
            $("#userlist tbody").empty();
            $.getJSON("/admin/servicerlist", function (data) {
                if (data.success) {
                    var head = "<tr><th>姓名</th><th>性别</th><th>电话</th><th>创建时间</th><th>状态</th></tr>"
                    $("#userlist thead").append(head);
                    for (var i = 0; i < data.result.length; i++) {
                        var body = "<tr>" +
                                        "<td>" + data.result[i].servicername + "</td>" +
                                        "<td>" + data.result[i].servicersex + "</td>" +
                                        "<td>" + data.result[i].servicerphone + "</td>" +
                                        "<td>" + timeStamp2String(data.result[i].createtime) + "</td>" +
                                        "<td><a href=# onclick=changestatus(this) id=" + data.result[i].servicerid + ">" + statusinfo(data.result[i].enablestatus) + "</a></td>" +
                                        "<td><a href=#>查看详情</a></td>" +
                            "</tr>"
                        $("#userlist tbody").append(body);
                    }
                }
                else {
                    alert("error:" + data.errormsg)
                }
            })
        }
    })
})

function changestatus(target) {
    var formdata = new FormData()
    if (target.text == "可用") {
        if($("#usertype").val() == "user"){
            var user = {
                userid: target.id,
                enablestatus: 0
            }
            formdata.append("type","user");
            formdata.append("operatestr", JSON.stringify(user))
        }
        else{
            var servicer = {
                servicerid: target.id,
                enablestatus: 0
            }
            formdata.append("type","servicer");
            formdata.append("operatestr", JSON.stringify(servicer))
        }
    }
    else if(target.text == "服务中"){
        alert("不可操作")
        return false;
    }
    else {
        if($("#usertype").val() == "user"){
            var user = {
                userid: target.id,
                enablestatus: 1
            }
            formdata.append("type","user");
            formdata.append("operatestr", JSON.stringify(user))
        }
        else{
            var servicer = {
                servicerid: target.id,
                enablestatus: 1
            }
            formdata.append("type","servicer");
            formdata.append("operatestr", JSON.stringify(servicer))
        }
    }
    $.ajax({
        url: "/admin/editstatus",
        data: formdata,
        type: "post",
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                alert("success");
                location.reload();
            }
            else {
                alert("error：" + data.errormsg);
            }
        }
    })
}