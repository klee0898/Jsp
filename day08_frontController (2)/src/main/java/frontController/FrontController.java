package frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddReply;
import controller.BbsController;
import controller.Delete;
import controller.List;
import controller.ReplyView;
import controller.Update;
import controller.View;
import controller.Write;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
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
		
		BbsController controller = null;
		
		if(cmd.equals("/wForm.do")) {
			// 뷰선택
			RequestDispatcher rd = request.getRequestDispatcher("board/write.jsp");
			rd.forward(request, response);
			
		}else if(cmd.equals("/write.do")) {
			controller= new Write();
			controller.execute(request, response);
			
			response.sendRedirect("list.do");
		}else if(cmd.equals("/list.do")) {
			controller= new List();
			controller.execute(request, response);
			
			// 뷰선택
			RequestDispatcher rd = request.getRequestDispatcher("board/list.jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/view.do")) {
			controller= new View();
			controller.execute(request, response);
			
			// 뷰선택
			RequestDispatcher rd = request.getRequestDispatcher("board/view.jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/delete.do")) {
			controller= new Delete();
			controller.execute(request, response);
			
			// 뷰선택
			response.sendRedirect("list.do");
		}else if(cmd.equals("/update.do")) {
			controller= new Update();
			controller.execute(request, response);
			
			// 뷰선택
			response.sendRedirect("list.do");
		}else if(cmd.equals("/replyView.do")) {
			controller= new ReplyView();
			controller.execute(request, response);
			
			// 뷰선택
			RequestDispatcher rd = request.getRequestDispatcher("board/reply_form.jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/addReply.do")) {
			controller= new AddReply();
			controller.execute(request, response);
			
			// 뷰선택
			response.sendRedirect("list.do");
		}
	}

}
