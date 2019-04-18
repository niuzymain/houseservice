$(function () {
    var pagesize = 20
    var pageindex = 1
    $.getJSON("/admin/getcommentlist?pageindex=1&pagesize=" + pagesize, function (data) {
        if (data.success) {
            for (var i = 0; i < data.list.length; i++) {
                var body = "<tr>" +
                    "<td>" + data.list[i].user.accountname + "</td>" +
                    "<td>" + data.list[i].evaluatedes + "</td>" +
                    "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                    "<td>" + data.list[i].servicer.servicername + "</td>"
                if (data.list[i].enablestatus == -1) {
                    body += "<td>已屏蔽</td>"
                }
                else {
                    body += "<td><a href=# class='illegal' id=" + data.list[i].evaluateid + " onclick=cover(this)>屏蔽</a></td>"
                }
                body += "</tr>"

                $("table tbody").append(body);
            }
///////////////////////////////////////初始化分页器////////////////////////////////////////////
            $('#pageindex').pagination({
                styleClass: ['pagination-large'],
                showCtrl: true,
                displayPage: 6,
                itemsCount: data.evaluatecount,
                pageSize: pagesize,
                onSelect: function (num) {
////////////////////////////////////////分页查询///////////////////////////////////////////////////////////////////////////
                    pageindex = num
                    $.getJSON("/admin/getcommentlist?pageindex=" + pageindex + "&pagesize=" + pagesize, function (data) {
                        if (data.success) {
                            $("table tbody").empty();
                            for (var i = 0; i < data.list.length; i++) {
                                var body = "<tr>" +
                                    "<td>" + data.list[i].user.accountname + "</td>" +
                                    "<td>" + data.list[i].evaluatedes + "</td>" +
                                    "<td>" + timeStamp2String(data.list[i].createtime) + "</td>" +
                                    "<td>" + data.list[i].servicer.servicername + "</td>"
                                if (data.list[i].enablestatus == -1) {
                                    body += "<td>已屏蔽</td>"
                                }
                                else {
                                    body += "<td><a href=# class='illegal' id=" + data.list[i].evaluateid + " onclick=cover(this)>屏蔽</a></td>"
                                }
                                body += "</tr>"

                                $("table tbody").append(body);
                            }
                            $('#pageindex').pagination('updateItemsCount', data.evaluatecount)
                        }
                    })
                }
            })
        }
        else {
            alert("错误：" + data.errormsg);
        }
    })
})

///////////////////////////////屏蔽违规评论，向后台提交evaluateid///////////////////////////
function cover(target) {
    $.ajax({
        url: "/admin/illegalcommentoperate",
        data: {
            evaluateid: target.id
        },
        type: "post",
        success: function (data) {
            if (data.success) {
                alert("success")
                window.location.reload();
            }
            else {
                alert(data.errormsg)
            }
        }
    })
}
