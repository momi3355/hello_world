package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.MemberMapper;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstence().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<Map<String, Object>> cntPerWriter() {
		return mapper.selectWriter();
	}
	
	@Override
	public void logCreate(Map<String, String> map) {
		mapper.insertLogging(map);
	}
}
