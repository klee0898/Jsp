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

@WebServlet("/view.do")
public class ViewController extends HttpServlet {	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 수집
		int bid =Integer.parseInt(request.getParameter("bid"));
		
		// 모델의 메소드 선택
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.view(bid);
		
		// 바인딩
		request.setAttribute("dto", dto);
		
		// 뷰선택
		RequestDispatcher rd = request.getRequestDispatcher("board/view.jsp");
		rd.forward(request, response);
	}
}
