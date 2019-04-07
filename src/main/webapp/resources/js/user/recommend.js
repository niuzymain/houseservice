$(function () {
    $.getJSON("/user/getrecommendservicer", function (data) {
        if (data.success) {
            checkaccount(data)
            if(data.account == null){
                $("#display").html("<h2>请登录查看</h2>");
            }
            else{
                if (data.list != null) {
                    for (var i = 0; i < data.list.length; i++) {
                        var servicerbody = "        <a href=/user/servicerdetail?servicerid=" + data.list[i].servicerid + ">" +
                            "            <div class=frontservicer>" +
                            "                <div class=img>" +
                            "                    <img src=/file" + data.list[i].servicerimg + ">" +
                            "                </div>" +
                            "                <div class=des>" +
                            "                    <p class=s-price>薪资：" + data.list[i].servicerprice + "</p>" +
                            "                    <p>" +
                            "                        <span class=s-name>姓名:" + data.list[i].servicername + "</span>" +
                            "                        <span class=s-sex>性别：" + sexinfo(data.list[i].servicersex) + "</span>" +
                            "                    </p>" +
                            "                    <p class=s-score>历史评分：" + data.list[i].servicerscore + "</p>" +
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