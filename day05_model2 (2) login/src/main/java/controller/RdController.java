package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;

@WebServlet("/rd.do")
public class RdController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sData = "Hello World!!";
		
		String userName = "kang";
		String age = "33";
	
		// sendRedirect는 request 공유안됨(바인딩 안됨)
//		MemberDTO dto = new MemberDTO();
//		dto.setUserName(userName);
//		dto.setAge(age);
//		
//		request.setAttribute("member", dto);
//		
//		response.sendRedirect("fr/redirect.jsp");
		
		response.sendRedirect("fr/redirect.jsp?data="+sData+"&userName="+userName+"&age="+age);
	
		}

}
