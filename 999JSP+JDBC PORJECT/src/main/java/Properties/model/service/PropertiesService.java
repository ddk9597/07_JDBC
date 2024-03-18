package Properties.model.service;

import java.sql.SQLException;
import java.util.Map;


public interface PropertiesService {

	/** 조건에 맞는 매물 조회
	 * @return map
	 * @throws SQLException
	 */
	Map<String, Object> selectProp() throws SQLException;

}
