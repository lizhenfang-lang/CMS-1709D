<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>

<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/cms.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>cms后台登录</title>
</head>
<body>
<div class="container-fluid">
		<div class="col-4 offset-4 loginForm">
			<h3>欢迎使用CMS系统</h3>
			<form action="/admin/home">
			  <div class="form-group">
			    <input type="text" class="form-control" placeholder="请输入用户名...">
			    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			  </div>
			  <div class="form-group">
			    <!-- <label for="exampleInputPassword1">密码</label> -->
			    <input type="password" class="form-control"  placeholder="请输入用户名...">
			  </div>
			  <button type="submit" class="btn btn-primary">登录</button>
			  <!-- <label for="exampleInputPassword1">没有帐号，去<a href="/">注册</a></label> -->
			</form>
		</div>
	</div>
<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
</body>
</html>