package deptReview.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

	/** 부서 전체 조회
	 * @param conn
	 * @return deptList
	 * @throws SQLException
	 */
	List<Department> selectAll(Connection conn) throws SQLException;
	
}
