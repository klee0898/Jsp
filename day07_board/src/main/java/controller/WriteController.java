package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

@WebServlet("/write.do")
public class WriteController extends HttpServlet {	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 1. 파라미터(글제목, 저자, 내용) 수집(요청정보 수집)
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(writer);
		
		// 2. 수집된 내용을 처리하기 위한 모델(dao)을 선택
		BoardDAO dao = new BoardDAO();
		dao.write(writer, title, content);
		
		// 3. 응답할 뷰를 선택
		response.sendRedirect("list.do");
	}
}
