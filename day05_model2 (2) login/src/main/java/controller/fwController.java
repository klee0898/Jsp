package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;

@WebServlet("/fw.do")
public class fwController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String userName = "kang";
		String age = "33";
		String addr = "화곡동";
		
		MemberDTO dto = new MemberDTO(userName, age, addr);
		
		// 객체 바인딩
//		request.setAttribute(String name, Object obj);
		                     // 키,     값  
		request.setAttribute("member", dto);
		
		RequestDispatcher rd= request.getRequestDispatcher("fr/forward.jsp");
		rd.forward(request, response);
	}

}
