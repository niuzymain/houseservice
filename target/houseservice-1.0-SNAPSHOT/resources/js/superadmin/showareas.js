$(function () {
    ////////////////////////////////////////显示区域列表/////////////////////////////////////////////
    $.getJSON("/admin/getitems?type=城市", function (data) {
        if (data.success) {
            for (var i = 0; i < data.result.length; i++) {
                var body = "<tr>" +
                    "<td><a href=/admin/displaylocals?parentid=" + data.result[i].workarea.workareaid + "> " + data.result[i].workarea.workareaname + "</a></td>" +
                    "<td><input class=w-priority type='text' readonly='readonly' style='border:none' value="+ data.result[i].workarea.priority + "></td>" +
                    "<td><input class=w-level type='text' readonly='readonly' style='border:none' value="+ data.result[i].workarea.level + "></td>" +
                    "<td><a href='#' class='edit' onclick=Edit(this," + data.result[i].workarea.workareaid + ")>修改</a></td>" +
                    "</tr>"
                $("#itemlist tbody").append(body);
            }
        }
        else {
            alert(data.errorfmsg);
        }
    })
    //绑定所有操作按钮
    $("#insert").click(function () {
        $("#itemlist tbody").append("<tr><td><input type='text' placeholder='名称' id='name'></td><td><input type='text' placeholder='优先级' id='priority'></td><td><input type='text' placeholder='薪水等级' id='level'></td></tr>");
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
        workarea: {
            workareaname: $("#name").val(),
            priority: $("#priority").val(),
            level:$("#level").val()
        }
    }
    formdata.append("operatestr", JSON.stringify(condition));
    return formdata;
}

function deleteitem(operatetype, id) {
    var formdata = new FormData();
    formdata.append("operate", operatetype);
    var condition = {
        workarea: {
            workareaid: id
        }
    }
    formdata.append("operatestr", JSON.stringify(condition));
    return formdata;
}

function Edit(target,id){
    $(target).parent().parent().find("input").css("border","solid 1px")
    $(target).parent().parent().find("input").removeAttr("readonly")
    $("#submit").click(function () {
        var formdata = new FormData();
        formdata.append("operate", "编辑")
        var condition = {
            workarea: {
                workareaid:id,
                priority: $(target).parent().parent().find(".w-priority").val(),
                level:$(target).parent().parent().find(".w-level").val()
            }
        }
        formdata.append("operatestr", JSON.stringify(condition));
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
}