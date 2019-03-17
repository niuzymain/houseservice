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
    if (servicerid != null) {
        //////////////////////////修改信息////////////////////////////////////////
        $("#back").attr("href","/servicer/displayinfo")
        $.getJSON("/servicer/getservicerinfo", function (data) {
            if (data.success) {
                $(".name input").val(data.result.servicername)
                $(".idnum input").val(data.result.serviceridnum)
                $(".age input").val(data.result.servicerage)
                $(".sex select").val(data.result.servicersex)
                $(".phone input").val(data.result.servicerphone)
                $(".des textarea").val(data.result.servicerdes)
                $(".file").append("<a href=/file" + data.result.servicerfile + ">查看文件</a>")
                $(".img").append("<a href=/file" + data.result.servicerimg + ">查看文件</a>")
                $(".account .accountname").val(data.result.accountname)
                $(".account .password").val(data.result.password)
            }
            else {
                alert(data.errormsg)
            }
        })
        $("#submit").click(function () {
            var servicer = {
                serviceridnum: $(".idnum input").val(),
                servicername: $(".name input").val(),
                servicerage: $(".age input").val(),
                servicersex: $(".sex select").val(),
                servicerphone: $(".phone input").val(),
                servicerexperience: $(".experience select").val(),
                servicerdes: $(".des textarea").val(),
                degree: {
                    degreeid: $(".degree select").val()
                },
                servicetype: {
                    servicetypeid: $(".type select").val()
                },
                city: {
                    workareaid: $(".area .citys").val()
                },
                local: {
                    workareaid: $(".area .locals").val()
                },
                accountname: $(".account .accountname").val(),
                password: $(".account .password").val()
            }
            var img = $(".img input")[0].files[0];
            var file = $(".file input")[0].files[0];
            var formdata = new FormData();
            formdata.append("str", JSON.stringify(servicer))
            formdata.append("img", img);
            formdata.append("file", file);
            $.ajax({
                url: "/servicer/editservicerregisterinfo",
                data: formdata,
                type: "post",
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    if (data.success) {
                        alert("success")
                        window.location.href = "/login/servicer"
                    }
                    else {
                        alert(data.errormsg)
                    }
                }
            })
        })
    }
////////////////////////////提交事件///////////////////////////////////////////
    else {
        $("#back").attr("href","/user/main")
        $("#submit").click(function () {
            var servicer = {
                serviceridnum: $(".idnum input").val(),
                servicername: $(".name input").val(),
                servicerage: $(".age input").val(),
                servicersex: $(".sex select").val(),
                servicerphone: $(".phone input").val(),
                servicerexperience: $(".experience select").val(),
                servicerdes: $(".des textarea").val(),
                degree: {
                    degreeid: $(".degree select").val()
                },
                servicetype: {
                    servicetypeid: $(".type select").val()
                },
                city: {
                    workareaid: $(".area .citys").val()
                },
                local: {
                    workareaid: $(".area .locals").val()
                },
                accountname: $(".account .accountname").val(),
                password: $(".account .password").val()
            }
            var img = $(".img input")[0].files[0];
            var file = $(".file input")[0].files[0];
            var formdata = new FormData();
            formdata.append("register", JSON.stringify(servicer))
            formdata.append("img", img);
            formdata.append("file", file);
            $.ajax({
                url: "/servicer/registeroperate",
                data: formdata,
                type: "post",
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    if (data.success) {
                        alert("success")
                        window.location.href = "/login/servicer"
                    }
                    else {
                        alert(data.errormsg)
                    }
                }
            })
        })
    }

})
