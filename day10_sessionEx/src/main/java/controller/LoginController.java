package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginFormController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		// 로그인 성공 조건 : email, pwd 같으면 성공 
		boolean isLoginSuccess = email.equals(pwd);
		
		//jsp application 겍체를 자바코드에서 생성 
		ServletContext application = getServletContext();	
		
		// 자바에서  session 생성 = 만들때
		HttpSession session = request.getSession();	
		
		//로그인성공하면 session에 email  바인딩, 접속자수 증가
		if(isLoginSuccess) {
			// 새롭게 로그인이되 면 접속자 수 증가 
			incrementUserCount(application, session);
			session.setAttribute("email", email);
			
		}
		
		// queryString
		String queryString = isLoginSuccess ? "?pg=success.jsp":"?pg=login_form.jsp";
		/*
		 * String pg = "login_form.jsp";
		 * 
		 * request.setAttribute("pg", pg);
		 */
		
//		RequestDispatcher rd = request.getRequestDispatcher("main.jsp"+queryString);
//		rd.forward(request, response);
		
		response.sendRedirect("main.do" + queryString);
	}

	private void incrementUserCount(ServletContext application, HttpSession session) {
		int incrementVal = session.getAttribute("email") != null ?
				(Integer)application.getAttribute("activeCnt"):
		        (Integer)application.getAttribute("activeCnt")+1;
		
		application.setAttribute("activeCnt", incrementVal);
		
	}

}
