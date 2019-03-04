$(function () {
    $.getJSON("/user/getheadimglist", function (data) {
        if (data.success) {
            checkaccount(data)
            for (var i = 0; i < data.result.length; i++) {
                var headimg = "<div class=innerwraper>" +
                    "<div id='imgtitle'><h3>" + data.result[i].headimgtitle + "</h3></div>" +
                    "<div id='imgbody'><a href=/user/headimgdetail?headimgid=" + data.result[i].headimgid + ">" +
                    "                <img src=/file" + data.result[i].headimgurl + " alt= />" +
                    "           </a></div></div>";
                $(".inner").append(headimg);
            }
            var headimg = "<div class=innerwraper>" +
                "<div id='imgtitle'><h3>" + data.result[0].headimgtitle + "</h3></div>" +
                "<div id='imgbody'><a href=/user/headimgdetail?headimgid=" + data.result[0].headimgid + ">" +
                "                <img src=/file" + data.result[0].headimgurl + " alt= />" +
                "           </a></div></div>";
            $(".inner").append(headimg);
            runheadimg();
        }
        else {
            alert(data.errormsg)
        }
    })
})

function checkaccount(data) {
    $("#userinfo").empty();
    if (data.account != null) {
        $("#userinfo").append("个人中心")
        $("#userinfo").click(function () {
            window.open("/user/userinfo", '_blank')
        })
    }
    else {
        $("#userinfo").append("登陆/注册")
        $("#userinfo").attr("href", "/login/user")
    }
}