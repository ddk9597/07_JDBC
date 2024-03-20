package properties.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import properties.model.service.PropertiesServiceImpl;

@WebServlet("/option/select")
public class OptionSelectServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		try {
			
			// 서비스 객체 생성
			properties.model.service.PropertiesService service = 
					new PropertiesServiceImpl();
			
			// 체크된 값 얻어오기(파라미터 얻어오기)
			String[] locations = req.getParameterValues("location[]");
			String categories = req.getParameter("category");
			int minPy = Integer.parseInt(req.getParameter("minPy"));
	        int maxPy = Integer.parseInt(req.getParameter("maxPy"));
	        
	     // 로그로 출력하여 확인
	        System.out.println("Locations: " + Arrays.toString(locations));
	        System.out.println("Category: " + categories);
	        System.out.println("MinPy: " + minPy);
	        System.out.println("MaxPy: " + maxPy);
			
	        Map<String, Object> map = service.optCheck(locations, categories, minPy, maxPy);
	        
	        // 옵션 처리 결과를 세션에 저장
            HttpSession session = req.getSession();
            session.setAttribute("Properties", map);

            
            
	        
	        // result.jsp로 포워드
	        String path = "/WEB-INF/views/result.jsp";
	        req.getRequestDispatcher(path).forward(req, resp);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
