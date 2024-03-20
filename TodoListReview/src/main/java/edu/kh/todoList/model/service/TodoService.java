package edu.kh.todoList.model.service;

import java.sql.SQLException;
import java.util.Map;

public interface TodoService {

	/** 할 일 목록 + ㅎ완료된 할 일 개수 조회
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object> selectAll() throws SQLException;

	
	
}
