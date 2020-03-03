package com.biz.gallery.repository;

import org.apache.ibatis.jdbc.SQL;

public class ImageSQL {
	
	
	public String insert_sql() {
		
		
		return new SQL() {{
		
		INSERT_INTO("tbl_gallery");	
		
				INTO_COLUMNS("IMG_SEQ");
				INTO_COLUMNS("IMG_TITLE");
				INTO_COLUMNS("IMG_TEXT");
				INTO_COLUMNS("IMG_FILE");
		
		INTO_VALUES("#{img_seq, jdbcType=VARCHAR}");
		INTO_VALUES("#{img_title, jdbcType=VARCHAR}");
		INTO_VALUES("#{img_text, jdbcType=VARCHAR}");
		INTO_VALUES("#{img_file, jdbcType=VARCHAR}");
		}}.toString();
		
	}
	
	
	
	
	
public String update_sql() {
		
		
		return new SQL() {{
		
		UPDATE("tbl_gallery");	
		
				WHERE("img_seq = #{img_seq, jdbcType=VARCHAR}");
				SET("img_title = #{img_title, jdbcType=VARCHAR}");
				SET("img_text = #{img_text, jdbcType=VARCHAR}");
				SET("img_file = #{img_file, jdbcType=VARCHAR}");
		
		
		}}.toString();
		
	}

}
