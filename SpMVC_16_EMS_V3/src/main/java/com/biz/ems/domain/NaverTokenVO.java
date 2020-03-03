package com.biz.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NaverTokenVO {
	
	
	// 네이버로부터 발급받은 Token
	private String access_token;//	string	삭제 때 필수	-	기 발급받은 접근 토큰으로 URL 인코딩을 적용한 값을 사용
	
	// (선택) 네이버에 token을 재발급 요청했을 때 받은 token
	private String refresh_token;//	string	갱신 때 필수	-	네이버 사용자 인증에 성공하고 발급받은 갱신 토큰(refresh token)
	
	
	
	// (선택) 오류가 발생했을 때
	private String error;//
	private String error_description;//
	
	
	
	private String token_type;//
	
	
	
	//유효 기간
	private int expires_in;//
	
	


	
	
}
