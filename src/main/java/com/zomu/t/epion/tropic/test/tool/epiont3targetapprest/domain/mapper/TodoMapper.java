package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.model.TodoModel;

@Mapper
public interface TodoMapper {

	List<TodoModel> selectAll();
	
	List<TodoModel> selectKeyValue(String key, String value);
}
