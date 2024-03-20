package properties.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import properties.model.service.PropertiesService;
import properties.model.service.PropertiesServiceImpl;

// 관리자 로그인
@WebServlet("/adminLogin")
public class AdminLogInServlet extends HttpServlet{
	
	// 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		// 서비스 객체 생성
		PropertiesService service = new PropertiesServiceImpl();
		
		// 사용자가 제출한 ID와 비밀번호를 가져옴
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        
        try {
			int result = service.adminLogin(id, pw);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        
	}

}
