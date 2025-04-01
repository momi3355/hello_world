<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
<!-- modifyBoard.jsp -->
<%
BoardVO board = (BoardVO)request.getAttribute("board");
String paging = (String)request.getAttribute("page");
%>

<h3>수정 페이지</h3>
<form action="modifyBoard.do">
  <input type="hidden" name="bno" value="<%=board.getBoardNo() %>"/>
  <input type="hidden" name="page" value="<%=paging %>"/>

  <table class="table">
     <tr>
       <th>글번호</th><td><%=board.getBoardNo() %></td>
       <th>작성자</th><td><%=board.getWriter() %></td>
     </tr>
     <tr>
       <th>제목</th>
       <td colspan="3"><input type="text" name="title" class="form-control" value="<%=board.getTitle() %>"/></td>
     </tr>
     <tr>
       <th>내용</th>
       <td colspan="3"><textarea name="content" class="form-control" cols="25" rows="3"><%=board.getContent() %></textarea></td>
     </tr>
     <tr>
       <th>작성일지</th>
       <td colspan="3"><%=board.getWriteDate() %></td>
     </tr>
     <tr>
       <td colspan="4" align="center">
         <input type="submit" value="저장" class="btn btn-primary"/>
       </td>
     </tr>
  </table>
</form>
<jsp:include page="includes/footer.jsp"/>