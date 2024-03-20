package edu.kh.todoList.model.dao;
//지정된 위치의 static 모두 가져와 사용
import static edu.kh.todoList.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.todoList.model.dto.Todo;

// DAO : Data Access Object : DB에 접근하는 객체(SQL 수행, 결과 반환하기)
public class TodoDAOImpl implements TodoDAO{

	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// Properties 객체 참조 변수 선언
	private Properties prop ;
	
	// 기본 생성자로 객체 생성시
	// Properties 객체 생성 + xml 파일 내용 읽어오기
	public TodoDAOImpl() {
	    try {
	        prop = new Properties();
	        InputStream inputStream = TodoDAOImpl.class.getResourceAsStream("/edu/kh/todoList/sql/sql.xml");

	        if (inputStream != null) {
	            prop.loadFromXML(inputStream);
	        } else {
	            System.out.println("XML 파일을 찾을 수 없습니다.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	// 완료된 할 일 개수 조회
	@Override
	public int getCompleteCount(Connection conn) throws SQLException {
		int completeCount = 0;
		
		try {

			String sql = prop.getProperty("getCompleteCount");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// GROUPBY가 없는 SELECT의 COUNT 그룹 함수의 결과는 1행 
			// -> IF 문을 이용해서 조회 결과 행 접근
			
			if(rs.next()) {
				completeCount = rs.getInt(1); // 1번 컬럼 값
			}
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		return 0;
	}
	
	// 할 일 목록 조회
	@Override
	public List<Todo> selectAll(Connection conn) throws SQLException {
		// 결과 저장용 변수 선언 / 객체 생성
		
		List<Todo> todoList = new ArrayList<Todo>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			
			// SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			
			// 조회 결과 한 행씩 접근
			while(rs.next()) {
				int    todoNo = rs.getInt("TODO_NO");
				String todoTitle = rs.getString("TODO_TITLE");
				String complete = rs.getString("COMPLETE");
				String regDate = rs.getString("REG_DATE");
				
				// Todo 객체를 생성해서 값 세팅 후 todoList에 추가
				Todo todo = new Todo(todoNo, todoTitle, complete, regDate);
				todoList.add(todo);
			}
		} finally {
			close(stmt);
			close(conn);
			
		}
		
		return null;
	}
	
}
