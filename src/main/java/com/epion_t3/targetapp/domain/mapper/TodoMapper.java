package com.epion_t3.targetapp.domain.mapper;

import java.util.List;

import com.epion_t3.targetapp.domain.model.TodoModel;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TodoMapper {

	List<TodoModel> selectAll();
	
	List<TodoModel> selectKeyValue(String key, String value);
}
