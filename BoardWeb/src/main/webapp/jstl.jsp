<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삽입을 이곳에 제목을</title>
</head>
<body>
  <%
  request.setAttribute("name", "Hong");
  List<String> list = new ArrayList<String>();
  list.add("hello");
  list.add("nice");
  list.add("good");
  request.setAttribute("list", list);
  request.setAttribute("today", new Date());
  %>

  <!-- jstl 변수 초기화. Expression Language(EL) -->
  <% String msg = "Hello"; %>
  <c:set var="msg" value="Hello"/>
  <!-- 같다. -->
  <p><c:out value="${msg ne 'Hello'}"/></p><!-- ne: not equals -->
  <p><c:out value="${msg eq 'Hello'}"/></p><!-- eq: equals -->
  
  <p>name의 값은 ${name}</p>
  <p>로그인 아이디는 ${logId}:${logName}</p>
  
  <!-- 조건문 -->
  <c:if test="${msg == 'Hello'}">
    <c:out value="msg의 값이 Hello입니다."/>
  </c:if>
  
  <c:set var="age" value="20"/>
  <c:choose>
    <c:when test="${age > 20}">
      <p>성년입니다.</p>
    </c:when>
    <c:otherwise>
      <p>미성년입니다.</p>
    </c:otherwise>
  </c:choose>
  
  <!-- 반복문. -->
  <% for (int i = 1; i <= 10; i++) {} %>
  <c:forEach var="i" begin="1" end="10" step="1"> <!-- step은 없어도 된다.(없으면 1) -->
    <p>2 * ${i} = ${2*i}</p>
  </c:forEach>
  
  <ul>
    <c:forEach var="str" items="${list}">
      <li><c:out value="${str}"/></li>
    </c:forEach>
  </ul>
  
  <!-- fmt: format -->
  <fmt:formatDate value="${today}" pattern="yyyy/MM/dd a hh:mm:ss"/>
  <br/>
  <c:set var="cnt" value="1000000"/>
  <fmt:formatNumber value="${cnt}" pattern="##,###원"/>
  <br/>
  <c:set var="cat" value="10.04152"/>
  <fmt:formatNumber value="${cat}" pattern="##.##고냥"/>
  
  <script>
    let msg = 'Hello';
    console.log(`${msg == 'Hello'}`);
  </script>
</body>
</html>