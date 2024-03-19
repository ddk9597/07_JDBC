package properties.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import properties.model.dto.Prop;

public interface PropertiesDAO {

	/** 옵션에 맞는 결과 조회
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<Prop> getOptSearch(Connection conn, String[] locations, String categories, int minPy, int maxPy) throws Exception;

	/** 관리자 로그인
	 * @param conn
	 * @param id
	 * @param pw
	 * @return
	 */
	int adminLogin(Connection conn, String id, String pw) throws Exception;

	/** 매물 확인 요청하기
	 * @param conn
	 * @param csName
	 * @param plan
	 * @param csPh
	 * @return
	 * @throws SQLException 
	 */
	int reqCs(Connection conn, String csName, String plan, String csPh, String csMemo) throws Exception;
	
	
	
}
