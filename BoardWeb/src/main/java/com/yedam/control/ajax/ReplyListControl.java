package com.yedam.control.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.SearchDTO;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		//글번호(100) 댓글 데이터(json).
		String bno = req.getParameter("bno");   //원본 글 번호.
		String page = req.getParameter("page"); //댓글 페이지정보.
		SearchDTO search = new SearchDTO();
		search.setBoardNo(Integer.parseInt(bno));
		search.setPage(Integer.parseInt(page));
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(search);
		// [{ "replyNo": 10; "reply": "댓글내용", ... }, { ... }, ... ]
		String json = "[";
		for (ReplyVO reply : list) {
			json += "{\"replyNo\": "+reply.getReplyNo()
				+ ", \"reply\": \""+reply.getReply()+"\""
				+ ", \"replyer\": \""+reply.getReplyer()+"\""
				+ ", \"replyDate\": \""+reply.getReplyDate()+"\""
				+ ", \"boardNo\": "+reply.getBoardNo();
			
			//마지막은 콤마를 뺀다.
			json += (reply == list.getLast()) ? "}" : "},";
		}
		json += "]";
		resp.getWriter().print(json);
	}
}
