package Properties.model.dao;


//지정된 위치의 static을 모두 가져와 사용
import static Properties.common.JDBCTemplate.*;

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
	
	private Properties prop;
	
	// 기본 생성자로 객체 생성 시
	// Properties 객체 생성 + xml 파일 내용 읽어오기
	
	public PropertiesDAOImpl() {
		
		try {
			prop = new Properties();
			String path = PropertiesDAOImpl.class.getResource("/Properties/sql/sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(path));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// 선택한 조건에 맞는 매물 조회
	@Override
	public List<Properties> selectProp
		(Connection conn, String LOCATION_TITLE, String CATEGORY, int PY )
		throws SQLException {
		
		// 결과 저장용 객체 생성
		List<Properties> propList = new ArrayList<Properties>();
		
		try {
			String sql = prop.getProperty("selectResult");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LOCATION_TITLE);
			pstmt.setString(2, CATEGORY);
			pstmt.setInt(3, PY);
			pstmt.setInt(4, PY);
		} finally{
			
		}
		
		return null;
	}
}
