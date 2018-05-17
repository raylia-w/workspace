package web.controller.InterceptorListController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.controller.InterceptorTestController;

@Controller
public class InterCeptorListController {
	private static final Logger logger = LoggerFactory.getLogger(InterceptorTestController.class);
	
	@RequestMapping(value="/interceptor/board/list.do", method=RequestMethod.GET)
	public void list() {
		logger.info("목록 페이지 호출");
	}
	
	@RequestMapping(value="/interceptor/board/write.do", method=RequestMethod.GET)
	public void write() {
		logger.info("글쓰기 페이지 호출");
	}
	
	@RequestMapping(value="/interceptor/board/boardFail.do", method=RequestMethod.GET)
	public void boardFail() {
		logger.info("글쓰기 에러 페이지 호출");
	}

}
