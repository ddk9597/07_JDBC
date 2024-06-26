package edu.kh.dept.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.service.DepartmentService;
import edu.kh.dept.model.service.DepartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/department/search")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// Service 객체 생성
			DepartmentService service = new DepartmentServiceImpl();
			
			// 제출된 파라미터 얻어오기
			String keyword = req.getParameter("keyword");
			
			// 서비스 메서드 호출 후 결과 반환 받기
			List<Department> deptList = service.searchDepartment(keyword);
			
			//forward할 JSP 경로
			String path = "/WEB-INF/views/search.jsp";
			
			// 조회 결과를 request scope 속성으로 세팅
			req.setAttribute("deptList", deptList);
			
			// 지정된 jsp로 요청 위임
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	
}
