package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class Test {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstence();
		BoardVO board = new BoardVO();
		board.setTitle("매퍼테스트22");
		board.setContent("매퍼를 활용한 입력테스트");
		board.setWriter("이창현");
		board.setBoardNo(5);
		
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			int r = boardMapper.insertBoard(board);
			//int r = sqlSession.delete("com.yedam.mapper.BoardMapper.deleteBoard", board.getBoardNo());
			if (r == 1) {
				System.out.println("삽입성공.");
				sqlSession.commit();
			} else {
				System.out.println("삽입실패.");
			}
			SearchDTO search = new SearchDTO();
			search.setPage(1);
			List<BoardVO> list = boardMapper.selectBoard(search);
			for (BoardVO brd : list) {
				System.out.println(brd.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
