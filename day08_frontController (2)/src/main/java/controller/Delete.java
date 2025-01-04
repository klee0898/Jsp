package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

public class Delete implements BbsController{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 수집
		int bid =Integer.parseInt(request.getParameter("bid"));
		
		// 모델의 메소드 선택
		BoardDAO dao = new BoardDAO();
		dao.delete(bid);		
	}

	

}
