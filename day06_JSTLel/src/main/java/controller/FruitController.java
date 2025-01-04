package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc.do")
public class FruitController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> lists = new ArrayList<>();
		lists.add("사과");
		lists.add("오렌지");
		
		
		request.setAttribute("lists", lists);
		RequestDispatcher rd = request.getRequestDispatcher("fruits.jsp");
		rd.forward(request, response);
	}

}
