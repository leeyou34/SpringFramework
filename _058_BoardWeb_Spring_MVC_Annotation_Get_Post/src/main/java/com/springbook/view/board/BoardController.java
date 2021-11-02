package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	@RequestMapping(value="/insertBoard.do")
	//Command 객체 : 사용자가 전송한 데이터를 매핑한 VO를 바로 생성
	//				사용자 입력 값이 많아지면 코드가 길어지기 때문에 간략화 가능
	//              사용자 입력 input의 name 속성과 VO 멤버변수의 이름을 매핑해주는 것이 중요
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		
		/*
		 * //1. 사용자 입력정보 추출(insertBoard.jsp에서 전송된 정보 추출) String title =
		 * request.getParameter("title"); String writer =
		 * request.getParameter("writer"); String content =
		 * request.getParameter("content");
		 * 
		 * //2. DB 연동 처리(BoardDAO의 메소드 호출) BoardVO vo = new BoardVO();
		 * vo.setTitle(title); vo.setWriter(writer); vo.setContent(content);
		 */
		boardDAO.insertBoard(vo);
		
		//화면 네비게이션(게시글 등록 완료 후 게시글 목록으로 이동)
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		
		boardDAO.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
		
		//ModelAndView 객체에 데이터 담기
		mav.addObject("boardList", boardDAO.getBoardList(vo));
		//ModelAndVie 객체에 View 담기
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
}
