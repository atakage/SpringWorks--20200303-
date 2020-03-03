package com.biz.ems.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.SecureRandom;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.biz.ems.config.Naver;
import com.biz.ems.domain.NaverMember;
import com.biz.ems.domain.NaverMemberResponse;
import com.biz.ems.domain.NaverReturnAuth;
import com.biz.ems.domain.NaverTokenVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverLoginService {

	
	private final String clientId = "gVbr27lpY9H1Km3XmiJ2";
	private final String clientSecret = "VhVmSNJiim";
	private final String loginAPI_URL="https://nid.naver.com/oauth2.0/authorize";
	private final String tokenAPI_URL="https://nid.naver.com/oauth2.0/token";
	private final String naverMemberAPI_URL = "https://openapi.naver.com/v1/nid/me";
	
	private final String callbackURL = "https://callor.com:12600/ems_atakoko/member/naver/ok";
	public String oAuthLoginGet() {
		
		String redirectURI = null;
		
		try {
			
			
			
			redirectURI = URLEncoder.encode(callbackURL, "UTF-8");
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		SecureRandom random = new SecureRandom();
		String stateKey = new BigInteger(130, random).toString();	//130bit 크기의 최댓값 임의의 정수를 생성하여 문자열로 만들어라
		log.debug("STATE KEY:" + stateKey);
		
		
		
		String apiURL = loginAPI_URL;
		apiURL += "?client_id=" + clientId;
		apiURL += "&response_type=code";
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + stateKey;
		
		
		
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
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
		
		params.add(Naver.TOKEN.grant_type, Naver.GRANT_TYPE.authorization_code);
		params.add(Naver.TOKEN.client_id, this.clientId);
		params.add(Naver.TOKEN.client_secret, this.clientSecret);
		params.add(Naver.TOKEN.code, naverOK.getCode());
		params.add(Naver.TOKEN.state, naverOK.getState());
		
	
		
		
		// header에 담긴 정보와 params에 담긴 정보를 HttpEntity 데이터로 변환
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params, headers);
		
		
		
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
		
		HttpEntity<String> request = new HttpEntity<String>("parameter", headers);
		
		
		
		ResponseEntity<NaverMemberResponse> result;
		RestTemplate restTemp = new RestTemplate();
		
		
		result = restTemp.exchange(naverMemberAPI_URL, HttpMethod.GET, request, NaverMemberResponse.class);
		
		
		NaverMember member = result.getBody().response;
		
		return member;
		
	}
	
}
