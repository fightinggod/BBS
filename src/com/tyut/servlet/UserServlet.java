 package com.tyut.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.tyut.dao.UserDao;

/**
 * Servlet implementation class userServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(request,response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理中文乱码，必须放在最前面
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		//sign用于区分链接类型，如：登录，推出，以及后期的用户增删改查
		String sign = request.getParameter("sign");
		//获取session对象
		HttpSession session = request.getSession();
		//登录
		UserDao ud = new UserDao();
		if("login".equals(sign)){
			String username = request.getParameter("username")==null?(String)session.getAttribute("username"):request.getParameter("username");
			String password = request.getParameter("password")==null?(String)session.getAttribute("password"):request.getParameter("password");
			
			boolean isE = ud.login(username, password);
			System.out.println(isE);
			//用户名正确
			if(isE){
				//向session中存入用户名和密码
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				//跳转到首页
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else{
				//用户错误
				session.invalidate();
				response.sendRedirect("login.jsp");
			}
		}else if("logout".equals(sign)){
			//退出
			//清空当前session内的值
			session.invalidate();
			//清空消息后，再次跳回到登录页
			response.sendRedirect("/bbs/login.jsp");
		}else if("userList".equals(sign)){
			List<User> userList= ud.getUserList();
			//if(userList!=null&&userList.size()>0){
			//request.setAttribute("size", userList.size());
			request.setAttribute("userList", userList);
			//}
			request.getRequestDispatcher("userList.jsp").forward(request, response);
				
		}else if("delete".equals(sign)){
			String id =request.getParameter("id");
			boolean a =ud.deleteUserById(id);
			if(a){
				request.getRequestDispatcher("UserServlet?sign=userList").forward(request, response);
				}
		}else if("reg".equals(sign)){
			
			String name =request.getParameter("name");
			String pwd =request.getParameter("pwd");
			if(name == null|| pwd == null){
				request.getRequestDispatcher("reg.jsp").forward(request, response);
			}else{ boolean b =ud.regUser(name,pwd);
			if(b){
				response.sendRedirect("login.jsp");
			}	}
			
		}else if("search".equals(sign)){
			
			String val= request.getParameter("val");
			if(val!=null&&!"".equals(sign)){
			List<User> userList=ud.getUserByVal(val);
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("userList.jsp").forward(request, response);
			}else{
				
				request.getRequestDispatcher("UserServlet?sign=userList").forward(request, response);
			}
		}else if("toEdit".equals(sign)){
			String id = request.getParameter("id");
			User user =ud.getUserById(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("userEdit.jsp").forward(request, response);
		}else if ("edit".equals(sign)){
			String id = request.getParameter("uid");
			//String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			 
			User user = new User(Integer.parseInt(id),null,pwd,0);
			boolean c = ud.editUserById(user);
			if(c){
				request.getRequestDispatcher("UserServlet?sign=userList").forward(request, response);
			}
		}
		}
	}
