package properties.model.dao;
import static properties.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import properties.model.dto.Prop;

public class PropertiesDAOImpl implements PropertiesDAO{

	// JDBC 객체 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// Properties 객체 참조 변수 선언
	private Prop prop;
	private Properties utilProp;
	
	// 기본 생성자로 객체 생성 시
	// Properties 객체 생성 + xml 파일 내용 읽어오기
	public PropertiesDAOImpl() {
		
		try {
			Properties prop = new Properties();
			String path = PropertiesDAOImpl.class.getResource("/properties/sql/sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(path));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 옵션에 맞는 결과 반환
	@Override
	public List<Prop> getOptSearch(Connection conn, String[] locations, String categories, int minPy, int maxPy) throws Exception {
		
		// 결과 저장용 객체 생성
		List<Prop> optList = new ArrayList<Prop>();
		
		try {
			// IN 절에 들어갈 ?를 동적으로 생성
			String locationParams = Arrays.stream(locations)
			                               .map(location -> "?")
			                               .collect(Collectors.joining(", "));

			// IN 절을 SQL 쿼리에 추가
			String sql = "SELECT PORPERTIES_NO 매물번호, LOCATION_TITLE 법정동, PY AS \"면적(평)\", FLOOR 층수, " +
			             "PREMIUM 권리금, DEPOSIT \"보증금(만원)\", RENT \"월세(만원)\", ADMIN_COST \"관리비(만원)\" " +
			             "FROM TB_PROPERTIES " +
			             "WHERE LOCATION_TITLE IN (" + locationParams + ") " +
			             "AND CATEGORY = ? " +
			             "AND PY BETWEEN ? AND ?";


		        pstmt = conn.prepareStatement(sql);
		
		     // IN 절 파라미터 설정
		        int index = 1;
		        for (String location : locations) {
		            pstmt.setString(index++, location);
		        }

		        // 나머지 파라미터 설정
		        pstmt.setString(index++, categories);
		        pstmt.setInt(index++, minPy);
		        pstmt.setInt(index, maxPy);
		
		        rs = pstmt.executeQuery();

			
			// 조회 결과 한 행씩 접근
		        while (rs.next()) {
		            int propertiesNo = rs.getInt("매물번호");
		            String locationTitle = rs.getString("법정동");
		            int py = rs.getInt("면적(평)");
		            int floor = rs.getInt("층수");
		            int premium = rs.getInt("권리금");
		            int deposit = rs.getInt("보증금(만원)");
		            int rent = rs.getInt("월세(만원)");
		            int adminCost = rs.getInt("관리비(만원)");

		            Prop properties =
		            		new Prop(propertiesNo, locationTitle, py, locationTitle, premium, deposit, rent, adminCost);

	            // 리스트에 Property 객체 추가
	            optList.add(properties);
			}
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		
		return optList;
		
	}
	
	// 관리자 로그인
	@Override
	public int adminLogin(Connection conn, String id, String pw) throws Exception {
		
		int result = 0;
		
		try {
			String sql = utilProp.getProperty("adminLogin");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			result = pstmt.executeUpdate(sql);
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 매물 확인 요청하기
	@Override
	public int reqCs(Connection conn, String csName, String plan, String csPh, String csMemo) throws Exception{
		
		int result = 0;
		
		try {
			String sql = utilProp.getProperty("csReq");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, csName);
			pstmt.setString(2, plan);
			pstmt.setString(3, csPh);
			pstmt.setString(4, csMemo);
			
			
		} finally {
			
			close(pstmt);
		}
		
		return 0;
	}
	
}
