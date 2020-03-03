package com.biz.craw.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.craw.domain.NaverMovieVO;

public interface NaverDao {
	
	
	@Select("SELECT * FROM tbl_movie")
	public List<NaverMovieVO> selectAll();
	
	
	public int insertAll(List<NaverMovieVO> mList);
	public int insert(NaverMovieVO mVO);
	
	
	@Delete("DELETE FROM tbl_movie")
	public void deleteAll();

}
