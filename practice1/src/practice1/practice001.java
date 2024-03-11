package practice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class practice001 {

	public static void main(String[] args) {
		
		//1. jdbc 객체 참조 변수 선언
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs  = null;
		
		try {
			
			// 2. DriverManager 객체를 이용해서  Connection 생성하기
			//2-1. Oracle JDBC Driver 객체를 메모리에 적재
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2-2. DB 연결 정보를 이용해서 Connection 객체 생성
			String type = "jdbc:oracle:thin:@"; // 드라이버 종류
			String host = "localhost"; // DB 섭 ㅓ컴퓨터의 IP주소
			String port	= ":1521"; // DB 서버 컴퓨터의 DB프로그램 연결 번호
			String dbName = ":xe"; // DB이름
			String userName = "KH_KCH"; // 사용자 계정
			String pw = "KH1234"; // 계정 비밀번호
			
			conn = DriverManager.getConnection(type + host + port + dbName, userName, pw);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("검색할 급여 입력 : ");
			int input = sc.nextInt();
			System.out.println("--------------");
			
			String sql = "\r\n"
					+ "SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB j USING(JOB_CODE) "
					+ "WHERE SALARY >= " + input
					+ " ORDER BY SALARY DESC";
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5.Sql 수행 후 결과 반환 받기
			rs= stmt.executeQuery(sql);
			// select 실행 시 resultset반환받음
			
			// 6. ResultSet 객체를 1행 씩 접근하여 컬럼 값 얻어오기
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String jobName = rs.getString("job_name");
				
				System.out.printf("%s / %s / %d / %s \n", empId, empName, salary, jobName);
			}
			
			
		} catch (Exception e ) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
