$(function () {
    var head = "<tr>" +
                    "<td>区域名称</td>" +
                    "<td>优先级</td>" +
                    "<td>操作</td>" +
                    "<td><a href='#' id='insert'>新增地区</a></td>" +
                    "<td><a href='#' id='submit'>提交</a></td>" +
                "</tr>"
    $("#arealist thead").append(head);
    var parentid = getURLarg("parentid");
    $.getJSON("/admin/getcityareas?parentid=" + parentid, function (data) {
        if (data.success) {
            for (var i = 0; i < data.result.length; i++) {
                var body = "<tr><td>" + data.result[i].workareaname + "</td><td>" + data.result[i].priority + "</td><td><a href='#' class='delete' id="+data.result[i].workareaid+">删除</a></td></tr>"
                $("#arealist tbody").append(body);
            }
        }
        else {
            alert("错误信息:" + data.errormsg)
        }
    })
    $("#insert").click(function () {
        $("#arealist tbody").append("<tr><td><input type='text' placeholder='名称' id='name'></td><td><input type='text' placeholder='优先级' id='priority'></td></tr>");
    })
    $("#submit").click(function () {
        var formdata =new FormData();
        var condition = {
            workarea:{
                workareaname:$("#name").val(),
                priority:$("#priority").val(),
                parentarea:{
                    workareaid:parentid
                }
            }
        }
        formdata.append("operatestr",JSON.stringify(condition))
        formdata.append("operate","新增")
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
    // $("#arealist").on("click", ".delete", function (e) {
    //     var target = e.currentTarget;
    //     var formdata = new FormData();
    //     var condition = {
    //         workarea:{
    //             workareaid:target.id
    //         }
    //     }
    //     formdata.append("operatestr",JSON.stringify(condition))
    //     formdata.append("operate","删除")
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