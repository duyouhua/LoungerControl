package com.LRKZ.Servlet;
/**
 * 此servlet实现日志更新
 * */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.LRKZ.Info.Updatelog_info;
import com.LRKZ.Service.LRKZ_service;

public class Log_Alter2 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Log_Alter2() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		LRKZ_service lrkz_service=new LRKZ_service();
		Updatelog_info updatelog_info=new Updatelog_info();
		updatelog_info.setSid(request.getParameter("sid"));
        updatelog_info.setAppid(request.getParameter("appid"));
        updatelog_info.setSdate(request.getParameter("sdate"));
        updatelog_info.setSintro(request.getParameter("sintro"));
        System.out.println("advice="+request.getParameter("sintro"));
        updatelog_info.setSdetail(request.getParameter("sdetail"));
        System.out.println("advice="+request.getParameter("sdetail"));
		if (lrkz_service.Alter_log(updatelog_info).equals("ok")) {
			response.sendRedirect("message1.jsp");
		}else {
			response.sendRedirect("message2.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
