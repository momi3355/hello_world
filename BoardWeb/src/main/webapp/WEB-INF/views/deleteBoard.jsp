<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
<!-- modifyBoard.jsp -->
<%
BoardVO board = (BoardVO)request.getAttribute("board");
String paging = (String)request.getAttribute("page");
%>

<h3>삭제 페이지</h3>
<form action="deleteBoard.do">
  <input type="hidden" name="bno" value="<%=board.getBoardNo() %>"/>
  <input type="hidden" name="page" value="<%=paging %>"/>

  <table class="table">
    <tr>
      <td colspan="4"><p>정말 해당페이지를 삭제하시겠습니까?<br>복구가 안되니 신중하게 결정하십시오.</p></td>
    </tr>
    <tr>
      <th>글번호</th><td><%=board.getBoardNo() %></td>
      <th>작성자</th><td><%=board.getWriter() %></td>
    </tr>
    <tr>
      <th>제목</th>
      <td colspan="3"><%=board.getTitle() %></td>
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="3"><textarea class="form-control" cols="25" rows="3" readonly><%=board.getContent() %></textarea></td>
    </tr>
    <tr>
      <th>작성일지</th>
      <td colspan="3"><%=board.getWriteDate() %></td>
    </tr>
    <tr>
      <td colspan="4" align="center">
        <input type="submit" value="삭제" class="btn btn-danger"/>
        <button type="button" class="btn btn-secondary">취소</button>
      </td>
    </tr>
  </table>
</form>
<script>
  //취소버튼에 이벤트 등록.
  document.querySelector('button.btn.btn-secondary').addEventListener('click', cancelFnc);
  //취소함수.
  function cancelFnc() {
    location.href = 'boardList.do?page=<%=paging %>';
  }
</script>
<jsp:include page="includes/footer.jsp"/>