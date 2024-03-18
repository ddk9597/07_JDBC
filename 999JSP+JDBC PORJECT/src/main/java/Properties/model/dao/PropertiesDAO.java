package Properties.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public interface PropertiesDAO {

	/** 선택한 조건에 맞는 매물 목록 조회
	 * @param conn
	 * @return propList
	 * @throws SQLException
	 */
	List<Properties> selectProp(Connection conn, String LOCATION_TITLE, String CATEGORY, int PY ) throws SQLException;

}
