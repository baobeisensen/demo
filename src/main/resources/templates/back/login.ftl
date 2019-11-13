<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
	<title>LarryCMS后台登录</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="/manage/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/manage/css/login.css" media="all">
</head>
<body>
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
	<h1>
		 <strong>LarryCMS123管理系统后台</strong>
		 <em>Management System</em>
	</h1>
	<form action="/back/login" class="layui-form" method="POST" >
		<div class="layui-user-icon larry-login">
			 <input type="text" placeholder="账号" class="login_txtbx" name="username"/>
		</div>
		<div class="layui-pwd-icon larry-login">
			 <input type="password" placeholder="密码" class="login_txtbx" name="password"/>
		</div>
		<div style="margin-left: 38%">
			<input type="checkbox" title="记住我" name="rememberMe" class="login_txtbx" lay-skin="primary" checked/>
		</div>

		<#--<div class="layui-val-icon larry-login">
			<div class="layui-code-box">
				<input type="text" id="code" name="code" placeholder="验证码" maxlength="4" class="login_txtbx">
				<img src="images/verifyimg.png" alt="" class="verifyImg" id="verifyImg" onClick="javascript:this.src='123'+Math.random();">
			</div>
		</div>-->
		<#--<div class="layui-submit larry-login">
			<input type="button" value="立即登陆" class="submit_btn"/>
		</div>-->
		<div class="layui-submit larry-login">
			<button lay-submit class="submit_btn">立即提交</button>
		</div>

	</form>
    <div class="layui-login-text">
    	<p>© 2016-2019 rain 版权所有</p>
        <p>鲁xxxxxx</p>
    </div>
</div>
<script type="text/javascript" src="/manage/common/layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="/manage/js/login.js"></script>
<script type="text/javascript" src="/manage/jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
$(function(){
	$(".layui-canvs").jParticle({
		background: "#141414",
		color: "#E6E6E6"
	});
	//登录链接测试，使用时可删除
	/*$(".submit_btn").click(function(){
	  location.href="index.html";
	});*/
});
</script>
</body>
</html>