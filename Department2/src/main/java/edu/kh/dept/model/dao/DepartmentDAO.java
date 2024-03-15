package edu.kh.dept.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.exception.DepartmentDeleteException;

public interface DepartmentDAO {

	/** 부서 전체 조회
	 * @param conn
	 * @return deptList
	 * @throws SQLException
	 */
	List<Department> selectAll(Connection conn) throws SQLException;

	
	/** 부서 추가
	 * @param conn
	 * @param dept
	 * @return result
	 * @throws SQLException
	 */
	int insertDepartment(Connection conn, Department dept) throws SQLException;

	
	/** 부서 삭제
	 * @param delDept
	 * @return delDept
	 * @throws DepartmentDeleteException
	 */
	int deleteDepartment(Connection conn, String deptId) throws SQLException;


	/** 부서 1행 조회
	 * @param conn
	 * @param deptId
	 * @return dept
	 * @throws
	 */
	Department selectOne(Connection conn, String deptId) throws SQLException;


	/** 조회된 부서 수정 
	 * @param conn
	 * @param dept
	 * @return result
	 * @throws SQLException
	 */
	int updateDepartment(Connection conn, Department dept) throws SQLException;


	/** 부서 검색
	 * @param conn
	 * @param keyword
	 * @return deptlist(조회 결과 없으면 비어있음, null 아님)
	 * @throws SQLException
	 */
	List<Department> searchDeparment(Connection conn, String keyword) throws SQLException;
	
	
	
	


	
	
	
}
