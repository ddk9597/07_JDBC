package Properties.model.service;

import static Properties.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import Properties.model.dao.PropertiesDAO;
import Properties.model.dao.PropertiesDAOImpl;

public class PropertiesServiceImpl implements PropertiesService{
	
	// DAO 객체 생성
	private PropertiesDAO dao = null;
	
	public PropertiesServiceImpl() {
		dao = new PropertiesDAOImpl();
	}

	// 선택한 조건에 맞는 매물 목록 조회
	 @Override
	public Map<String, Object> selectProp() throws SQLException {
		 
		 // 1 커넥션 얻어오기
		 Connection conn = getConnection();
		 
		 // 2. 매물 목록 조회 DAO 메서드 호출 후 결과 반환
		 List<Properties> selectProp = dao.selectProp(conn, null, null, 0);
		 
		 // 3. close conn
		 close(conn);
		 
		 // 4. Map 생성 후 매물 목록 묶어서 반환
		 
		 
		 
		 
		return null;
	}
	
	
}
