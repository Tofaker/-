$(function () {//html页面加载完成后执行方法
    $("#login_form").submit(function () {//绑定表单的提交事件

        //alert("submit")验证
        $.ajax({
            url:"/login/json1",
            //url:"../data/login2.json",
            type:"post",//请求方法
            dataType:"application/json",//响应数据类型：
            data:$("#login_form").serialize(),//请求数据：使用表单的数据
            contentType:"application/json",//请求数据类型：Content-Type
            success:function (resp) {//响应状态码为2xx  success 返回的数据传入function 以resp形参存在
                if (resp.success){//返回数据Boolean
                    window.location = "main.html" //把地址栏url改为指定值
                }else {
                    alert("错误码"+resp.code+"\n错误信息:"+resp.message);//提示code和message
                }

                //alert(JSON.stringify(resp))//提示框：json对象转为字符串
            },
            /* 出现异常信息时 响应状态码为4xx 5xx  ：  弹出 出错状态码
            error:function (req,textStatus,err) {
                alert(req.status)
            }*/

        })
        return false;//返回值决定是否使用表单默认提交
    })

})