package web.controller.InterceptorAdminController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InterceptorAdminController {
	private static final Logger logger = LoggerFactory.getLogger(InterceptorAdminController.class);
	
	@RequestMapping(value="/interceptor/admin/main.do", method=RequestMethod.GET)
	public void adminMain() {
		logger.info("관리자 메인페이지 활성화");
	}
	
	@RequestMapping(value="/interceptor/admin/adminFail.do", method=RequestMethod.GET)
	public void adminFail() {
		logger.info("관리자 에러 페이지 활성화");
	}

}
