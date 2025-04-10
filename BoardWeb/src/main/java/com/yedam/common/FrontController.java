package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.calendar.control.AddEventControl;
import com.yedam.calendar.control.EventListControl;
import com.yedam.calendar.control.ExistEventControl;
import com.yedam.calendar.control.RemoveEventControl;
import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.SignUpControl;
import com.yedam.control.ajax.AddReplyControl;
import com.yedam.control.ajax.ChartJsonControl;
import com.yedam.control.ajax.RemoveReplyControl;
import com.yedam.control.ajax.ReplyCountControl;
import com.yedam.control.ajax.ReplyListControl;
import com.yedam.control.ajax.ReplyListDataTable;
import com.yedam.control.form.ChartControl;
import com.yedam.control.form.DeleteFormControl;
import com.yedam.control.form.EventFormControl;
import com.yedam.control.form.JSControl;
import com.yedam.control.form.LoginFormControl;
import com.yedam.control.form.MainControl;
import com.yedam.control.form.ModifyFormControl;

//*.do의 요청에 실행
public class FrontController extends HttpServlet {
	//요청 URL <=> 실행컨트롤.
	Map<String, Control> map;
	//생성자
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	//init
	@Override
	public void init(ServletConfig config) throws ServletException {
		/* [메인화면] */
		map.put("/main.do", new MainControl()); //메인화면.
		/* [회원가입] */
		map.put("/signForm.do", new SignUpControl()); //회원가입 화면.
		map.put("/signUp.do", new SignUpControl()); //회원가입 처리.
		/* [로그인] */
		map.put("/loginForm.do", new LoginFormControl()); //로그인화면.
		map.put("/login.do", new LoginControl()); //로그인처리.
		map.put("/logout.do", new LogoutControl()); //로그아웃 처리.
		
		/* [게시글] */
		map.put("/board.do", new BoardControl()); //상세화면.
		map.put("/boardList.do", new BoardListControl()); //목록.
		map.put("/addBoard.do", new AddBoardControl()); //글등록.
		map.put("/modifyForm.do", new ModifyFormControl()); //수정화면.
		map.put("/modifyBoard.do", new ModifyBoardControl()); //글수정 처리.
		map.put("/deleteForm.do", new DeleteFormControl()); //삭제화면.
		map.put("/deleteBoard.do", new DeleteBoardControl()); //글 삭제처리.
		
		/* [댓글] */
		map.put("/replyList.do", new ReplyListControl()); //댓글데이터.
		map.put("/replyListDataTable.do", new ReplyListDataTable()); //데이터테이블을 사용한.
		map.put("/addReply.do", new AddReplyControl()); //댓글추가.
		map.put("/removeReply.do", new RemoveReplyControl()); //댓글삭제.
		map.put("/replyCount.do", new ReplyCountControl()); //댓글수.
		
		
		/* [etc.] */
		map.put("/javascript.do", new JSControl());       //자바스크립트 연습
		map.put("/eventForm.do", new EventFormControl()); //캘린더 이벤트 연습
		map.put("/chart.do", new ChartControl());         //차트 연습
		
		/* [캘린더] */
		map.put("/addEvent.do", new AddEventControl());
		map.put("/eventList.do", new EventListControl());
		map.put("/existEvent.do", new ExistEventControl());
		map.put("/removeEvent.do", new RemoveEventControl());
		
		/* [차트] */
		map.put("/chartJson.do", new ChartJsonControl());
	}
	//service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//URL vs. URI
		// http://localhost:8080/BoardWeb/board.do(URL)
		// /BoardWeb/board.do(URI)
		String uri = req.getRequestURI();
		//System.out.println("요청 URI: "+uri); // /BoardWeb/board.do
		String context = req.getContextPath(); // /BoardWeb
		String page = uri.substring(context.length());
		//System.out.println(page); // /board.do
		//Control sub = map.get(req.getRequestURI().substring(req.getContextPath().length()));
		
		Control sub = map.get(page); //키(url) => control 반환.
		sub.exec(req, resp);
	}
}
