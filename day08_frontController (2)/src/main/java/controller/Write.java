package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

public class Write implements BbsController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터(글제목, 저자, 내용) 수집(요청정보 수집)
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(writer);
		
		// 2. 수집된 내용을 처리하기 위한 모델(dao)을 선택
		BoardDAO dao = new BoardDAO();
		dao.write(writer, title, content);
	}

	

}
