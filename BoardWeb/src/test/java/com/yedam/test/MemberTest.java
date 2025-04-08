package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;
import com.yedam.vo.ReplyVO;

public class MemberTest {
	public static void main(String[] args) {
//		MemberService svc = new MemberServiceImpl();
//		MemberVO member = svc.login("user01", "1111");
//		System.out.println(member);
		SqlSession sqlSession = DataSource.getInstence().openSession(true);
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(100);
		rvo.setReply("댓글 테스트");
		rvo.setReplyer("user00");
		int cnt = mapper.insertReply(rvo);
		if (cnt > 0) {
			System.out.println("삽입성공");
		}
		
		//int cnt = mapper.deleteReply(4);
		//if (cnt > 0) {
		//	System.out.println("삭제성공");
		//}
		SearchDTO search = new SearchDTO();
		search.setBoardNo(100);
		List<ReplyVO> list = mapper.selectList(search); //100번 댓글.
		
		for (ReplyVO reply : list) {
			System.out.println(reply);
		}
		
		sqlSession.close();
	}
}
