$(function () {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////显示服务类别列表////////////////////////////////////////////////////////////////////////
    $.getJSON("/admin/getitems?type=服务类别", function (data) {
        if (data.success) {
            for (var i = 0; i < data.result.length; i++) {
                var body = "<tr>" +
                    "<td>" + data.result[i].servicetype.servicetypename + "</td>" +
                    "<td><input type='text' class='st-priority' readonly='readonly' style='border: none' value=" + data.result[i].servicetype.priority + "></td>" +
                    "<td><input type='text' class='st-level' readonly='readonly' style='border: none' value=" + data.result[i].servicetype.level + "></td>" +
                    "<td>" +
                    "<a href='#' class='edit' onclick=Edit(this," + data.result[i].servicetype.servicetypeid + ")  >修改</a>" +
                    "</td>" +
                    "</tr>"
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
        servicetype: {
            servicetypename: $("#name").val(),
            priority: $("#priority").val(),
            level: $("#level").val()
        }
    }
    formdata.append("operatestr", JSON.stringify(condition));
    return formdata;
}

function deleteitem(operatetype, id) {
    var formdata = new FormData();
    formdata.append("operate", operatetype);
    var condition = {
        servicetype: {
            servicetypeid: id
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
            servicetype: {
                servicetypeid:id,
                priority: $(target).parent().parent().find(".st-priority").val(),
                level:$(target).parent().parent().find(".st-level").val()
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