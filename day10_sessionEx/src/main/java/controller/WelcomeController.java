package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFormController
 */
@WebServlet("/")
public class WelcomeController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ServletContext application = getServletContext();
		
		//처음에 접속자수 0으로 셋팅
		int activeCnt = 0;
		// 기존접속작 
		if(application.getAttribute("activeCnt") != null) {
			activeCnt = (Integer)application.getAttribute("activeCnt");
		}
			
		String pg = "welcome.jsp";
		
		request.setAttribute("pg", pg);
		application.setAttribute("activeCnt", activeCnt);
		
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}
