package com.biz.friend.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.friend.domain.FriendVO;

public interface FriendDao {

	
	public String createCode();

	public int insert(FriendVO friendVO);

	
	@Select("SELECT * FROM tbl_friend")
	public List<FriendVO> selectAll();

	@Select("SELECT * FROM tbl_friend WHERE fr_code = #{fr_code}")
	public FriendVO selectByCode(String fr_code);

	public int update(FriendVO friendVO);

	public List<FriendVO> search(@Param("optionVal") String optionVal, @Param("searchVal") String searchVal);
	
	
	
}
