<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
  <%
  //String logId = (String)session.getAttribute("logId");
  %>
  <!-- addForm.jsp -->
  <form action="addBoard.do" method="post">
    <table class="table">
      <tr>
        <th>글제목</th><td><input class="form-control" type="text" name="title"></td>
      </tr>
      <tr>
        <th>작성자</th><td><input class="form-control" type="text" name="writer" value="${(logId == null) ? 'ㅇㅇ': logId}" readonly></td>
      </tr>
      <tr>
        <th>본문</th><td><textarea class="form-control" name="content" rows="3" cols="40"></textarea></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input class="btn btn-primary" type="submit"> <input class="btn btn-secondary" type="reset">
        </td>
      </tr>
    </table>
  </form>
<jsp:include page="includes/footer.jsp"/>