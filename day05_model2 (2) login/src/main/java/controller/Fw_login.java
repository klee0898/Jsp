package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDTO;

@WebServlet("/fwLogin.do")
public class Fw_login extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");
		
		System.out.println(uid + "," + pw);
		
		UserDTO dto = new UserDTO(uid, pw);
		request.setAttribute("user", dto);
		
		// id : test, pw:1212 인증성공
		if(uid.equals("test") && pw.equals("1212")){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else{
			// 인증 실패시 로그인페이지로 이동
			response.sendRedirect("login/main.jsp");
		}
	}

}
