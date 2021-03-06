$(function () {
    var head = "<tr>" +
        "<th>标题</th>" +
        "<th>描述</th>" +
        "<th>优先级</th>" +
        "<th>图片</th>" +
        "<th>状态</th>" +
        "<th>操作</th>" +
        "<th><a href=\"/admin/operateheadimg\" class=\"sui-btn btn-xlarge btn-primary\">新增</a></th>" +
        "</tr>"
    $("#headimglist thead").append(head);
    $.getJSON("/admin/headimglist", function (data) {
        if (data.success) {
            for (var i = 0; i < data.result.length; i++) {
                var body = "<tr>" +
                    "<td>" + data.result[i].headimgtitle + "</td>" +
                    "<td>" + data.result[i].headimgdetails + "</td>" +
                    "<td>" + data.result[i].priority + "</td>" +
                    "<td><a href=/file" + data.result[i].headimgurl + ">查看</a></td>" +
                    "<td><a href=# onclick=changestatus(this) id=" + data.result[i].headimgid + ">" + statusinfo(data.result[i].enablestatus) + "</a></td>" +
                    "<td><a href=/admin/operateheadimg?headimgid=" + data.result[i].headimgid + ">编辑<br/><a href=# onclick=del(this) id=" + data.result[i].headimgid + ">删除</a></td>" +
                    "</tr>"
                $("#headimglist tbody").append(body);
            }
        }
        else {
            alert("错误：" + data.errormsg);
        }
    })
})

//修改轮播图状态
function changestatus(target) {
    var formdata = new FormData()
    if (target.text == "可用") {
        var headimg = {
            headimgid: target.id,
            enablestatus: 0
        }
        formdata.append("operatestr", JSON.stringify(headimg))
    }
    else {
        var headimg = {
            headimgid: target.id,
            enablestatus: 1
        }
        formdata.append("operatestr", JSON.stringify(headimg))
    }
    $.ajax({
        url: "/admin/editheadimg",
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

//删除轮播图
function del(target) {
    $.ajax({
        url: "/admin/delheadimg",
        data: {
          headimgid:target.id
        },
        type: "post",
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
