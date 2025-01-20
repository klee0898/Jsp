package frontController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;


//@WebServlet(urlPatterns = {"/", "*.do"})
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private ActionMapping actionMapping;
	
	@Override
	public void init() throws ServletException {
		actionMapping = new ActionMapping();
	}	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트 요청 URL 패턴 얻어오기
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String ctxPath = request.getContextPath();
		System.out.println("ctxPath : " + ctxPath);
		String cmd = uri.substring(ctxPath.length());
		
		
		System.out.println("cmd : " + cmd);
		request.setAttribute("cmd", cmd);
		
		// 해당 요청의 보조컨트롤러 객체를 맵에서 꺼내옴
		Controller controller = actionMapping.getController(cmd);
		String viewPage = controller.execute(request, response);
		
		RequestDispatcher rd = null;
		if(viewPage.indexOf(".do") != -1) { //.do 문자열이 포함된 경우
			response.sendRedirect(viewPage);
		}else { // .do 문자열이 포함되지 않은 경우
			rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
	}
}
