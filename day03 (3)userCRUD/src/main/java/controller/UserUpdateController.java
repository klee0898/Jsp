package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/update.do")
public class UserUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정할 회원번호 수집
		int uno = Integer.parseInt(request.getParameter("uno"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		// dto로 묶기
		UserDTO dto = new UserDTO();
		dto.setUno(uno);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setTel(tel);
				
		UserDAO dao = new UserDAO();
		int n = dao.userUpdate(dto);
		
		if(n>0) {
			System.out.println("수정 완료!!");
			// 재요청
			response.sendRedirect("/day03/list.do");
		}else {
			System.out.println("수정 실패!!");
		}
		
	}                                                                                                                        

}
