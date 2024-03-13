package deptReview.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/department/insert")
public class InsertServlet {
	
	@Override
	private void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// JSP로 요청 위임해서 부서 추가 화면 보여주기
		// JSP 파일 경로 : webapp 폴더 기준으로 작성
		String path = "/WEB-INF/views/insert.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
				
	
	}

}
