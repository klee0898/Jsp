package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Move implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = (String)request.getAttribute("cmd");
		
		String viewPage = null;
		if(cmd.equals("/adminLogin.do")) {
			viewPage = "admin/ad_login.jsp";
			
		}
		return viewPage;
	}

}
