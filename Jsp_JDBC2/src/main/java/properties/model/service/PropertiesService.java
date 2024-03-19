package properties.model.service;

import java.sql.SQLException;
import java.util.Map;

public interface PropertiesService {

	/** 옵션 값 얻어오기 + 옵션에 맞는 매물 조회
	 * @param locations
	 * @param categories
	 * @param minPy
	 * @param maxPy
	 * @return
	 */
	Map<String, Object> optCheck(String[] locations, String categories, int minPy, int maxPy) throws Exception ;

	
	
	/** 관리자 로그인하기
	 * @param id
	 * @param pw
	 * @return
	 * @throws SQLException 
	 * @throws Exception 
	 */
	int adminLogin(String id, String pw) throws SQLException, Exception;



	/** 매물 확인 요청하기
	 * @param csName
	 * @param plan
	 * @param csPh
	 * @return
	 * @throws SQLException 
	 */
	int reqCs(String csName, String plan, String csPh, String csMemo) throws Exception;




}
