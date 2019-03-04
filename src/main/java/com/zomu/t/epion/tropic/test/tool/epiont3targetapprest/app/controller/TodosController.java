package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.model.Todo;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.service.TodoCrudService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "todos")
@Slf4j
public class TodosController {
	
	@Autowired
	TodoCrudService todoCrudService;

    @PostMapping
    public ResponseEntity<Todo> create(
            @RequestBody @Validated Todo todo) {
    	
    	Todo createTodo = todoCrudService.create(todo);
    	
        return new ResponseEntity<>(createTodo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Todo> update(
            @RequestBody @Validated Todo todo) {
    	
    	Todo updateTodo = todoCrudService.update(todo);
    	
    	if (updateTodo == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }
    
    @GetMapping("refer")
    public ResponseEntity<Todo> refer(
    		@RequestParam String todoId) {
    	
    	Todo todo = todoCrudService.refer(todoId);
    	
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
    
    @GetMapping("search")
    public ResponseEntity<List<Todo>> search(
    		@RequestParam String key, @RequestParam String value) {
    	
    	List<Todo> todoList = todoCrudService.search(key, value);
    	
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<Todo> delete(
            @RequestParam String todoId) {
    	
    	Todo deleteTodo = todoCrudService.delete(todoId);
    	
    	if (deleteTodo == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	
        return new ResponseEntity<>(deleteTodo, HttpStatus.OK);
    }

}
