package com.biz.ems.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.biz.ems.config.Naver;
import com.biz.ems.domain.NaverMember;
import com.biz.ems.domain.NaverMemberResponse;
import com.biz.ems.domain.NaverReturnAuth;
import com.biz.ems.domain.NaverTokenVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverLoginService {

	@Value("${naver.client.id}")
	private String clientId;
	
	@Value("${naver.client.secret}")
	private String clientSecret;
	private final String loginAPI_URL="https://nid.naver.com/oauth2.0/authorize";
	private final String tokenAPI_URL="https://nid.naver.com/oauth2.0/token";
	private final String naverMemberAPI_URL = "https://openapi.naver.com/v1/nid/me";
	
	private final String callbackURL = "https://callor.com:12600/ems_atakoko/member/naver/ok";
	public String oAuthLoginGet() {
		
		/*
		String redirectURI = null;
		
		try {
			
			
			
			redirectURI = URLEncoder.encode(callbackURL, "UTF-8");
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		SecureRandom random = new SecureRandom();
		String stateKey = new BigInteger(130, random).toString();	//130bit 크기의 최댓값 임의의 정수를 생성하여 문자열로 만들어라
		log.debug("STATE KEY:" + stateKey);
		
		
		/*
		 *  spring 4.1에서 사용하는 UriQuery 문자열을 생성하는 클래스
		 *  fromHttpUrl() : 요청을 수행할 server 주소
		 *  queryParam() : 변수 = 값 형태의 query 문자열 생성
		 *  builder(true) : 생성하는 문자열 중에 encoding이 필요한 부분이 있으면 encoding을 수행
		 *  
		 *  5.1 이상에서는 별도로 encoding() method가 있음
		 *  queryParam("name", "korea")&name=korea
		 *  queryParam("name", "korea", "usa") &name=korea&name=usa
		 */
		String apiURL = 
		UriComponentsBuilder.fromHttpUrl(loginAPI_URL).queryParam("client_id", this.clientId).queryParam("response_type", "code").queryParam("redirect_uri", callbackURL).queryParam("state", stateKey).build(true).toUriString();
		
//		
//		String apiURL = loginAPI_URL;
//		apiURL += "?client_id=" + clientId;
//		apiURL += "&response_type=code";
//		apiURL += "&redirect_uri=" + redirectURI;
//		apiURL += "&state=" + stateKey;
//		
		
		
		log.debug("URL:" + apiURL);
		
		return apiURL;
		
		
		
	}
	
	
	/*
	 * 네이버에 정보요규를 할 때 사용할 토큰을 요청
	 * 
	 * token을 요청할 때 GET/POST method를 사용할 수 있는데
	 * 
	 * 여기에서는 POST를 사용해 요청
	 * 
	 * */
	
	
	public NaverTokenVO oAuthAccessGetToken(NaverReturnAuth naverOK) {
		
	
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("X-Naver-Client-Id", this.clientId);
		headers.set("X-Naver-Client-Secret", this.clientSecret);
		
		
		/*
		 *  Map interface를 상속받아 작성된 springframework전용 Map interface
		 *  Http protocol과 관련된 곳에서 기본 Map대신 사용
		 *  Http protocol과 관련된 내장 method가 포함됨
		 */
		MultiValueMap<String, String> bodies = new LinkedMultiValueMap<String, String>();
		
		
		bodies.add(Naver.TOKEN.grant_type, Naver.GRANT_TYPE.authorization_code);
		bodies.add(Naver.TOKEN.client_id, this.clientId);
		bodies.add(Naver.TOKEN.client_secret, this.clientSecret);
		bodies.add(Naver.TOKEN.code, naverOK.getCode());
		bodies.add(Naver.TOKEN.state, naverOK.getState());
		
	
		
		
		// header에 담긴 정보와 params에 담긴 정보를 HttpEntity 데이터로 변환
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(bodies, headers);
		
		
		
		URI restURI = null;
		
		
		
		try {
			restURI = new URI(tokenAPI_URL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * RestTemplate를 사용하여 Naver에 Token을 요청
		 */
		RestTemplate restTemp = new RestTemplate();
		
		ResponseEntity<NaverTokenVO> result = null; 
		
		result = restTemp.exchange(restURI, HttpMethod.POST, request, NaverTokenVO.class);
		
		
		log.debug("네이버 토큰" + result.getBody().toString());
		
		
		return result.getBody();
	}
	
	
	public NaverMember getNaverMemberInfo(NaverTokenVO tokenVO) {
		
		
		
		String token = tokenVO.getAccess_token();
		String header = "bearer " + token;
		
		// header 문자열을 GET의 http header에 실어 GET 방식으로 요청
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Authorization", header);
		
		/*
		 *  body부분에 parameter라는 문자열을 추가하고 header부분에 위의 headers에서 설정한 형식으로 생성하고(Authorization = "bearer")
		 *  모두 문자열로 변환하여 Htpp Protocol의 데이터 구조로 변경
		 *  그리고 Http Protocol을 사용하여 데이터를 전송할 수 있도록 준비함
		 *  HttpEntity<String> 형식으로 선언하면 단일 생성 방식
		 *  
		 *  HttpEntity<MultiValue<String, Object>형식으로 선언하면 body부분에 데이터를 다음과 같이 생성
		 *  변수=[값], 변수=[값]
		 *  header부분의 데이터는 [변수:값, 변수:값}
		 */
		HttpEntity<String> request = new HttpEntity<String>("parameter", headers);
		
		
		log.debug("ENTITY:" + request.toString());
		
		ResponseEntity<NaverMemberResponse> result;
		RestTemplate restTemp = new RestTemplate();
		
		
		result = restTemp.exchange(naverMemberAPI_URL, HttpMethod.GET, request, NaverMemberResponse.class);
		
		
		NaverMember member = result.getBody().response;
		
		return member;
		
	}
	
}
