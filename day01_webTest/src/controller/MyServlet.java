package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyUtil;

public class MyServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 비즈니스 로직
		MyUtil mu = new MyUtil();
		int sum = mu.add();
		
		// 프리젠테이션 로직
		// 출력스트림
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body> sum ->");
		out.print(sum);
		out.print("</body>");
		out.print("</html>");
	}
}
