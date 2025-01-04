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

@WebServlet("/delete.do")
public class UserDeleteController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 삭제할 회원의 uno
		int uno = Integer.parseInt(request.getParameter("uno"));
		
		UserDAO dao = new UserDAO();
		int n = dao.deleteUser(uno);
		
		if(n > 0) {
			System.out.println("삭제완료!!");
			// 재요청
			response.sendRedirect("list.do");
		}else {
			System.out.println("삭제실패!!");
		}
	}

}
