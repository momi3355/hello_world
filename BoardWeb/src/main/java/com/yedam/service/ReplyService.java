package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

//업무프로세스(service)
public interface ReplyService {
	List<ReplyVO> replyList(int boardNo);
	ReplyVO getReply(int replyNo);
	boolean addReply(ReplyVO rvo);
	boolean removeReply(int replyNo);
}
