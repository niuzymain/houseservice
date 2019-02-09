$(function () {
    itemsmenu();
    ////////////////////////////////////////显示区域列表/////////////////////////////////////////////
    $("#areamanager").click(function () {
        $("#itemlist thead").empty();
        $("#itemlist tbody").empty();
        var head = "<tr><td>城市名称</td><td>优先级</td><td>操作</td><td><a href='#' id='insert'>新增</a></td><td><a href='#' id='submit'>提交</a></td></tr>"
        $("#itemlist thead").append(head);
        $.getJSON("/admin/getitems?type=城市", function (data) {
            if (data.success) {
                for (var i = 0; i < data.result.length; i++) {
                    var body = "<tr><td>" + data.result[i].workarea.workareaname + "</td><td>" + data.result[i].workarea.priority + "</td><td><a href='#' class='delete' id="+data.result[i].workarea.workareaid+">删除</a></td></tr>"
                    $("#itemlist tbody").append(body);
                }
            }
            else {
                alert(data.errormsg);
            }
        })
        //绑定所有操作按钮
        $("#insert").click(function () {
            $("#itemlist tbody").append("<tr><td><input type='text' placeholder='名称' id='name'></td><td><input type='text' placeholder='优先级' id='priority'></td></tr>");
        })
        $("#submit").click(function () {
            var formdata = insertitem("新增", "城市");
            $.ajax({
                url: "/admin/operate",
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
        $("#itemlist").on("click", ".delete", function (e) {
            var target = e.currentTarget;
            var formdata = deleteitem("删除","城市",target.id)
            $.ajax({
                url: "/admin/operate",
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
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////显示服务类别列表////////////////////////////////////////////////////////////////////////
    $("#categorymanager").click(function () {
        $("#itemlist thead").empty();
        $("#itemlist tbody").empty();
        var head = "<tr><td>服务类别</td><td>优先级</td><td>操作</td><td><a href='#' id='insert'>新增</a></td><td><a href='#' id='submit'>提交</a></td></tr>"
        $("#itemlist thead").append(head);
        $.getJSON("/admin/getitems?type=服务类别", function (data) {
            if (data.success) {
                for (var i = 0; i < data.result.length; i++) {
                    var body = "<tr><td>" + data.result[i].servicetype.servicetypename + "</td><td>" + data.result[i].servicetype.priority + "</td><td><a href='#' class='delete' id="+data.result[i].servicetype.servicetypeid+">删除</a></td></tr>"
                    $("#itemlist tbody").append(body);
                }
            }
            else {
                alert(data.errormsg);
            }

        })
        //绑定所有操作按钮
        $("#insert").click(function () {
            $("#itemlist tbody").append("<tr><td><input type='text' placeholder='名称' id='name'></td><td><input type='text' placeholder='优先级' id='priority'></td></tr>");
        })
        $("#submit").click(function () {
            var formdata = insertitem("新增", "服务类别");
            $.ajax({
                url: "/admin/operate",
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
        $("#itemlist").on("click", ".delete", function (e) {
            var target = e.currentTarget;
            var formdata = deleteitem("删除","服务类别",target.id)
            $.ajax({
                url: "/admin/operate",
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////显示学历列表/////////////////////////////////////////////////////////////////////////
    $("#degreemanager").click(function () {
        $("#itemlist thead").empty();
        $("#itemlist tbody").empty();
        var head = "<tr><td>学历信息</td><td>优先级</td><td>操作</td><td><a href='#' id='insert'>新增</a></td><td><a href='#' id='submit'>提交</a></td></tr>"
        $("#itemlist thead").append(head);
        $.getJSON("/admin/getitems?type=学历", function (data) {
            if (data.success) {
                for (var i = 0; i < data.result.length; i++) {
                    var body = "<tr><td>" + data.result[i].degree.degreename + "</td><td>" + data.result[i].degree.priority + "</td><td><a href='#' class='delete' id="+data.result[i].degree.degreeid+">删除</a></td></tr>"
                    $("#itemlist tbody").append(body);
                }
            }
            else {
                alert(data.errormsg);
            }

        })
        //绑定所有操作按钮
        $("#insert").click(function () {
            $("#itemlist tbody").append("<tr><td><input type='text' placeholder='名称' id='name'></td><td><input type='text' placeholder='优先级' id='priority'></td></tr>");
        })
        $("#submit").click(function () {
            var formdata = insertitem("新增", "学历");
            $.ajax({
                url: "/admin/operate",
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
        $("#itemlist").on("click", ".delete", function (e) {
            var target = e.currentTarget;
            var formdata = deleteitem("删除","学历",target.id)
            $.ajax({
                url: "/admin/operate",
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

    //绑定所有操作按钮


})

function insertitem(operatetype, itemtype) {
    var formdata = new FormData();
    formdata.append("operate", operatetype)
    if (itemtype == "城市") {
        var condition = {
            workarea: {
                workareaname: $("#name").val(),
                priority: $("#priority").val()
            }
        }
    }
    else if(itemtype == "服务类别"){
        var condition = {
            servicetype: {
                servicetypename: $("#name").val(),
                priority: $("#priority").val()
            }
        }
    }
    else if(itemtype == "学历"){
        var condition = {
            degree: {
                degreename: $("#name").val(),
                priority: $("#priority").val()
            }
        }
    }
    else{
        alert("类型错误");
        return false;
    }
    formdata.append("operatestr", JSON.stringify(condition));
    return formdata;
}

function deleteitem(operatetype, itemtype, id) {
    var formdata = new FormData();
    formdata.append("operate", operatetype);
    if (itemtype == "城市") {
        var condition = {
            workarea: {
                workareaid: id
            }
        }
    }
    else if(itemtype == "服务类别"){
        var condition = {
            servicetype: {
                servicetypeid: id
            }
        }
    }
    else if(itemtype == "学历"){
        var condition = {
            degree: {
                degreeid: id
            }
        }
    }
    else{
        alert("类型错误");
        return false;
    }
    formdata.append("operatestr", JSON.stringify(condition));
    return formdata;
}