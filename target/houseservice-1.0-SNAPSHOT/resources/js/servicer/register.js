$(function(){
    getItemsFromDB();
////////////////////////////////删除请选择一栏////////////////////////////////////////
    $(".select").on("change",function(){
        $(this).find("option[value='-1']").remove();
    })
////////////////////////////////根据城市获取地区信息///////////////////////////////////////////////
    $(".area .citys").on("change",function(){
        $(".area .locals").html("<option selected=selected value=0>请选择</option>");
        $.getJSON("/servicer/getlocals?parentid="+$(".area .citys").val(),function(data){
            if(data.success){
                var i;
                for(i=0;i<data.locals.length;i++){
                    $(".area .locals").append("<option value="+data.locals[i].workareaid+">"+data.locals[i].workareaname+"</option>")
                }
            }
            else{
                alert(data.errormsg)
            }
        })
    })
////////////////////////////提交事件///////////////////////////////////////////
    $("#submit").click(function(){
        var servicer = {
            serviceridnum:$(".idnum input").val(),
            servicername:$(".name input").val(),
            servicerage:$(".age input").val(),
            servicersex:$(".sex select").val(),
            servicerphone:$(".phone input").val(),
            servicerexperience:$(".experience select").val(),
            servicerprice:$(".salary select").val(),
            servicerdes:$(".des textarea").val(),
            degree:{
                degreeid:$(".degree select").val()
            },
            servicetype:{
                servicetypeid:$(".type select").val()
            },
            city:{
                workareaid:$(".area .citys").val()
            },
            local:{
                workareaid:$(".area .locals").val()
            },
            accountname:$(".account .accountname").val(),
            password:$(".account .password").val()
        }
        var img = $(".img input")[0].files[0];
        var file = $(".file input")[0].files[0];
        var formdata = new FormData();
        formdata.append("register",JSON.stringify(servicer))
        formdata.append("img",img);
        formdata.append("file",file);
    })
})
//从数据库中获取字段
function getItemsFromDB(){
    $.getJSON("/servicer/getitemlist",function(data){
        if(data.success){
            var i;
            for(i=0;i<data.degrees.length;i++){
                $(".degree select").append("<option value="+data.degrees[i].degreeid+">"+data.degrees[i].degreename+"</option>")
            }
            for(i=0;i<data.citys.length;i++){
                $(".area .citys").append("<option value="+data.citys[i].workareaid+">"+data.citys[i].workareaname+"</option>")
            }
            for(i=0;i<data.types.length;i++){
                $(".type select").append("<option value="+data.types[i].servicetypeid+">"+data.types[i].servicetypename+"</option>")
            }
        }
        else{
            alert(data.errormsg)
        }
    })
}