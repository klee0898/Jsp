package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdLogin.do")
public class Rd_login extends HttpServlet {

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");
		
		// id : test, pw:1212 인증성공
		if(uid.equals("test") && pw.equals("1212")){
			// index.jsp(홈페이지) 재요청
			response.sendRedirect("/day05_model2/index.jsp?uid="+uid);
		}else{
			// 인증 실패시 로그인페이지로 이동
			response.sendRedirect("login/main.jsp");
		}
	}
}
