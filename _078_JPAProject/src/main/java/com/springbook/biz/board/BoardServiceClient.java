package com.springbook.biz.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("_078_JPAProject");
		EntityManager em = emf.createEntityManager();
		//EntityManager em2 = emf.createEntityManager();// 원하면 이렇게 하나씩 거내서 쓰면 된다.
		
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			//Transaction 시작
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목2");
			board.setWriter("관리자2");
			board.setContent("JPA 글 등록 잘 되네요. 지긐 시퀀스 수정 하고 적용 중");
			
			//글 등록
			em.persist(board);
			
			//글 목록 조회
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for(Board brd : boardList) {
				System.out.println("----> " + brd.toString());
			}
			
			//Transaction Commit
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			//Transaction Rollback
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
