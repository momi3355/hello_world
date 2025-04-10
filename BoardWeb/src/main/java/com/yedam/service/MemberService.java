package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.MemberVO;

//업무프로세스(service)
public interface MemberService {
	//로그인 프로세스.
	MemberVO login(String id, String pw);
	boolean isMember(String id);
	//회원가입 프로세스.
	boolean addMember(MemberVO member);
}
