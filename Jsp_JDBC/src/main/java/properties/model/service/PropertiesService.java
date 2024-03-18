package properties.model.service;

import java.util.Map;

public interface PropertiesService {

	/** 옵션 값 얻어오기 + 옵션에 맞는 매물 조회
	 * @param locations
	 * @param categories
	 * @param minPy
	 * @param maxPy
	 * @return
	 */
	Map<String, Object> optCheck(String[] locations, String categories, int minPy, int maxPy);

}
