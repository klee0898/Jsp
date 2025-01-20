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
@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//jsp application 겍체를 자바코드에서 생성 
		ServletContext application = getServletContext();
		// 자바에서  session 생성 = 만들때
		HttpSession session = request.getSession();	
		// session reset
		session.invalidate();
		int activeCnt = (Integer)application.getAttribute("activeCnt");
		
		if(activeCnt > 0)
			application.setAttribute("activeCnt", --activeCnt);
		
		response.sendRedirect("main.do");
	}

}
