package edu.kh.todoList.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.todoList.model.dto.Todo;

public interface TodoDAO {

	// 할 일 목록 조회
	/**
	 * @param conn
	 * @return todoList
	 * @throws SQLException
	 */
	List<Todo> selectAll(Connection conn) throws SQLException;

	// 완료된 할 일 개수 조회
	/**
	 * @param conn
	 * @return completeCount
	 * @throws SQLException
	 */
	int getCompleteCount(Connection conn) throws SQLException;

}
