package com.biz.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.todo.domain.ToDoList;


//mybatis 3.4ㅂ터 mapper.xml을 사용하지 않는 새로운 형식이 등장, @Select, @Insert, @Update, @Delete
// Annotation을 interface에 설정하므로서 mapper.xml을 사용하지 않는 새로운 방식의 코드가 등장(불안정)
public interface ToDoListDao {			 

	/*
	 * 
	 * 
	 * mybatis의 mapper를 대신하는 Annotation
	 * 
	 * 
	 */
	@Select("SELECT * FROM tbl_todolist")
	public List<ToDoList> selectAll();
	
	@InsertProvider(type=ToDoListSQL.class, method="insert_sql")
	public int insert(ToDoList todoList);

	
	/*
	 * mapper Annotation에는 문자열로 SQL문을 작성해야 하는데 SQL문이 복잡할 경우는 별도의 STring 문자열 변수를 불러옴
	 * 이때 SQL문을 작성하는 String 문자열 변수는 반드시 final static String 형식으로 작성해야 함
	 */
	@Update(ToDoListSQL.complete_sql)
	public int complete(@Param("td_seq")long td_seq);
	
	@UpdateProvider(type = ToDoListSQL.class, method="alaram_sql")	// ToDOListSQL 클래스에 정의된 alaram_sql method를 호출하여 동적 쿼리 가져와 UPDATE 수행
	public int alaram(@Param("td_seq") long tdSeq);
	
	@Delete("DELETE FROM tbl_todolist WHERE td_seq = #{td_seq}")
	public int delete(long td_seq);
	
	@UpdateProvider(type=ToDoListSQL.class, method="update_sql")
	public int update(ToDoList toDoList);

	@Select("SELECT * FROM tbl_todolist WHERE td_seq = #{td_seq}")
	public ToDoList findBySeq(long td_seq);

	@Select("SELECT * FROM tbl_todolist WHERE like '%' || #{td_subject} || '%' ")
	public List<ToDoList> findBySubject(String td_subject);
}
