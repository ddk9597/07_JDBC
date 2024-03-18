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
import properties.model.dto.Properties;

public class PropertiesServiceImpl implements PropertiesService{

	// DAO 객체 생성
	private PropertiesDAO dao = null;
	
	public PropertiesServiceImpl() {
		dao = new PropertiesDAOImpl();
	}
	
	// 옵션 값 얻어오기 + 옵션에 맞는 매물 조회
	@Override
	public Map<String, Object> optCheck(String[] locations, String categories, int minPy, int maxPy) {
		
		// 결과값 저장할 map 설정
		Map<String, Object> resultMap = new HashMap<>();
		
		try {
	        // 커넥션 얻어오기
	        Connection conn = getConnection();

	        // locations 값 리스트로 저장하기
	        List<String> locationList = new ArrayList<>();
	        for(String location : locations) {
	            locationList.add(location);
	        }

	        // dao 메서드 호출 후 결과 반환
	        List<Properties> properties = dao.getOptSearch(conn, locations, categories, maxPy, maxPy);

	        // 결과를 resultMap에 추가
	        resultMap.put("properties", properties);

	    } catch (SQLException e) {
	        // SQLException 처리
	        e.printStackTrace();
	    }

	    return resultMap;
	}
	
}
