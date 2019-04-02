$(function () {
    $("#logout").click(function () {
        $.getJSON("/servicer/logout", function (data) {
            if (data.success) {
                alert("退出成功")
                window.location.href = "/login/servicer"
            }
        })
    })
    $.getJSON("/servicer/getservicerinfo", function (data) {
            if(data.success){
                $("h1 a").append(data.result.servicername)
            }
            else{
                alert(data.errormsg)
            }
    })
    $.getJSON("/servicer/getevaluatelist", function (data) {
        if (data.success) {
            // for (var i = 0; i < data.result.length; i++) {
            //     var divli = "<li>" +
            //         "<div>" +
            //         "<p>创建时间:" + timeStamp2String(data.result[i].createtime) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 评分:" + data.result[i].evaluatescore + "</p>" +
            //         "<p>" + data.result[i].evaluatedes + "</p>" +
            //         "</div>"
            //     "</li>"
            //     $("#evaluatelist").append(divli);
            // }
            for (var i = 0; i < data.result.length; i++) {
                var commentbody = "<li class=\"am-comment\">\n" +
                    "                <a href=\"#link-to-user-home\">\n" +
                    "                    <img src=\"../resources/img/commentheader.jpg\"  class=\"am-comment-avatar\" width=\"48\" height=\"48\"/>\n" +
                    "                </a>\n" +
                    "                <div class=\"am-comment-main\">\n" +
                    "                    <header class=\"am-comment-hd\">\n" +
                    "                        <div class=\"am-comment-meta\">\n" +
                    "                            <a href=\"#\" class=\"am-comment-author\">某人</a><span class=\"c-time\">评论于" + timeStamp2String(data.result[i].createtime) + "</span><span class=\"c-score\">评分:" + data.result[i].evaluatescore + "</span>\n" +
                    "                        </div>\n" +
                    "                    </header>\n" +
                    "                    <div class=\"am-comment-bd\">\n" +
                    data.result[i].evaluatedes +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "        </li>"
                $("#evaluatelist").append(commentbody)
            }
        }

        else {
            alert(data.errormsg)
        }
    })
})