package com.yedam.service;

import com.yedam.vo.MemberVO;

//업무프로세스(service)
public interface MemberService {
	//로그인 프로세스.
	MemberVO login(String id, String pw);
}
