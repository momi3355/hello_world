<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- webapp/WEB-INB/views/board.jsp -->
<% //request는 요청정보가 있는 내장 객체
//String logId = (String)session.getAttribute("logId");
//BoardVO board = (BoardVO)request.getAttribute("board");
//String paging = (String)request.getAttribute("page");
//String msg = (String)request.getAttribute("msg");
%>
<script>
let msg = "${msg}";
if (msg != "") {
  alert(msg);
}
</script>
<h3>상세 페이지</h3>
<form action="modifyForm.do">
  <!-- 수정으로 전달하는 값. -->
  <input type="hidden" name="bno" value="${board.boardNo}"/>
  <input type="hidden" name="page" value="${page}"/>

  <table class="table">
     <tr>
       <th>글번호</th><td>${board.boardNo}</td>
       <th>작성자</th><td>${board.writer}</td>
     </tr>
     <tr>
       <th>제목</th>
       <td colspan="3">${board.title}</td>
     </tr>
     <tr>
       <th>내용</th>
       <td colspan="3"><textarea class="form-control" cols="25" rows="3" readonly>${board.content}</textarea></td>
     </tr>
     <tr>
       <th>작성일지</th>
       <td colspan="3">${board.writeDate}</td>
     </tr>
     <c:if test="${msg != null}">
       <tr><td colspan="4" align="center">
         <p style="margin: 0;color: red">${msg}</p>
       </td></tr>
     </c:if>
     <tr>
       <td colspan="4" align="center">
         <input type="submit" value="수정" class="btn btn-warning"/>
         <c:choose>
           <c:when test="${logId != null && logId == board.writer}">
             <button type="button" class="btn btn-danger">삭제</button>
           </c:when>
           <c:otherwise>
             <button type="button" class="btn btn-danger" disabled>삭제</button>
           </c:otherwise>
         </c:choose>       
       </td>
      </tr>
  </table>
</form>
<p><a href='boardList.do'>목록이동</a></p>
<script>
  //삭제버튼에 이벤트 등록.
  document.querySelector('button.btn.btn-danger').addEventListener('click', deleteFnc);
  //삭제함수.
  function deleteFnc() {
    location.href = 'deleteForm.do?page=${page}&bno=${board.boardNo}'; // 삭제화면 -> 삭제처리.
  }
</script>
<jsp:include page="includes/footer.jsp"/>