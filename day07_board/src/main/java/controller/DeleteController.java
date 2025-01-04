package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardDTO;

@WebServlet("/delete.do")
public class DeleteController extends HttpServlet {	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 수집
		int bid =Integer.parseInt(request.getParameter("bid"));
		
		// 모델의 메소드 선택
		BoardDAO dao = new BoardDAO();
		dao.delete(bid);
		
		// 뷰선택
		response.sendRedirect("list.do");
	}
}
