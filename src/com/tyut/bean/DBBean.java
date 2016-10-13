package com.tyut.bean;
import java.sql.*;  

public class DBBean {  
  
    Connection con = null;  
    Statement stat = null;  
    PreparedStatement pstat = null;  
    ResultSet rs = null;  
  
    //�޲����Ĺ��캯��  
    public DBBean() {}  
      
    //ȡ�����ݿ�����  
    public Connection getCon(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            String url = "jdbc:mysql://localhost:3306/bbs?user=root&password=root&useUnicode=true&characterEncoding=utf-8";  
            con = DriverManager.getConnection(url);  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return con;       
    }  
      
    //ִ�����ݿ��ѯ�����ز�ѯ���  
    public ResultSet query(String sql){  
        try{  
            con = getCon();  
            stat = con.createStatement();  
            rs = stat.executeQuery(sql);  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return rs;  
    }  
      
    //ִ�����ݿ����  
    public void update(String sql){  
        try{  
            con = getCon();  
            stat = con.createStatement();  
            stat.executeUpdate(sql);  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
    }  
  
    //ִ�����ݿ����  
    public void update(String sql,String[] args){  
        try{  
            con = getCon();  
            pstat = con.prepareStatement(sql);  
            for (int i=0;i<args.length;i++){  
                pstat.setString(i+1,args[i]);  
            }  
            pstat.executeUpdate();  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
    }  
      
    //�ر����ݿ�����  
    public void close(){  
        try{  
            if (rs != null)rs.close();  
            if (stat != null)stat.close();  
            if (pstat != null)pstat.close();  
            if (con != null)con.close();  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }         
    }     
      
} 