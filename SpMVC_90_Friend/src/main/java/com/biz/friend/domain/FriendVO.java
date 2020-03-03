package com.biz.friend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FriendVO {

	
	private String fr_code;// VARCHAR(5) PRIMARY KEY,
	private String fr_name;// VARCHAR(20) NOT NULL,
	private int fr_number;// BIGINT NOT NULL,
	private String fr_address;// VARCHAR(100),
	private String fr_hobby;// VARCHAR(50),
	private String fr_relative;// VARCHAR(50)
	
}
