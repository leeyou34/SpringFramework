package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping(value="/logout.do")
	//Command 객체로 HttpSession을 선언하게 되면 스프링컨테이너가 브라우저와 매핑된 세션객체를 담아서 넘겨줌
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		session.invalidate();
		return "login.jsp";
	}
}
