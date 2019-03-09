////////////////////////////// 从url中取参数/////////////////////////////////////
function getURLarg(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return null;
}

///////////////////////////////////更换验证码///////////////////////////////////////
function changecode(target) {
    target.src = "../checkcode?" + Math.floor(Math.random() * 100);
}

/////////////////////////根据状态值显示状态名称//////////////////////////////////////////
function statusinfo(data) {
    if (data == 1) {
        return "可用"
    }
    else if (data == 0) {
        return "禁用"
    }
    else if (data == 2) {
        return "服务中"
    }

}

/////////////////////////////////根据性别值显示性别名称////////////////////////////////
function sexinfo(data) {
    if (data == 1) {
        return "男"
    }
    else if (data == 2) {
        return "女"
    }

}

////////////////////////////根据经验值显示经验名称//////////////////////////////////
function experienceinfo(data) {
    if (data == 0) {
        return "无经验"
    }
    else if (data < 12) {
        return data + "个月"
    }
    else {
        return data / 12 + "年"
    }
}

//格式化date
function timeStamp2String(time) {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    // var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    // var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    // var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date/*+" "+hour+":"+minute+":"+second*/;
}

//二级列表显示切换
function displaychange() {
    $(".secondmenu").show();
}

//开启轮播图
function runheadimg() {
    var innerGroup = $(".innerwraper");
    var leftArrow = $(".left-arrow");
    var rightArrow = $(".right-arrow");
    var spanGroup = $(".pagination span");
    var imgWidth = $(".innerwraper img:first-child").eq(0).width();
    var _index = 0;
    var timer = null;
    var flag = true;
    rightArrow.on("click", function () {
        //右箭头
        flag = false;
        clearInterval(timer);
        _index++;
        selectPic(_index);
    })
    leftArrow.on("click", function () {
        //左箭头
        flag = false;
        clearInterval(timer);
        if (_index == 0) {
            _index = innerGroup.length - 1;
            $(".inner").css("left", -(innerGroup.length - 1) * imgWidth);
        }
        _index--;
        selectPic(_index);
    })
    spanGroup.on("click", function () {
        //导航切换
        _index = spanGroup.index($(this));
        selectPic(_index);
    })

    $(".container").hover(function () {
        //鼠标移入
        clearInterval(timer);
        flag = false;
    }, function () {
        flag = true;
        timer = setInterval(go, 3000);
    });

    function autoGo(bol) {
        //自动行走
        if (bol) {
            timer = setInterval(go, 3000);
        }
    }

    autoGo(flag);

    function go() {
        //计时器的函数
        _index++;
        selectPic(_index);
    }

    function selectPic(num) {
        $(".pagination span").eq(num).addClass("active").siblings().removeClass("active");
        $(".inner").animate({
            left: -num * imgWidth,
        }, 1000, function () {
            //检查是否到最后一张
            if (_index == innerGroup.length - 1) {
                _index %= 4;
                $(".inner").css("left", "0px");
                $(".pagination span").eq(0).addClass("active").siblings().removeClass("active");
            }
        })
    }
}

//从数据库中获取字段
function getItemsFromDB() {
    $.getJSON("/common/getitemlist", function (data) {
        if (data.success) {
            var i;
            for (i = 0; i < data.degrees.length; i++) {
                $(".degree select").append("<option value=" + data.degrees[i].degreeid + ">" + data.degrees[i].degreename + "</option>")
            }
            for (i = 0; i < data.citys.length; i++) {
                $(".area .citys").append("<option value=" + data.citys[i].workareaid + ">" + data.citys[i].workareaname + "</option>")
            }
            for (i = 0; i < data.types.length; i++) {
                $(".type select").append("<option value=" + data.types[i].servicetypeid + ">" + data.types[i].servicetypename + "</option>")
            }
        }
        else {
            alert(data.errormsg)
        }
    })
}

//////////////////////////////预约状态前端展示////////////////////////////////
function reserveinfo(data) {
    if (data == -1) {
        return "已取消"
    }
    else if (data == 0) {
        return "待处理"
    }
    else if (data == 1) {
        return "已受理"
    }
    else if(data == 2){
        return "已确认"
    }
    else if(data == 3){
        return "已完成"
    }
    else{
        return "状态异常"
    }
}

