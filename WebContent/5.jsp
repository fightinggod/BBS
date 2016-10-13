<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 从MYSQL数据库中读取的数据： <hr>
<table border=1>
<tr><th>用户登录号</th><th>姓名</th><th>性别</th>
	<th>出生日期</th><th>兴趣爱好</th>
<%	
	String driveName="com.mysql.jdbc.Drive";//驱动程序对象
	String userName="root";//数据库用户名
	String userPasswd="";//数据库存取密码
	String dbName="bbs";//数据库名
	String tableName="userinfo";//数据库中的表
	String url="jdbc:mysql://localhost:3306/"+dbName;//连接数据库的URL
	
	Connection con=null; Statement s; ResultSet rs;//声明三类对象
	try
	{	Class.forName(driveName).newInstance();//加载JDBC驱动程序
	}catch(ClassNotFoundException e)
	{System.out.print("Error loading Driver,不能加载驱动程序!");	}
	try
	{	con=DriverManager.getConnection(url,userName,userPasswd);//连接数据库	
	}catch(SQLException er)
	{System.out.print("Error getConnection,不能连接数据库！");}
	try{	
	 s=con.createStatement();//创建Statement类的对象
	String sql="SELECT * FROM"+tableName;//定义查询语句
	rs=s.executeQuery(sql);//执行查询，得到结果
	while(rs.next())
	{	out.println("<tr>");
	    out.println("<td>"+rs.getString("UserId")+"</td>");
	    out.println("<td>"+rs.getString("Name")+"</td>");
	    out.println("<td>"+rs.getString("Sex")+"</td>");
	    out.println("<td>"+rs.getString("BirthDay")+"</td>");
	    out.println("<td>"+rs.getString("Interest")+"</td>");
	    out.println("</tr>");
	}
	rs.close();s.close();con.close();
}catch(SQLException er){System.out.print("Error exectuteQuery,不能执行查询语言！");}
%>
</table>
</body>
</html>