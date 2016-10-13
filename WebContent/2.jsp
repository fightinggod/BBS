<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>  
<%@ page import="java.sql.*"%>  
<%@ page import="com.tyut.bean.DBBean"%>  
<%@ page import="com.tyut.bean.UserBean"%>  
  
<jsp:useBean id="myDBbean" class="com.tyut.bean.DBBean"></jsp:useBean>  
  
<jsp:useBean id="user" class="com.tyut.bean.UserBean" scope="session"></jsp:useBean>  
<jsp:setProperty name="user" property="*" />  
  
<html>  
  <head>  
    <title>用户登录验证</title>  
  </head>  
    
  <body>  
    <h2>用户登录验证</h2>  
    <hr>  
    <%  
        //user对象中的userName和userPWD是通过自省完成赋值的  
        String userName = user.getUserName();  
        String userPwd = user.getUserPwd();  
        String sql = "select * from user where userName='"+userName+"' and userPwd='"+userPwd+"'";  
        if (user.isLogined()){  
            out.println("您已经登录过了!");  
        }else{  
            ResultSet rs = myDBbean.query(sql);  
            if (rs.next()){  
                user.setLogined(true);  
                out.println("恭喜您登录成功!");  
            }else{  
                user.setLogined(false);  
                out.println("对不起，您的帐号或密码不正确!");  
            }                     
        }                 
    %>  
  </body>  
</html>  