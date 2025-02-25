package com.qst.francis.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.francis.dao.UserDao;
import com.qst.francis.impl.UserDaoImpl;
import com.qst.francis.pojo.User;

@WebServlet("/registerAction")
public class RegisterAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String loginpath = "login.jsp";
		
		PrintWriter out = resp.getWriter();
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUser_name(username);
		user.setUser_password(password);
		//user type need change!
		user.setUser_type_id(1);
		if(userDao.register(user)){
			out.print("<html><head><meta charset='utf-8'></head><body>注册成功，请重新登录<br>3秒之后跳转</body></html>");
			resp.setHeader("Refresh","3;URL=JSP/login.jsp");
		}
		else{
			out.print("<html><head><meta charset='utf-8'></head><body>注册失败，请重新注册<br>3秒之后跳转</body></html>");
			resp.setHeader("Refresh","3;URL=JSP/register.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
