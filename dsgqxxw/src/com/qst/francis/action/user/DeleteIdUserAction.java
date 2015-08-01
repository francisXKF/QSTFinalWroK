package com.qst.francis.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.IllegalFormatCodePointException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.francis.dao.UserDao;
import com.qst.francis.impl.UserDaoImpl;
import com.qst.francis.util.StringToInteger;

@WebServlet("/deleteIdUserAction")
public class DeleteIdUserAction extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		UserDao userDao = new UserDaoImpl();
		//delete user id
		String userid = (String)req.getParameter("userid");
		Integer user_id = new StringToInteger().change(userid);
		
		if(user_id == null){
			out.print("<html><head><meta charset='utf-8'><script>function error_fun(){alert(删除错误);}</script></head>"
					+ "<body onload='error_fun()'>请确保输入的为数字</body></html>");
			resp.sendRedirect("JSP/admin_operate_user.jsp");
		}
		else{
			if(userDao.deleteById(user_id)){
				String user_state_url = "";
				
				String enteruserid = (String)req.getParameter("enteruserid");
				String start = (String)req.getParameter("start");
				user_state_url = "enteruserid=" + enteruserid + "&start=" + start;
				req.getRequestDispatcher("queryIdUserAction?" + user_state_url).forward(req, resp);
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
