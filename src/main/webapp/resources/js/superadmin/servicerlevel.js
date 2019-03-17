$(function () {
    var servicerid = getURLarg("servicerid")
    getItemsFromDB();
////////////////////////////////删除请选择一栏////////////////////////////////////////
    $(".select").on("change", function () {
        $(this).find("option[value='-1']").remove();
    })
////////////////////////////////根据城市获取地区信息///////////////////////////////////////////////
    $(".area .citys").on("change", function () {
        $(".area .locals").html("<option selected=selected value=0>请选择</option>");
        $.getJSON("/common/getlocals?parentid=" + $(".area .citys").val(), function (data) {
            if (data.success) {
                var i;
                for (i = 0; i < data.locals.length; i++) {
                    $(".area .locals").append("<option value=" + data.locals[i].workareaid + ">" + data.locals[i].workareaname + "</option>")
                }
            }
            else {
                alert(data.errormsg)
            }
        })
    })
})