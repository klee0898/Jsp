package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;

@WebServlet("/sc.do")
public class ScoreController extends HttpServlet {
	// request, response 클라이언트의 모든 정보(요청정보, ip, port번호, ...)를 갖고 있는 매개변수
	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
									throws ServletException, IOException {
		// 1. 클라이언트가 입력한 국영수 점수를 얻어오기
		int kor =Integer.parseInt(request.getParameter("kor"));
		int eng =Integer.parseInt(request.getParameter("eng"));
		int mat =Integer.parseInt(request.getParameter("mat"));
		
		// 2. 평균 총점 구하기(비즈니스 로직)
		Score score = new Score(kor, eng, mat);
		int total = score.getTotal();
		
		System.out.println(total);
		
		String strAvg = score.avg();
		System.out.println(strAvg);
		
		// 3. 프리젠테이션 로직: View(클라이언트에 응답)
		response.setContentType("text/html; charset=utf-8");
		// 출력스트림
		PrintWriter out = response.getWriter();		
		out.print("총점 : " + total + "<br/>");
		out.print("평균 : " + strAvg);
	}

}
