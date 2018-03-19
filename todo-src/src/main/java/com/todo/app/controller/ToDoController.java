package com.todo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.entity.ToDo;
import com.todo.app.info.ToDoDto;
import com.todo.app.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {
	 	@Autowired
	    private ToDoService todoListService;

	    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	    public List<ToDo> getToDoList() {
	        return todoListService.findAll();
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value ="/pending")
	    public List<ToDo> getToDoPendingList() {
	        return todoListService.findPendingList();
	    }
	    
	    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value ="/complete")
	    public List<ToDo> getToDoCompleteList() {
	        return todoListService.findCompleteList();
	    }
	    
	    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json", value ="/complete")
	    public List<ToDo> completedList(@RequestBody ToDoDto  todoList) {
	        return todoListService.updateProduct(todoList);
	    }
	    
	    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
	    public List<ToDo> deleteItem(@PathVariable("id") String ids) {
	    	return todoListService.delete(ids);
	    }
	    
	    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	    public List<ToDo> addItem(@RequestBody ToDoDto  todoList) {
	        return todoListService.save(todoList);
	    }
}
