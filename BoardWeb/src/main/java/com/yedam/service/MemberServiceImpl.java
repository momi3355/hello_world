package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

//업무(서비스)의 구현 클래스
public class MemberServiceImpl implements MemberService {
	SqlSession sqlSession = DataSource.getInstence().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}
	
	@Override
	public boolean isMember(String id) {
		return mapper.selectId(id) != null;
	}
	
	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insertMember(member) == 1; //회원가입은 하나이다.
	}
}
