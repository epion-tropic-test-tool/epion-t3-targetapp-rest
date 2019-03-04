package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.service;

import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.model.Todo;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.mapper.TodoMapper;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.mapper.TodoModelMapper;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.model.TodoModel;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.model.TodoModelExample;

@Service
@Transactional
@Slf4j
public class TodoCrudService {
	
	@Autowired
	TodoModelMapper todoModelMapper;
	
	@Autowired
	TodoMapper todoMapper;
    
    /**
     * Todoの作成を行う.
     * 
     * @param todo
     */
    public Todo create(Todo todo) {
		
    	if (todo == null) {
    		return null;
    	}

    	String id = UUID.randomUUID().toString();
    	
    	todo.setId(id);
    	
    	TodoModel todoModel = changeToModel(todo);
    	
    	todoModelMapper.insert(todoModel);
    	
    	return todo;
    }
    
    /**
     * Todoの更新を行う.
     * 
     * @param todo
     */
    public Todo update(Todo todo) {
		
    	if (todo == null) {
    		return null;
    	}

    	TodoModel todoModel = changeToModel(todo);
    	
    	return (todoModelMapper.updateByPrimaryKey(todoModel) == 0) ? null : changeFromModel(todoModel);
    }
    
    /**
     * Todoの削除を行う.
     * 
     * @param todo
     */
    public Todo delete(String todoId) {
		
    	if (todoId == null) {
    		return null;
    	}
    	
    	TodoModel todoModel = todoModelMapper.selectByPrimaryKey(todoId);
    	
    	if (todoModel == null) {
    		return null;
    	}
    	
    	return (todoModelMapper.deleteByPrimaryKey(todoId) == 0) ? null : changeFromModel(todoModel);
    }
    
    /**
     * Todoの取得(1件)を行う.
     * 
     * @param todo
     */
    public Todo refer(String todoId) {
		
    	if (todoId == null) {
    		return null;
    	}
    	
    	TodoModel todoModel = todoModelMapper.selectByPrimaryKey(todoId);
    	
    	if (todoModel == null) {
    		return null;
    	}
    	
    	return changeFromModel(todoModel);
    }
    
    public List<Todo> search(String key, String value) {
    	
    	if (key == null) {
    		return null;
    	}
    	
    	List<Todo> todoList = new ArrayList<>();
    	
    	if (!key.equals("tags")) {
    		List<TodoModel> todoModelList = todoMapper.selectKeyValue(key, value);
    		for (TodoModel todoModel : todoModelList) {
    			todoList.add(changeFromModel(todoModel));
    		}
    	} else {
    		List<TodoModel> todoModelList = todoMapper.selectAll();
    		for (TodoModel todoModel : todoModelList) {
    			if (todoModel.getTags() != null) {
    				if (Arrays.asList(todoModel.getTags().split(",")).contains(value)) {
    					todoList.add(changeFromModel(todoModel));
    				}
    			}
    			
    		}
    	}
    	
    	return todoList;
    }
    
    private TodoModel changeToModel(Todo todo) {
    	// DB登録用のモデル生成
    	TodoModel todoModel = new TodoModel();
    	
    	todoModel.setId(todo.getId());
    	todoModel.setTitle(todo.getTitle());
    	todoModel.setDescription(todo.getDescription());
    	
    	if (todo.getStart() != null) {
    		todoModel.setStart(Date.from(todo.getStart().toInstant()));
    	}
    	
    	if (todo.getDue() != null) {
    		todoModel.setDue(Date.from(todo.getDue().toInstant()));
    	}
    	
    	if (todo.getActualStart() != null) {
    		todoModel.setActualstart(Date.from(todo.getActualStart().toInstant()));
    	}
    	
    	if (todo.getActualEnd() != null) {
    		todoModel.setActualend(Date.from(todo.getActualEnd().toInstant()));
    	}
    	
    	todoModel.setStatus(todo.getStatus());
    	todoModel.setPriority(todo.getPriority());
    	
    	if (todo.getTags() != null) {
    		todoModel.setTags(String.join(",", todo.getTags()));
    	}
    	
    	return todoModel;
    }
    
    private Todo changeFromModel(TodoModel todoModel) {
    	Todo todo = new Todo();
    	
    	todo.setId(todoModel.getId());
    	todo.setTitle(todoModel.getTitle());
    	todo.setDescription(todoModel.getDescription());
    	
    	if (todoModel.getStart() != null) {
    		todo.setStart(OffsetDateTime.ofInstant(todoModel.getStart().toInstant(), ZoneId.systemDefault()));
    	}
    	
    	if (todoModel.getDue() != null) {
    		todo.setDue(OffsetDateTime.ofInstant(todoModel.getDue().toInstant(), ZoneId.systemDefault()));
    	}
    	
    	if (todoModel.getActualstart() != null) {
    		todo.setActualStart(OffsetDateTime.ofInstant(todoModel.getActualstart().toInstant(), ZoneId.systemDefault()));
    	}
    	
    	if (todoModel.getActualend() != null) {
    		todo.setActualEnd(OffsetDateTime.ofInstant(todoModel.getActualend().toInstant(), ZoneId.systemDefault()));
    	}
    	
    	todo.setStatus(todoModel.getStatus());
    	todo.setPriority(todoModel.getPriority());
    	
    	if (todoModel.getTags() != null) {
    	    todo.setTags(Arrays.asList(todoModel.getTags().split(",")));
        }
    	return todo;
    }

}
