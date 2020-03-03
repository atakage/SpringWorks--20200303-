package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.ReadBookVO;

public interface ReadBookDao {
	
	
	
	public List<ReadBookVO> selectAll();

	
	public List<ReadBookVO> findByBCode(String rb_code);

	public ReadBookVO findBySeq(long rb_seq);
	
	public int insert(ReadBookVO readBookVO);

	@UpdateProvider(type=ReadBookSQL.class, method="update_sql")
	public int update(ReadBookVO rBookVO);


	@Delete("DELETE FROM tbl_read_book WHERE rb_seq = #{longRb_seq}")
	public int delete(long longRb_seq);
}
