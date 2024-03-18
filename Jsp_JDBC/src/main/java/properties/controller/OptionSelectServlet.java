package properties.controller;

import java.io.IOException;
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// 서비스 객체 생성
			properties.model.service.PropertiesService service = new PropertiesServiceImpl();
			
			// 체크된 값 얻어오기
			String[] locations = req.getParameterValues("location");
			String categories = req.getParameter("category");
			int minPy = Integer.parseInt(req.getParameter("minPy"));
	        int maxPy = Integer.parseInt(req.getParameter("maxPy"));
			
	        Map<String, Object> map = service.optCheck(locations, categories, minPy, maxPy);
	        
	        // 옵션 처리 결과를 세션에 저장
            HttpSession session = req.getSession();
            session.setAttribute("locations", locations);
            session.setAttribute("categories", categories);
            session.setAttribute("minPy", minPy);
            session.setAttribute("maxPy", maxPy);
	        
	        // result.jsp로 포워드
	        String path = "/WEB-INF/views/result.jsp";
	        req.getRequestDispatcher(path).forward(req, resp);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
