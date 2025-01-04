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

@WebServlet("/list.do")
public class ListController extends HttpServlet {	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 모델의 메소드 선택
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.list();
		
		System.out.println(list);
		// list() 리턴값 list를 뷰에 전달(객체 바인딩)
		request.setAttribute("list", list);
		
		// 뷰선택
		RequestDispatcher rd = request.getRequestDispatcher("board/list.jsp");
		rd.forward(request, response);
	}
}
