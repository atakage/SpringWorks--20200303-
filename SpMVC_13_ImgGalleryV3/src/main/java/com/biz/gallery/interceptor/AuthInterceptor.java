package com.biz.gallery.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/*
 * 
 * req를 가로채기 
 * 
 * 
 */

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter{

	
	/*
	 * Dispatcher에서 Controller로 가는 도중 가로채기를 수행할 method
	 * 
	 */
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		String urlPath = request.getRequestURL().toString();
		String uriPath = request.getRequestURI().toString();
		
		String msg = String.format("URL: %s, URI: %s", urlPath, uriPath );
		
		//login 정보 확인
		HttpSession httpSession = request.getSession();
		
		//MEMBER Session을 확인하기 위해 Attribute를 추출해서 Object 객체(sessionObj)에 담기
		Object sessionObj = httpSession.getAttribute("MEMBER");
		
		//Object 객체가 null 확인
		// null이면 MEMBER Session 객체가 없음
		// 없으면 login이 되어 있지 않음
		if(sessionObj == null) {
			
			// context/image/upload에서 로그인 path로 redirect를 수행하는데 경로지정이 애매하게 작동
			//현재 경로가 /image/upload 이기 때문에 
			// ../> context로부터 경로를 시작
			// gallery/image/../member/login
			response.sendRedirect(request.getContextPath()+"/member/login");
			return false;	// 현재 로그인이 안 되어 있으므로 dispatcher에게 더이상 다른 일을 수행하지 말라
		}
		
		log.debug("나는 인터셉터입니다");
		log.debug(msg);
		
		return super.preHandle(request, response, handler);		// == return true, controller에게 전달
	}
	
	

}
