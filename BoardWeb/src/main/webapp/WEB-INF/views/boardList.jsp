<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
<!-- webapp/WEB-INB/views/boardList.jsp -->
<% //request는 요청정보가 있는 내장 객체
List<BoardVO> list = (List<BoardVO>)request.getAttribute("blist");
PageDTO pageDTO = (PageDTO)request.getAttribute("paging");
String sc = (String)request.getAttribute("searchCondition");
String kw = (String)request.getAttribute("keyword");
%>
<h3>게시글 목록</h3>
<!-- 검색조건. -->
<form action="boardList.do">
  <div class="row">
    <div class="col-sm-4">
      <select name="searchCondition" class="form-control">
        <% if (sc == null) { %>
          <option selected>선택하세요.</option>
          <option value="T">제목</option>
          <option value="W">작성자</option>
          <option value="TW">제목&작성자</option>
        <% } else { %>
          <option>선택하세요.</option>
          <option value="T" <%= sc.equals("T") ? "selected" : "" %>>제목</option>
          <option value="W" <%= sc.equals("W") ? "selected" : "" %>>작성자</option>
          <option value="TW" <%= sc.equals("TW") ? "selected" : "" %>>제목&작성자</option>
        <% } %>
      </select>
    </div>
    <div class="col-sm-4">
      <input type="text" name="keyword" class="form-control" value="<%=(kw == null) ? "" : kw %>"/>
    </div>
    <div class="col-sm-2">
      <button type="submit" class="btn btn-info">검색</button>
    </div>
  </div>
  <table class="table">
    <thead>
      <tr><th>글번호</th><th>제 목</th><th>작성자</th><th>작성일지</th></tr>
    </thead>
    <tbody>
    <% for (BoardVO board: list) { %>
      <tr>
        <td><%=board.getBoardNo() %></td>
        <td><a href='board.do?page=<%=pageDTO.getCurrentPage() %>&bno=<%=board.getBoardNo() %>'><%=board.getTitle() %></a></td>
        <td><%=board.getWriter() %></td>
        <td><%=board.getWriteDate() %></td>
      </tr>
    <% } %>
    </tbody>
  </table>
  <!-- paging 처리 -->
  <nav aria-label="...">
    <ul class="pagination">
      <!-- 이전 10개 페이지 여부. -->
      <% if (pageDTO.isPrev()) { %>
        <li class="page-item">
          <a class="page-link" href="boardList.do?page=<%=pageDTO.getStartPage()-1 %>&searchCondition=<%=sc %>&keyword=<%=kw %>">Previous</a>
        </li>
      <% } else { %>
        <li class="page-item disabled">
          <span class="page-link">Previous</span>
        </li>
      <% } %>
      <!-- 숫자 표시하는 페이지 -->
      <% for (int p = pageDTO.getStartPage(); p <= pageDTO.getEndPage(); p++) { %>
      <%   if (pageDTO.getCurrentPage() == p) { %>
        <li class="page-item active" aria-current="page">
          <span class="page-link"><%=p %></span>
        </li>
      <%   } else { %>
        <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>&searchCondition=<%=sc %>&keyword=<%=kw %>"><%=p %></a></li>
      <%   }
         } %>
      <!-- 이후 10개 페이지 여부. -->
      <% if (pageDTO.isNext()) { %>
        <li class="page-item">
          <a class="page-link" href="boardList.do?page=<%=pageDTO.getEndPage()+1 %>&searchCondition=<%=sc %>&keyword=<%=kw %>">Next</a>
        </li>
      <% } else { %>
        <li class="page-item disabled">
          <span class="page-link">Next</span>
        </li>
      <% } %>
    </ul>
  </nav>
</form>
<script>

</script>
<jsp:include page="includes/footer.jsp"></jsp:include>