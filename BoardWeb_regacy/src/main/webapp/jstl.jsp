<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setAttribute("name", "홍길도이~~");
	List<String> list = new ArrayList<>();
	list.add("Hello");
	list.add("Nice");
	list.add("Mandarine");
	request.setAttribute("list", list);
	request.setAttribute("today", new Date());
	%>

	<!-- jstl 변수 초기화. Expression Language (EL) -->
	<%
	String msg = "Hello";
	%>
	<c:set var="msg" value="Hello" />
	<p>
		<c:out value="${msg ne 'Hello'}"></c:out>
	</p>
	<p>name 속성의 값은 ${name }</p>
	<p>로그인 아이디는 ${logId }</p>

	<!-- 조건문 -->
	<c:if test="${msg == 'Hello'}">
		<c:out value="msg의 값이 ${'Hello'}입니다." />
	</c:if>
	<c:set var="age" value="20" />
	<c:choose>
		<c:when test="${age >= 20}">
			<p>성년</p>
		</c:when>
		<c:otherwise>
			<p>미성년</p>
		</c:otherwise>
	</c:choose>

	<!-- 반복문 -->
	<c:forEach var="i" begin="1" end="9" step="1">
		<p>2 * ${i } = ${2 * i}</p>
	</c:forEach>
	<ul>
	<c:forEach var="str" items="${list}">
	   <li>${str}</li>
	</c:forEach>
	</ul>
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm:ss"/>
	<c:set var="cnt" value="100000"></c:set>
	<p><fmt:formatNumber value="${cnt}" pattern="###,###,###"></fmt:formatNumber></p>
	
</body>
</html>