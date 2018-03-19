package com.todo.app.info;

import com.todo.app.entity.ToDo;

public class ToDoDto {
	private String id;

    private String name;

    private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static ToDo toTodoList(ToDoDto todoList) {
		ToDo doList = new ToDo();
		doList.setStatus("PENDING");
		doList.setName(todoList.getName());
		return doList;
	}
}
