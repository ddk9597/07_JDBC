package edu.kh.dept.model.service;

import java.sql.SQLException;
import java.util.List;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.exception.DepartmentDeleteException;
import edu.kh.dept.model.exception.DepartmentInsertException;

/**
 * 
 */
public interface DepartmentService {

	// 선언되는 메서드는 모두 public abstract (추상 메서드)
	
	
	/** 모든 부서 조회
	 * @return deptList(부서 목록)
	 * @throws SQLException
	 */
	List<Department> selectAll() throws SQLException;

	
	/** 부서 추가 서비스
	 * @param dept
	 * @return result(삽입된 행의 개수)
	 * @throws DepartmentInsertException
	 */
	int insertDepartment(Department dept) throws DepartmentInsertException;


	/** 여러 부서 추가
	 * @param deptList
	 * @return result(삽입된 행의 개수)
	 * @throws DepartmentInsertException
	 */
	int multiInsert(List<Department> deptList) throws DepartmentInsertException;
	
	
	/** 부서 삭제
	 * @param delDept
	 * @return result(삽입된 행의 개수)
	 * @throws DepartmentDeleteException
	 */
	int deleteDepartment(String deptId) throws SQLException;


	/** 부서 1행 조회
	 * @param deptId
	 * @return dept(부서 1행 데이터가 담긴 객체 반환)
	 * @throws SQLException
	 */
	Department selectOne(String deptId) throws SQLException;


	/** 조회된 부서 수정
	 * @param dept
	 * @return result
	 * @throws SQLException
	 */
	int updateDepartment(Department dept) throws SQLException;


	/** 부서 검색
	 * @param keyword
	 * @return dept
	 * @throws SQLException
	 */
	List<Department> searchDepartment(String keyword) throws SQLException;
	
}




