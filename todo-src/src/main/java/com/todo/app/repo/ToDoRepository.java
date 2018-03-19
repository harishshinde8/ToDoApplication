package com.todo.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todo.app.entity.ToDo;


public interface ToDoRepository extends MongoRepository<ToDo, String> {

}
