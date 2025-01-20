package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장 폴더
		String savePath = "/uploadedFile";
		
		// 실제 물리적인 서버의 저장폴더 경로 구하기
		String realPath = request.getServletContext().getRealPath(savePath);
		System.out.println(realPath);
		
		// 크기제한 
		int maxSize = 1024*1024*10; // 1kb x 1kb = 1MB x 10 = 10MB
		
		// 파일명 중복시 rename해서 저장시켜주는 클래스
		DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();
		
		// 첨부파일 저장, 일반텍스트 등을 수집하는 객체
		MultipartRequest mr 
			= new MultipartRequest(request, realPath, maxSize, "utf-8", dfrp);
		
		String title = mr.getParameter("title");
		File file = mr.getFile("image");
		
		String fileName = "";
		
		if(file != null) {
			fileName = file.getName(); // 첨부 파일명을 가져오기
		}
		
		request.setAttribute("title", title);
		request.setAttribute("fileName", fileName);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
}
