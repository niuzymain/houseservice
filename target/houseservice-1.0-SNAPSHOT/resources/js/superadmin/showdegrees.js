$(function () {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////显示学历列表/////////////////////////////////////////////////////////////////////////
    $.getJSON("/admin/getitems?type=学历", function (data) {
        if (data.success) {
            for (var i = 0; i < data.result.length; i++) {
                var body = "<tr><td>" + data.result[i].degree.degreename + "</td><td>" + data.result[i].degree.priority + "</td><td>" + data.result[i].degree.level + "</td><td><a href='#' class='delete' id=" + data.result[i].degree.degreeid + ">删除</a></td></tr>"
                $("#itemlist tbody").append(body);
            }
        }
        else {
            alert(data.errormsg);
        }

    })
    //绑定所有操作按钮
    $("#insert").click(function () {
        $("#itemlist tbody").append("<tr><td><input type='text' placeholder='名称' id='name'></td><td><input type='text' placeholder='优先级' id='priority'></td><td><input type='text' placeholder='薪水等级' id='level'></td></tr>");
    })
    $("#submit").click(function () {
        var formdata = insertitem("新增");
        $.ajax({
            url: "/admin/operateitems",
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
    })
    // $("#itemlist").on("click", ".delete", function (e) {
    //     var target = e.currentTarget;
    //     var formdata = deleteitem("删除", target.id)
    //     $.ajax({
    //         url: "/admin/operateitems",
    //         data: formdata,
    //         type: "post",
    //         contentType: false,
    //         processData: false,
    //         cache: false,
    //         success: function (data) {
    //             if (data.success) {
    //                 alert("success");
    //                 location.reload();
    //             }
    //             else {
    //                 alert("error：" + data.errormsg);
    //             }
    //         }
    //     })
    // })
})

function insertitem(operatetype) {
    var formdata = new FormData();
    formdata.append("operate", operatetype)
    var condition = {
        degree: {
            degreename: $("#name").val(),
            priority: $("#priority").val(),
            level:$("#priority").val()
        }
    }
    formdata.append("operatestr", JSON.stringify(condition));
    return formdata;
}

function deleteitem(operatetype, id) {
    var formdata = new FormData();
    formdata.append("operate", operatetype);
    var condition = {
        degree: {
            degreeid: id
        }
    }
    formdata.append("operatestr", JSON.stringify(condition));
    return formdata;
}