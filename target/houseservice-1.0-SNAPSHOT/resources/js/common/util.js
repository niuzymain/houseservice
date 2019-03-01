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
