$(function(){
    // 状态为连接形式,添加新增和提交功能
    var head = "<tr>" +
                    "<td>标题</td>" +
                    "<td>描述</td>" +
                    "<td>优先级</td>" +
                    "<td>图片</td>" +
                    "<td>状态</td>" +
                    "<td>操作</td>"+
                    "<td><a href='/admin/operateheadimg'>新增</a></td>" +
                "</tr>"
    $("#headimglist thead").append(head);
    $.getJSON("/admin/headimglist",function(data){
        if(data.success){
            for (var i = 0; i < data.result.length; i++) {
                var body = "<tr>" +
                                "<td>" + data.result[i].headimgtitle + "</td>" +
                                "<td>"+data.result[i].headimgdetails+"</td>" +
                                "<td>"+data.result[i].priority+"</td>" +
                                "<td><a href=/file"+data.result[i].headimgurl+">点击查看</a></td>" +
                                "<td><a href=# onclick=changestatus(this)>"+statusinfo(data.result[i].enablestatus)+"</a></td>" +
                                "<td><a href=# class='edit' id="+data.result[i].headimgid+">编辑<br/><a href=# class='delete' id=\"+data.result[i].headimgid+\">删除</a></td>" +
                            "</tr>"
                $("#headimglist tbody").append(body);
            }
        }
        else{
            alert("错误："+data.errormsg);
        }
    })
})

//根据状态值显示状态名称
function statusinfo(data){
    if(data == 1){
        return"可用"
    }
    else{
        return"禁用"
    }

}

//修改轮播图状态
function changestatus(e){

}
