package properties.model.dao;
import static properties.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesDAOImpl implements PropertiesDAO{

	// JDBC 객체 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// Properties 객체 참조 변수 선언
	private Properties prop;
	
	// 기본 생성자로 객체 생성 시
	// Properties 객체 생성 + xml 파일 내용 읽어오기
	public PropertiesDAOImpl() {
		
		try {
			prop = new Properties();
			String path = PropertiesDAOImpl.class.getResource("/properties/sql/sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(path));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 옵션에 맞는 결과 반환
	@Override
	public List<properties.model.dto.Properties> getOptSearch(Connection conn, String[] locations, String categories, int minPy, int maxPy) throws SQLException {
		
		// 결과 저장용 객체 생성
		List<properties.model.dto.Properties> optList = new ArrayList<properties.model.dto.Properties>();
		
		try {
			String sql = prop.getProperty("optList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.join(",", locations));
			pstmt.setString(2, categories);
			pstmt.setInt(3, minPy);
			pstmt.setInt(4, maxPy);
			
			rs = pstmt.executeQuery();
			
			// 조회 결과 한 행씩 접근
			while(rs.next()) {

				int PORPERTIES_NO = rs.getInt("PORPERTIES_NO");
				String LOCATION_TITLE = rs.getString("LOCATION_TITLE");
				int PY = rs.getInt("PY");
				int FLOOR = rs.getInt("FLOOR");
				int PREMIUM = rs.getInt("PREMIUM");
				int DEPOSIT = rs.getInt("DEPOSIT");
				int RENT = rs.getInt("RENT");
				int ADMIN_COST = rs.getInt("ADMIN_COST");
				
				properties.model.dto.Properties properties = new properties.model.dto.Properties(PORPERTIES_NO, LOCATION_TITLE, categories, LOCATION_TITLE, PY, PREMIUM, DEPOSIT, RENT, ADMIN_COST);
				
	            // 리스트에 Property 객체 추가
	            optList.add(properties);
			}
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return optList;
		
	}
}
