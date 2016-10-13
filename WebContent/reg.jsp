<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<link rel="stylesheet" href="css/stylemain.css" type="text/css" media="all" />
	<script type="text/javascript">
	function check(){
		if(pwd.value!==pwd1.value){
			alert("俩次密码不一致!");
		}else if (document.getElementById('name').value == ""||document.getElementById('pwd').value == ""||document.getElementById('pwd1').value == "") {
	        	alert("用户名或密码不能为空！");
	        	return false;
	    	}else if (document.getElementById('pwd').value.length<6){
	        	alert("密码不得少于六位!");
	        	return false;
	    	}else {

	        	return true;
	    	}	
		
		
	}
</script>
</head>
<body>
	<!-- Container -->
	<div id="container">
		<div class="shell">
			<!-- Main -->
			<div id="main">
				<div class="cl">&nbsp;</div>

				<!-- Content -->
				<div id="content">

					<!-- Box -->
					<div class="box">
						<!-- Box Head -->
						<div class="box-head">
							<h2 class="left">用户注册</h2>

						</div>
						<!-- End Box Head -->

						<!-- Table -->
						<p>
							<font color="#FFFFFF">用户注册</font>
						</p>
						<center>
						<form id="form1" name="form1" method="post" action="UserServlet?sign=reg" onsubmit="check()" >
							<table>
								<tr>
									<td><font color="#AD462D">用户名：</font></td>
									<td><input type="text" name="name" id="name" value="" />
										<input type="hidden" name="uid" value="" /></td>
								</tr>
								<tr>
									<td><font color="#AD462D">密码：</font></td>
									<td><input type="password" name="pwd" id="pwd" value="" />&nbsp;密码不得少于6位！</td>
								</tr>
								<tr>
									<td><font color="#AD462D">确认密码：</font></td>
									<td><input type="password" name="pwd1" id="pwd1" value=""/></td>
								</tr>
								<tr>
									<td colspan="2" align="center">
									<input type="submit" value="提交" /> 
									<input type="reset" value="重置" />
									</td>
								</tr>
							</table>
						</form>
						</center>
						<!-- Table -->
					</div>
					<!-- End Box -->
				</div>
				<!-- End Content -->


				<div class="cl">&nbsp;</div>
			</div>
			<!-- Main -->
		</div>
	</div>
	<!-- End Container -->

	<!-- Footer -->
	<div id="footer">
		<div class="shell">
			<span class="left">&copy; 2014</span> <span class="right"> 版本 2014V1.0 </span>
		</div>
	</div>
</body>
</html>