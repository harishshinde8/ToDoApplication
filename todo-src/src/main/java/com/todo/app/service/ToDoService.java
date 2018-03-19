package com.todo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.app.entity.ToDo;
import com.todo.app.info.ToDoDto;
import com.todo.app.repo.ToDoRepository;

@Service
@Transactional
public class ToDoService {
	
	    @Autowired
	    private ToDoRepository todoListRepository;

	    private static List<ToDo> todos = new ArrayList<>();

	    static {
	    	todos.add(new ToDo("Lunch","PENDING"));
	    	todos.add(new ToDo("Dinner","COMPLETE"));
	    	todos.add(new ToDo("Medicines","PENDING"));
	    	todos.add(new ToDo("Drop to school","PENDING"));
	    	todos.add(new ToDo("Appointment","PENDING"));
	    	todos.add(new ToDo("Meeting","PENDING"));
	    }
	    public void saveInitialBatch(){
	        todoListRepository.save(todos);
	    }
	    
	    public List<ToDo> findPendingList(){
	        return todoListRepository.findAll()
	        		.stream()
	        		.filter(todo -> todo.getStatus().equals("PENDING"))
	        		.collect(Collectors.toList());
	    }

	    public List<ToDo> findAll(){
	        return todoListRepository.findAll();
	    }

		public List<ToDo> updateProduct(ToDoDto todoList) {
			ToDo todo = todoListRepository.findOne(todoList.getId());
			todo.setStatus("COMPLETE");
			todoListRepository.save(todo);
			return findAll();
		}

		public List<ToDo> delete(String id) {
			todoListRepository.delete(id);
			return findAll();
		}

		public List<ToDo> save(ToDoDto todoList) {
			todoListRepository.save(ToDoDto.toTodoList(todoList));
			return findAll();
		}

		public List<ToDo> findCompleteList() {
			return todoListRepository.findAll()
	        		.stream()
	        		.filter(todo -> todo.getStatus().equals("COMPLETE"))
	        		.collect(Collectors.toList());
		}
}
