<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
  
<html>  
  <head>  
      
    <title>用户登录</title>  
    <script type="text/javascript">  
      //进行表单验证  
      function check(){  
       if(document.all.userName.value==""){  
        alert("对不起，用户名不能为空值!");  
       }  
       if(document.all.userPwd==""){  
        alert("对不起，密码不能为空值!")  
        return false;  
       }  
       return true;  
      }   
    </script>  
  </head>  
    
  <body>  
    <form action="2.jsp" name ="form1" method="post" sumbit="return check()">   
              登录账号:   
              <input type="text" id="userName" name ="userName"/><br/>  
              登录密码：  
              <input type="text" id="userPwd" name="userPwd" /><br/>  
              <input type="submit" name="submit" value="提交"/>  
              <input type="reset" name="reset" value="重设"/>  
    </form>  
  </body>  
</html>  