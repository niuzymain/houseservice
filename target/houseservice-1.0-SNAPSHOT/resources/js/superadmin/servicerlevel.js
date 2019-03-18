$(function () {
    var servicerid = getURLarg("servicerid")
    getItemsFromDB();
    $.getJSON("/admin/getqualifydetail?servicerid="+servicerid,function(data){
        if(data.success){
            $(".servicername").append(data.result.servicername)
        }
        else{
            alert(data.errormsg);
        }
    })
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
    $(".salary button").click(function () {
        if ($(".experience select").val() == -1) {
            alert("请录入工作经验")
            return false;
        }
        else if ($(".area .citys").val() == -1) {
            alert("请录入工作区域")
            return false;
        }
        else if ($(".area .locals").val() == -1) {
            alert("请录入工作区域")
            return false;
        }
        else if ($(".degree select").val() == -1) {
            alert("请录入学历")
            return false;
        }
        else if ($(".type select").val() == -1) {
            alert("请录入服务类别")
            return false;
        }
        else {
            var servicer = {
                servicerid: servicerid,
                servicetype: {
                    servicetypeid: $(".type select").val()
                },
                degree: {
                    degreeid: $(".degree select").val()
                },
                city: {
                    workareaid: $(".area .citys").val()
                },
                local: {
                    workareaid: $(".area .locals").val()
                },
                servicerexperience: $(".experience select").val()
            }
            var formdata = new FormData
            formdata.append("servicer", JSON.stringify(servicer))
            $.ajax({
                url: "/admin/getSalary",
                type: "POST",
                data: formdata,
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    if (data.success) {
                        $(".salary input").val(data.salary)
                    }
                    else {
                        alert(data.errormsg)
                    }
                }
            })
        }
    })
    $("#back").click(function(){
        window.location.href="/admin/qualify";
    })
    $("#submit").click(function(){
        var servicer = {
            servicerid: servicerid,
            servicerprice:$(".salary input").val()
        }
        var formdata = new FormData
        formdata.append("servicer", JSON.stringify(servicer))
        $.ajax({
            url: "/admin/passqualifyoperate",
            type: "POST",
            data: formdata,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert("success")
                    window.location.href="/admin/qualify";
                }
                else {
                    alert(data.errormsg)
                }
            }
        })
    })
})