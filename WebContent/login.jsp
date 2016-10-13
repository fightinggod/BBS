<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<script type="text/javascript">
	function check(){
		if (document.getElementById('username').value == ""||document.getElementById('password').value == "") {
        	alert("用户名密码不能为空！");
        	return false;
    	}
    	if (document.getElementById('password').value.length<6){
        	alert("密码不得少于六位！");
        	return false;
    	}
    	else {

        	return true;
    	}	
 	}</script>
<style type="text/css" media="all">@import"css/login.css";</style>
</head>

<body>
	<div id="box">
		<div id="head"></div>
		<div id="left"></div>
		<div id="middle">
			<form action="UserServlet?sign=login" name="login" method="post" >
				用户<input style="width: 120px;" id="username" name="username" type="text"  value=""  maxlength="16"/><br/><p/>
				密码<input style="width: 120px;" id="password" name="password" type="password"  value="" maxlength="16"/><p/>
				<input type="submit" name="button1" id="button1" value="登陆" onclick="check()"/>&nbsp;
 				<input type="reset" name="button2" id="button2" value="重置" />&nbsp;
 				<input type="button" name="button3" id="button3" value="注册" onclick="window.open('reg.jsp')"/>
			</form>
		</div>
		<div id="right"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
