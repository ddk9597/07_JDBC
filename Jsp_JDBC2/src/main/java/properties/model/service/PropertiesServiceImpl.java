package properties.model.service;
import static properties.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Property;

import properties.model.dao.PropertiesDAO;
import properties.model.dao.PropertiesDAOImpl;
import properties.model.dto.Prop;

public class PropertiesServiceImpl implements PropertiesService{

	// DAO 객체 생성
	private PropertiesDAO dao = null;
	
	public PropertiesServiceImpl() {
		dao = new PropertiesDAOImpl();
	}
	
	// 옵션 값 얻어오기 + 옵션에 맞는 매물 조회
	@Override
	public Map<String, Object> optCheck(String[] locations, String categories, int minPy, int maxPy)  throws Exception {
		
		// 결과값 저장할 map 설정
		Map<String, Object> resultMap = new HashMap<>();
		
		// 커넥션 얻어오기
        Connection conn = getConnection();
		
		try {
	        // locations 값 리스트로 저장하기
	        List<String> locationList = new ArrayList<>();
	        for(String location : locations) {
	            locationList.add(location);
	        }

	        // dao 메서드 호출 후 결과 반환
	        List<Prop> properties = dao.getOptSearch(conn, locations, categories, minPy, maxPy);

	        // 결과를 resultMap에 추가
	        resultMap.put("properties", properties);

	    } catch (SQLException e) {
	        // SQLException 처리
	        e.printStackTrace();
	    } finally {
	    	close(conn);
	    }
		
	    return resultMap;
	}
	
	// 관리자 로그인하기
	@Override
	public int adminLogin(String id, String pw) throws Exception {
		
		// conn
		Connection conn = getConnection();
		
		// 결과값 저장할 변수 선언
		int result = dao.adminLogin(conn, id, pw);
		
		// 트랜잭션 제어
		if(result > 0) commit(conn);
		else rollback(conn);
		
		// 
		close(conn);
		
		
		return result;
	}
	
	// 매물 확인 요청하기
	@Override
	public int reqCs(String csName, String plan, String csPh, String csMemo) throws Exception {
		
		// 1. conn
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환
				int result = dao.reqCs(conn, csName, plan, csPh, csMemo);
				
		// 3. 트랜잭션 제어
		if(result > 0 ) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
		
		
		
	
}
