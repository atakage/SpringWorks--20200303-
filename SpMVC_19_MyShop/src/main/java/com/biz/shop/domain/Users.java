package com.biz.shop.domain;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;



/*
 * spring security에서 DB를 연동하여
 * login을 수행할 때
 * 사용자 정보를 저장할 table
 * 이 테이블의 enabled 컬럼이 false이면 해당 계정은 사용정지된 것으로 인식
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@javax.persistence.Entity
@Table(name="users", schema="emsDB")
public class Users {
	
	@Id
	private String username;
	private String password;
	private boolean enabled;
	
	
	
	
	
	

}
