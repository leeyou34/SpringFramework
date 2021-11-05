package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

//SpringFramework에서 제공하는 Controller interface의 handleRequest메소드는 리턴 타입 ModelAndView
@Controller
public class LoginController {
	//GET방식으로 요청이 오면 로그인화면으로 Post방식으로 요청이 오면 로그인 처리
	//@RequestMapping(value="/login.do", method=RequestMethod.GET)
	@GetMapping(value="/login.do")
	//userVO의 이름으로 Command객체 생성
	//이름을 지정 안할 시에 자동으로 첫글자가 소문자로 변경된 이름으로 생성됨
	//Command 객체의 이름 지정 : @ModelAttribute("user") -> user의 이름의 Command 객체 생성
	public String loginView(@ModelAttribute("user")UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		//로그인화면으로 이동시 처음 입력값 세팅
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	//@RequestMapping(value="/login.do", method=RequestMethod.POST)
	@PostMapping(value="/login.do")
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 처리");
		UserVO user = userDAO.getUser(vo);
		//로그인 성공 시 게시판 목록 조회 화면으로 이동
		if(user != null) {
			/*
				foward, include : RequestDispatcher를 이용하여 응답으로 보여줄 화면을 리턴
								   한 번의 요청과 응답으로 처리되므로 속도가 빠르고 URL 변경되지 않음
								   이전 페이지에서 작성한 데이터의 공유가 가능함
								  forward : 이동할 페이지에 제어권을 영구적으로 넘겨줌
								  include : 이동할 페이지의 처리가 끝나면 다시 이전 페이지에 제어궘을 넘겨줌
				redirect : 이동할 JSP에서 브라우저로 응답메시지를 보내주고 다시 서버로 재요청 방식
				                   속도가 forward, include에 비해서 느리고 URL이 이동할 페이지로 변경
				                   요청과 응답 객체를 새로 생성해서 전송하기 때문에 이전 페이지에서 작성한 데이터 공유가 불가능
			*/
			//redirect : viewResolver를 무시하고 바로 리다이렉트
			//UserVO의 name 변수를 session 데이터 보관소에 userName이라는 키 값으로 저장
			session.setAttribute("userName", user.getName());
			//UserVO 자체를 session 데이터 보관소에 user라는 키 값으로 저장
//			session.setAttribute("user", user);
			return "redirect:getBoardList.do";
		//로그인 실패 시 다시 로그인 화면으로 이동
		} else {
			return "login.jsp";
		}
	}
}
