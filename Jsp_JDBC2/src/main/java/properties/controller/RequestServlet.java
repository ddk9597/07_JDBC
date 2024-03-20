package properties.controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import properties.model.service.PropertiesService;
import properties.model.service.PropertiesServiceImpl;

@WebServlet("/prop/req")
public class RequestServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		try {
			
			// 서비스 객체 생성
			PropertiesService service = new PropertiesServiceImpl();
			String csName = req.getParameter("csName");
			String plan = req.getParameter("plan");
			String csPh = req.getParameter("csPh");
			String reqMemo = req.getParameter("reqMemo");
			
			// 로그로 잘 전달되었나 확인
			System.out.println("csName:" + csName);
			System.out.println("plan:" + plan);
			System.out.println("csPh :" +  csPh);
			System.out.println("reqMemo :" +  reqMemo);
			
			// 요청 전달
			int result = service.reqCs(csName, plan, csPh, reqMemo);
			
			String message = null;
			if(result > 0) message = "요청이 전달되었습니다";
			else		   message = "요청 전달이 실패했습니다";
			
			// 전달한 값을 세션에 저장
			HttpSession session = req.getSession();
            session.setAttribute("message", message);
            
            // 메세지를 담은 상태로 메인 페이지 재요청
            resp.sendRedirect("/");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
