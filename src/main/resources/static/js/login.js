



$(function() {
    //处理登录
    $("#login-submit").submit(function () {
        var email = $("#inputEmail").val();
        var password = $("#inputPassword").val();
        var data = {
            "email": email,
            "password": password,
        };
        url = "login.do";
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: function (data) {
                var res = JSON.parse(data);
                if (res.status == 200) {
                    window.location.href="/index"
                } else {
                    alert("用户名或密码错误")
                }
            }
        });
        return false;

    });


    //处理注册
    $("#register-submit").submit(function(){
        var email=$("#email").val();
        var password=$("#password").val();
        var username=$("#username").val();
        var validateCode=$("#valicate-code").val();
        console.log(validateCode);
        var data = {
            "email": email,
            "password":password,
            "username":username,
            "validateCode":validateCode,
        };
        url = "register.do";
        $.ajax({
            type:"POST",
            url:url,
            data:data,
            success:function(data){
                var res=JSON.parse(data);
                if(res.status==200){
                    window.location.href="/index"
                }else{
                    alert(res.msg);
                }
            }
        });
        return false;

    });//处理注册 End


});

