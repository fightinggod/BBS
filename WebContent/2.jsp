<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>  
<%@ page import="java.sql.*"%>  
<%@ page import="com.tyut.bean.DBBean"%>  
<%@ page import="com.tyut.bean.UserBean"%>  
  
<jsp:useBean id="myDBbean" class="com.tyut.bean.DBBean"></jsp:useBean>  
  
<jsp:useBean id="user" class="com.tyut.bean.UserBean" scope="session"></jsp:useBean>  
<jsp:setProperty name="user" property="*" />  
  
<html>  
  <head>  
    <title>�û���¼��֤</title>  
  </head>  
    
  <body>  
    <h2>�û���¼��֤</h2>  
    <hr>  
    <%  
        //user�����е�userName��userPWD��ͨ����ʡ��ɸ�ֵ��  
        String userName = user.getUserName();  
        String userPwd = user.getUserPwd();  
        String sql = "select * from user where userName='"+userName+"' and userPwd='"+userPwd+"'";  
        if (user.isLogined()){  
            out.println("���Ѿ���¼����!");  
        }else{  
            ResultSet rs = myDBbean.query(sql);  
            if (rs.next()){  
                user.setLogined(true);  
                out.println("��ϲ����¼�ɹ�!");  
            }else{  
                user.setLogined(false);  
                out.println("�Բ��������ʺŻ����벻��ȷ!");  
            }                     
        }                 
    %>  
  </body>  
</html>  