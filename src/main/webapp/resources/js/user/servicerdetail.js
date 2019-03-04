$(function () {
    var servicerid = getURLarg("servicerid")
    $.getJSON("/user/getservicerdetail?servicerid=" + servicerid, function (data) {
        if (data.success) {
///////////////////////////////////////展示服务人员详情信息////////////////////////////////////////////////////////////////////////
            $(".img img").attr("src", "/file" + data.servicer.servicerimg)
            $(".s-name").append("<td>" + data.servicer.servicername + "</td>")
            $(".s-age").append("<td>" + data.servicer.servicerage + "</td>")
            $(".s-sex").append("<td>" + sexinfo(data.servicer.servicersex) + "</td>")
            $(".s-score").append("<td>" + data.servicer.servicerscore + "</td>")
            $(".s-area").append("<td>" + data.servicer.city.workareaname + "-" + data.servicer.local.workareaname + "</td>")
            $(".s-type").append("<td>" + data.servicer.servicetype.servicetypename + "</td>")
            $(".s-degree").append("<td>" + data.servicer.servicername + "</td>")
            $(".s-experience").append("<td>" + experienceinfo(data.servicer.servicerexperience) + "</td>")
            $(".s-price").append("<td>" + data.servicer.servicerprice + "</td>")
            $(".s-phone").append("<td>" + data.servicer.servicerphone + "</td>")
////////////////////////////////////////////////////展示服务人员评价////////////////////////////////////////////////////////
            for (var i = 0; i < data.list.length; i++) {
                var commentbody = "<li class=\"am-comment\">\n" +
                    "                <a href=\"#link-to-user-home\">\n" +
                    "                    <img src=\"../resources/img/commentheader.jpg\"  class=\"am-comment-avatar\" width=\"48\" height=\"48\"/>\n" +
                    "                </a>\n" +
                    "                <div class=\"am-comment-main\">\n" +
                    "                    <header class=\"am-comment-hd\">\n" +
                    "                        <div class=\"am-comment-meta\">\n" +
                    "                            <a href=\"#\" class=\"am-comment-author\">某人</a><span class=\"c-time\">评论于" + timeStamp2String(data.list[i].createtime) + "</span><span class=\"c-score\">评分:" + data.list[i].evaluatescore + "</span>\n" +
                    "                        </div>\n" +
                    "                    </header>\n" +
                    "                    <div class=\"am-comment-bd\">\n" +
                    data.list[i].evaluatedes +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "        </li>"
                $(".am-comments-list").append(commentbody)
            }
        }
        else {
            alert(data.errormsg)
        }
    })
//////////////////////////////////////////////////////返回按钮事件///////////////////////////////////////////////////////////
    $(".back").click(function(){
        window.location.href="/user/servicerpage"
    })
    /////////////////////////////////////////////////预约按钮事件///////////////////////////////////////////////////////////
    $(".reserve").click(function(){
        window.location.href="/user/reserve?servicerid="+servicerid
    })
})