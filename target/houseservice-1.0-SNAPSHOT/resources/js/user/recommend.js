$(function () {
    $.getJSON("/user/getrecommendservicer", function (data) {
        if (data.success) {
            checkaccount(data)
            if(data.account == null){
                $("#display").html("<h2>请登录查看</h2>");
            }
            else{
                if (data.cblist != null) {
                    for (var i = 0; i < data.cblist.length; i++) {
                        var servicerbody = "        <a href=/user/servicerdetail?servicerid=" + data.cblist[i].servicerid + ">" +
                            "            <div class=frontservicer>" +
                            "                <div class=img>" +
                            "                    <img src=/file" + data.cblist[i].servicerimg + ">" +
                            "                </div>" +
                            "                <div class=des>" +
                            "                    <p class=s-price>薪资：" + data.cblist[i].servicerprice + "</p>" +
                            "                    <p>" +
                            "                        <span class=s-name>姓名:" + data.cblist[i].servicername + "</span>" +
                            "                        <span class=s-sex>性别：" + sexinfo(data.cblist[i].servicersex) + "</span>" +
                            "                    </p>" +
                            "                    <p class=s-score>历史评分：" + data.cblist[i].servicerscore + "</p>" +
                            "                </div>" +
                            "            </div>" +
                            "        </a>"
                        $("#content-base").append(servicerbody);
                    }
                }
                if (data.cflist != null) {
                    for (var i = 0; i < data.cflist.length; i++) {
                        var servicerbody = "        <a href=/user/servicerdetail?servicerid=" + data.cflist[i].servicerid + ">" +
                            "            <div class=frontservicer>" +
                            "                <div class=img>" +
                            "                    <img src=/file" + data.cflist[i].servicerimg + ">" +
                            "                </div>" +
                            "                <div class=des>" +
                            "                    <p class=s-price>薪资：" + data.cflist[i].servicerprice + "</p>" +
                            "                    <p>" +
                            "                        <span class=s-name>姓名:" + data.cflist[i].servicername + "</span>" +
                            "                        <span class=s-sex>性别：" + sexinfo(data.cflist[i].servicersex) + "</span>" +
                            "                    </p>" +
                            "                    <p class=s-score>历史评分：" + data.cflist[i].servicerscore + "</p>" +
                            "                </div>" +
                            "            </div>" +
                            "        </a>"
                        $("#user-base").append(servicerbody);
                    }
                }
            }
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