package com.qst.francis.action.info;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qst.francis.dao.InfoDao;
import com.qst.francis.dao.InfoTypeDao;
import com.qst.francis.impl.InfoDaoImpl;
import com.qst.francis.pojo.Info;

@WebServlet("/queryByCondtionAction")
public class QueryByConditionAction extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String coninput = (String)req.getParameter("coninput");
		String condition = (String)req.getParameter("condition");
		String matchType = (String)req.getParameter("matchType");
		String startStr = req.getParameter("start");
		
		int step = 10;
		int start;
		if(startStr == null || startStr.equals("")){
			start = 0;
		}
		else{
			start = Integer.parseInt(startStr);
		}
		
		InfoDao infoDao = new InfoDaoImpl();
		int allcnt = infoDao.queryByConditionCnt(coninput, condition, matchType);
		start = (allcnt - start * step) > 0 ? start : start - 1;
		if(start < 0){
			start = 0;
		}
		String stateUrl = "coninput=" + coninput + "&condition=" + condition + "&matchType=" + matchType;
		List<Info> list = infoDao.queryByCondition(coninput, condition, matchType, start * step, step);
		req.setAttribute("queryConditionList", list);
		req.setAttribute("queryConditionAllCnt", allcnt);
		req.setAttribute("queryConditionStart", start);
		req.setAttribute("queryConditionStep", step);
		req.setAttribute("queryConditionStateUrl", stateUrl);
		req.getRequestDispatcher("JSP/searchAnswer.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
