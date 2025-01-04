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

@WebServlet("/wform.do")
public class WriteFormController extends HttpServlet {	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		
		// 뷰선택
		RequestDispatcher rd = request.getRequestDispatcher("board/write.jsp");
		rd.forward(request, response);
	}
}
