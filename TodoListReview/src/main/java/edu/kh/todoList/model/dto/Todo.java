package edu.kh.todoList.model.dto;

public class Todo {

	private int todoNO; // 할 일 번호
	private String todoTitle; // 할 일 제목
	private String todoContent; // 할 일 내용
	private String complete; // 완료 여부
	private String regDate; // 할 일 등록일



	// 기본 생성자
	public Todo() {}
	
	
	// 매개변수 생성자(할 일 목록 조회용)
	public Todo(int todoNO, String todoTitle, String complete, String regDate) {
		super();
		this.todoNO = todoNO;
		this.todoTitle = todoTitle;
		this.complete = complete;
		this.regDate = regDate;
	}



	// getter setter
	public int getTodoNO() {
		return todoNO;
	}
	
	
	public void setTodoNO(int todoNO) {
		this.todoNO = todoNO;
	}
	
	
	public String getTodoTitle() {
		return todoTitle;
	}
	
	
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	
	
	public String getTodoContent() {
		return todoContent;
	}
	
	
	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}
	
	
	public String getComplete() {
		return complete;
	}
	
	
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	
	public String getRegDate() {
		return regDate;
	}
	
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}





