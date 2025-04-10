package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

/*
 * 인터페이스(메소드정의) - 구현클래스(메소드구현)
 */
public interface BoardMapper {
	//조회.
	List<BoardVO> selectBoard(SearchDTO search);
	//등록.
	int insertBoard(BoardVO board);
	//수정.
	int updateBoard(BoardVO board);
	//삭제.
	int deleteBoard(int boardNo);
	//상세조회.
	BoardVO selectOne(int boardNo);
	//전체건수.
	int selectTotal(SearchDTO search);
	//차트.
	List<Map<String, Object>> selectWriter();
	//로그.
	int insertLogging(Map<String, String> map);
}
