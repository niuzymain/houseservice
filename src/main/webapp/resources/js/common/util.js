// 从url中取参数
function getURLarg(variable){
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable)
        {
            return pair[1];
        }
    }
    return null;
}
//判断验证码

//根据状态值显示状态名称
function statusinfo(data) {
    if (data == 1) {
        return "可用"
    }
    else if(data == 0){
        return "禁用"
    }

}