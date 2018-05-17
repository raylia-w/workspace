package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import web.controller.InterceptorAdminController.InterceptorAdminController;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("++INTERCEPTOR START++");
		logger.info("Request URI : "+request.getRequestURI());
		HttpSession session = request.getSession();
		if(session.getAttribute("login")==null) {
			//비로그인 상태
			logger.info("접속 불가 : 비로그인 상태");
			response.sendRedirect("/interceptor/admin/adminFail.do");
		}else {
			if(!"admin".equals(session.getAttribute("nick"))) {
				//일반사용자 상태
				logger.info("접속 불가 : 일반 로그인 상태");
				response.sendRedirect("/interceptor/admin/adminFail.do");
			}
		}
		//관리자 로그인 상태
		logger.info("관리자 로그인");
		return true;
		//true일 경우 컨트롤러 접근 허용 - false:컨트롤러 접근 금지
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
