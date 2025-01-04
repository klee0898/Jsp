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

@WebServlet("/update.do")
public class UpdateController extends HttpServlet {	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 수집
		int bid =Integer.parseInt(request.getParameter("bid"));
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 모델의 메소드 선택
		BoardDAO dao = new BoardDAO();
		dao.update(bid, writer, title, content);
		
		// 뷰선택
		response.sendRedirect("list.do");
	}
}
