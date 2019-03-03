$(function () {
    var pagesize = 2
    var pageindex = 1
    ////////////////////////////////////初始化界面////////////////////////////////////////////////////////
    var formdata = new FormData()
    var servicer = {
        servicerage: -1,
        servicersex: -1,
        servicerexperience: -1,
        servicerscore: -1,
        servicerprice: -1,
        degree: {
            degreeid: -1
        },
        city: {
            workareaid: -1
        },
        local: {
            workareaid: -1
        },
        servicetype: {
            servicetypeid: -1
        }
    }
    formdata.append("pageindex", 1)
    formdata.append("pagesize", pagesize)
    formdata.append("servicerstr", JSON.stringify(servicer))
    formdata.append("order", "score")
    $.ajax({
        url: "/user/getavailableservicer",
        data: formdata,
        type: "post",
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data.success) {
                displayServicer(data);
                $('#pageindex').pagination({
                    styleClass: ['pagination-large'],
                    showCtrl: true,
                    displayPage: 6,
                    itemsCount: data.count,
                    pageSize: pagesize,
                    onSelect: function (num) {
////////////////////////////////////////分页查询///////////////////////////////////////////////////////////////////////////
                        pageindex = num
                        var formdata = new FormData()
                        var servicer = {
                            servicerage: $(".age").val(),
                            servicersex: $(".sex").val(),
                            servicerexperience: $(".experience").val(),
                            servicerscore: $(".score").val(),
                            servicerprice: $(".price").val(),
                            degree: {
                                degreeid: $(".degree").val()
                            },
                            city: {
                                workareaid: $(".citys").val()
                            },
                            local: {
                                workareaid: $(".locals").val()
                            },
                            servicetype: {
                                servicetypeid: $(".type").val()
                            }
                        }
                        formdata.append("pageindex", pageindex)
                        formdata.append("pagesize", pagesize)
                        formdata.append("servicerstr", JSON.stringify(servicer))
                        if ($("#order .active").text() == "默认评分排序") {
                            formdata.append("order", "score")
                        }
                        else if ($("#order .active").text() == "按修改时间排序") {
                            formdata.append("order", "lastedittime")
                        }
                        else if ($("#order .active").text() == "按薪资排序") {
                            formdata.append("order", "price")
                        }
                        $.ajax({
                            url: "/user/getavailableservicer",
                            data: formdata,
                            type: "post",
                            contentType: false,
                            processData: false,
                            cache: false,
                            success: function (data) {
                                if (data.success) {
                                    displayServicer(data);
                                    $('#pageindex').pagination('updateItemsCount', data.count)
                                }
                                else {
                                    alert(data.errormsg)
                                }
                            }
                        })
                    }
                })
            }
            else {
                alert(data.errormsg)
            }
        }
    })
    //////////////////////////////////后台获取搜索条件////////////////////////////////////////////////////////////
    $.getJSON("/common/getitemlist", function (data) {
        if (data.success) {
            var i;
            for (i = 0; i < data.degrees.length; i++) {
                $(".degree").append("<option value=" + data.degrees[i].degreeid + ">" + data.degrees[i].degreename + "</option>")
            }
            for (i = 0; i < data.citys.length; i++) {
                $(".citys").append("<option value=" + data.citys[i].workareaid + ">" + data.citys[i].workareaname + "</option>")
            }
            for (i = 0; i < data.types.length; i++) {
                $(".type").append("<option value=" + data.types[i].servicetypeid + ">" + data.types[i].servicetypename + "</option>")
            }
        }
        else {
            alert(data.errormsg)
        }
    })

    $(".citys").on("change", function () {
        $(".locals").html("<option selected=selected value=-1>不限</option>");
        $.getJSON("/common/getlocals?parentid=" + $(".citys").val(), function (data) {
            if (data.success) {
                var i;
                for (i = 0; i < data.locals.length; i++) {
                    $(".locals").append("<option value=" + data.locals[i].workareaid + ">" + data.locals[i].workareaname + "</option>")
                }
            }
            else {
                alert(data.errormsg)
            }
        })
    })
    //////////////////////////////////////////////////////展示筛选条件/////////////////////////////////////////////////////
    $("#conditionselect select").change(function () {
        if ($(this).attr("class") == "citys") {
            $(".area-select").empty();
            if ($(this).val() != -1) {
                $(".area-select").append("工作区域" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "locals") {
            $(".area-select").html("工作区域" + $(".citys").find("option:selected").text());
            if ($(this).val() != -1) {
                $(".area-select").append("-" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "age") {
            $(".age-select").empty();
            if ($(this).val() != -1) {
                $(".age-select").append("年龄" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "sex") {
            $(".sex-select").empty();
            if ($(this).val() != -1) {
                $(".sex-select").append("性别" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "price") {
            $(".price-select").empty();
            if ($(this).val() != -1) {
                $(".price-select").append("薪资" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "type") {
            $(".type-select").empty();
            if ($(this).val() != -1) {
                $(".type-select").append("服务类别" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "degree") {
            $(".degree-select").empty();
            if ($(this).val() != -1) {
                $(".degree-select").append("学历" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "degree") {
            $(".degree-select").empty();
            if ($(this).val() != -1) {
                $(".degree-select").append("学历" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "experience") {
            $(".experience-select").empty();
            if ($(this).val() != -1) {
                $(".experience-select").append("工作经验" + $(this).find("option:selected").text());
            }
        }
        else if ($(this).attr("class") == "score") {
            $(".score-select").empty();
            if ($(this).val() != -1) {
                $(".score-select").append("历史评分" + $(this).find("option:selected").text());
            }
        }
        else {
            alert("条件为空");
        }
    })
////////////////////////////////////////////////////////搜索绑定/////////////////////////////////////////////////////
    $("#search").click(function () {
        $("#order button").removeClass("active")
        $("#order button:eq(0)").addClass("active")
        var formdata = new FormData()
        var servicer = {
            servicerage: $(".age").val(),
            servicersex: $(".sex").val(),
            servicerexperience: $(".experience").val(),
            servicerscore: $(".score").val(),
            servicerprice: $(".price").val(),
            degree: {
                degreeid: $(".degree").val()
            },
            city: {
                workareaid: $(".citys").val()
            },
            local: {
                workareaid: $(".locals").val()
            },
            servicetype: {
                servicetypeid: $(".type").val()
            }
        }
        formdata.append("pageindex", 1)
        formdata.append("pagesize", pagesize)
        formdata.append("servicerstr", JSON.stringify(servicer))
        formdata.append("order", "score")
        $.ajax({
            url: "/user/getavailableservicer",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    displayServicer(data);
                    $('#pageindex').pagination('updateItemsCount', data.count,1)
                }
                else {
                    alert(data.errormsg)
                }
            }
        })
    })
////////////////////////////////////////////////////////排序绑定/////////////////////////////////////////////////////
    $("#order button").click(function () {
        $("#order button").removeClass("active")
        $(this).addClass("active")
        var formdata = new FormData()
        var servicer = {
            servicerage: $(".age").val(),
            servicersex: $(".sex").val(),
            servicerexperience: $(".experience").val(),
            servicerscore: $(".score").val(),
            servicerprice: $(".price").val(),
            degree: {
                degreeid: $(".degree").val()
            },
            city: {
                workareaid: $(".citys").val()
            },
            local: {
                workareaid: $(".locals").val()
            },
            servicetype: {
                servicetypeid: $(".type").val()
            }
        }
        formdata.append("pageindex", 1)
        formdata.append("pagesize", pagesize)
        formdata.append("servicerstr", JSON.stringify(servicer))
        if ($(this).text() == "默认评分排序") {
            formdata.append("order", "score")
        }
        else if ($(this).text() == "按修改时间排序") {
            formdata.append("order", "lastedittime")
        }
        else if ($(this).text() == "按薪资排序") {
            formdata.append("order", "price")
        }
        $.ajax({
            url: "/user/getavailableservicer",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    displayServicer(data);
                    $('#pageindex').pagination('updateItemsCount', data.count,1)
                }
                else {
                    alert(data.errormsg)
                }
            }
        })
    })

})

///////////////////////////////////////////////展示服务人员信息//////////////////////////////////////////////////////
function displayServicer(data) {
    $("#servicerlist").empty();
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
        $("#servicerlist").append(servicerbody);
    }
}

// function setPagination(totalcount,pagesize){
//
// }