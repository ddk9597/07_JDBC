package Properties.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import Properties.model.service.PropertiesService;
import Properties.model.service.PropertiesServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/properties/select")
public class MainServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			PropertiesService service = new PropertiesServiceImpl();
			
			// 전달받은 파라미터 얻어오기
			// 여러개 전달된 경우 배열로 만들어 얻어오기
			String[] locationArr = req.getParameterValues("location" );
			String[] categoryArr = req.getParameterValues("category" );
			String[] pyArr = req.getParameterValues("py" );
			
			// 서비스 메서드 호출 후 결과 반환 받기
			List<Properties> optCheckList = new ArrayList<Properties>();
			
			HttpSession session = req.getSession();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.doPost(req, resp);
	}
	
}
