package com.biz.rbooks.repository;

import org.apache.ibatis.jdbc.SQL;

public class ReadBookSQL {
	
	
	/*
	 * 
	 * SQL문에 포함되는 변수들
	 * #{변수명} : 변수에 포함된 값을 주입
	 * 
	 * ${변수명}: 문자열로 만든 SQL을 주입하여 동적쿼리를 만들 때 사용
	 * 
	 */
	
	public String update_sql() {
		
		SQL sql = new SQL() {{
			
			UPDATE("tbl_read_book");
			WHERE ("rb_seq = #{rb_seq, jdbcType=VARCHAR}");
			SET("rb_bcode = #{rb_bcode, jdbcType=VARCHAR}, rb_date = #{rb_date, jdbcType=VARCHAR}, rb_stime = #{rb_stime, jdbcType=VARCHAR}," + 
				"rb_rtime = #{rb_rtime, jdbcType=VARCHAR}, rb_subject = #{rb_subject, jdbcType=VARCHAR}, tb_text = #{tb_text, jdbcType=VARCHAR}, rb_star = #{rb_star, jdbcType=VARCHAR}");
		}};
		
		return sql.toString();
	}

}
