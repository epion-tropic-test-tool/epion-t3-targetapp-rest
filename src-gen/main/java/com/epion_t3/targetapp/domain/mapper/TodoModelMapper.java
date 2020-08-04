package com.epion_t3.targetapp.domain.mapper;

import com.epion_t3.targetapp.domain.model.TodoModel;
import com.epion_t3.targetapp.domain.model.TodoModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TodoModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    long countByExample(TodoModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    int deleteByExample(TodoModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    int insert(TodoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    int insertSelective(TodoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    List<TodoModel> selectByExampleWithRowbounds(TodoModelExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    List<TodoModel> selectByExample(TodoModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    TodoModel selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    int updateByExampleSelective(@Param("record") TodoModel record, @Param("example") TodoModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    int updateByExample(@Param("record") TodoModel record, @Param("example") TodoModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    int updateByPrimaryKeySelective(TodoModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table todo
     *
     * @mbg.generated Wed Aug 05 00:52:59 JST 2020
     */
    int updateByPrimaryKey(TodoModel record);
}