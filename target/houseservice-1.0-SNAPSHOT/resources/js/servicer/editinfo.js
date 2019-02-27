$(function () {
    getItemsFromDB()
    ////////////////////////////////根据城市获取地区信息///////////////////////////////////////////////
    $(".area #citys").on("change", function () {
        $(".area #locals").html("<option selected=selected value=0>请选择</option>");
        $.getJSON("/servicer/getlocals?parentid=" + $(".area #citys").val(), function (data) {
            if (data.success) {
                var i;
                for (i = 0; i < data.locals.length; i++) {
                    $(".area #locals").append("<option value=" + data.locals[i].workareaid + ">" + data.locals[i].workareaname + "</option>")
                }
            }
            else {
                alert(data.errormsg)
            }
        })
    })
/////////////////////////////////获取初始信息///////////////////////////////////////////////////////
    $.getJSON("/servicer/getservicerinfo",function(data){
        if(data.success){
///////////////////////////////////////////////加载城市下的区域信息/////////////////////////////////////////////
            $.getJSON("/servicer/getlocals?parentid=" + data.result.city.workareaid, function (data1) {
                if (data1.success) {
                    var i;
                    for (i = 0; i < data1.locals.length; i++) {
                        $(".area #locals").append("<option value=" + data1.locals[i].workareaid + ">" + data1.locals[i].workareaname + "</option>")
                    }
                    $(".area #locals").val(data.result.local.workareaid)
                }
                else {
                    alert(data1.errormsg)
                }
            })
/////////////////////////////////////////////加载用户信息////////////////////////////////////////////////////////////
            $(".name input").val(data.result.servicername)
            $(".idnum input").val(data.result.serviceridnum)
            $(".age input").val(data.result.servicerage)
            $(".sex select").val(data.result.servicersex)
            $(".phone input").val(data.result.servicerphone)
            $(".img").append("<a href=/file"+data.result.servicerimg+">查看文件</a>")
            $(".experience select").val(data.result.servicerexperience)
            $(".salary input").val(data.result.servicerprice)
            $(".des textarea").val(data.result.servicerdes)
            $(".file").append("<a href=/file"+data.result.servicerfile+">查看文件</a>")
            $(".lastedittime input").val(timeStamp2String(data.result.lastedittime))
            $(".degree select").val(data.result.degree.degreeid)
            $(".type select").val(data.result.servicetype.servicetypeid)
            $(".area #citys").val(data.result.city.workareaid)
        }
        else{
            alert(data.errormsg)
        }
    })
////////////////////////////提交事件///////////////////////////////////////////
    $("#submit").click(function () {
        var servicer = {
            serviceridnum: $(".idnum input").val(),
            servicername: $(".name input").val(),
            servicerage: $(".age input").val(),
            servicersex: $(".sex select").val(),
            servicerphone: $(".phone input").val(),
            servicerexperience: $(".experience select").val(),
            servicerprice: $(".salary select").val(),
            servicerdes: $(".des textarea").val(),
            degree: {
                degreeid: $(".degree select").val()
            },
            servicetype: {
                servicetypeid: $(".type select").val()
            },
            city: {
                workareaid: $(".area #citys").val()
            },
            local: {
                workareaid: $(".area #locals").val()
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
            url: "/servicer/editservicerinfo",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success:function(data){
                if(data.success){
                    alert("success")
                    window.location.href="/servicer/displayinfo"
                }
                else{
                    alert(data.errormsg)
                }
            }
        })
    })
})

//从数据库中获取字段
function getItemsFromDB() {
    $.getJSON("/servicer/getitemlist", function (data) {
        if (data.success) {
            var i;
            for (i = 0; i < data.degrees.length; i++) {
                $(".degree select").append("<option value=" + data.degrees[i].degreeid + ">" + data.degrees[i].degreename + "</option>")
            }
            for (i = 0; i < data.citys.length; i++) {
                $(".area #citys").append("<option value=" + data.citys[i].workareaid + ">" + data.citys[i].workareaname + "</option>")
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