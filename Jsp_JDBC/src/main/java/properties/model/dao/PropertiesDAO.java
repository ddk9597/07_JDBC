package properties.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import properties.model.dto.Properties;

public interface PropertiesDAO {

	/** 옵션에 맞는 결과 조회
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<Properties> getOptSearch(Connection conn, String[] locations, String categories, int minPy, int maxPy) throws SQLException;
	
}
