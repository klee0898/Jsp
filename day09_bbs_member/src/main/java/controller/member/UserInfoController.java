package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/userInfo.do")
public class UserInfoController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정할 회원번호 수집
		int uno = Integer.parseInt(request.getParameter("uno"));
		
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.userInfo(uno);
		
		System.out.println(dto);
		
		// 프리젠테이션 로직(View)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>                                                                                           ");
		out.print("<html>                                                                                                    ");
		out.print("<head>                                                                                                    ");
		out.print("<meta charset='UTF-8'>                                                                                    ");
		out.print("<title>Insert title here</title>                                                                          ");
		out.print("  <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>  ");
		out.print("</head>                                                                                                   ");
		out.print("<body>                                                                                                    ");
		out.print("	<div class='container'>                                                                                  ");
		out.print("		<form class ='border w-50 rounded p-5 mx-auto shadow mb-5 mt-5' action='update.do' method='get'>     ");
		out.print("			<h3 class='text-center'>회원정보</h3>                                                            ");
		out.print("			<table class='mt-3 w-100'>	                                                                     ");
		out.print("			<input type='hidden' name='uno' value='"+dto.getUno()+"'/>		                                                                     ");
		out.print("				<thead>                                                                                      ");
		out.print("					<tr>                                                                                     ");
		out.print("						<th colspan='2'>"+dto.getName()+"님 회원정보</th>                                                     ");
		out.print("					</tr>                                                                                    ");
		out.print("				</thead>		                                                                             ");
		out.print("				<tbody>                                                                                      ");
		out.print("					<tr>                                                                                     ");
		out.print("						<td>회원번호 </td>                                                                   ");
		out.print("						<td>"+dto.getUno()+"</td>                                                                            ");
		out.print("					</tr>                                                                                    ");
		out.print("					<tr>                                                                                     ");
		out.print("						<td>아이디</td>                                                                      ");
		out.print("						<td>"+dto.getId()+"</td>                                                                            ");
		out.print("					</tr>                                                                                    ");
		out.print("					<tr>                                                                                     ");
		out.print("						<td>이름</td>                                                                        ");
		out.print("						<td>"+dto.getName()+"</td>                                                                            ");
		out.print("					</tr>                                                                                    ");
		out.print("					<tr>                                                                                     ");
		out.print("						<td>이메일</td>                                                                      ");
		out.print("						<td><input class='ms-2 form-control mb-2' type='text' name='email' value='"+dto.getEmail()+"'/></td>            ");
		out.print("					</tr>                                                                                    ");
		out.print("					<tr>                                                                                     ");
		out.print("						<td>나이</td>                                                                        ");
		out.print("						<td><input class='ms-2 form-control mb-2' type='text' name='age' value='"+dto.getAge()+"'/></td>              ");
		out.print("					</tr>                                                                                    ");
		out.print("					<tr>                                                                                     ");
		out.print("						<td>전화번호</td>                                                                    ");
		out.print("						<td><input class='ms-2 form-control mb-2' type='text' name='tel' size='3' value='"+dto.getTel()+"'/></td>     ");
		out.print("					</tr>                                                                                    ");
		out.print("				</tbody>                                                                                     ");
		out.print("			</table>                                                                                         ");
		out.print("			<div class='mt-5 text-center'>				                                                     ");
		out.print("				<input type='submit' class='btn btn-primary' value='수정하기'>                               ");
		out.print("				<input type='reset' class='btn btn-secondary' value='취소'>                                  ");
		out.print("				<a href='/day03/list.do' class='btn btn-info'>리스트</a>                                                   ");
		out.print("			</div>                                                                                           ");
		out.print("		</form>                                                                                              ");
		out.print("	</div>                                                                                                   ");
		out.print("</body>                                                                                                   ");
		out.print("</html>                                                                                                   ");
	}                                                                                                                        

}
