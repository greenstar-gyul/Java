<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.mapper.BoardMapper"%>
<%@page import="com.yedam.common.DataSource"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    // 자바 영역  
    String msg = "Hello, World";
    System.out.println(msg);
    int age = 10;
    SqlSession sqlSession = DataSource.getInstance().openSession();
    BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
    List<BoardVO> list = mapper.selectBoard(null);
    %>
    <h3>글목록</h3>
    <ul>
    <%
    for (BoardVO board : list) {
    %>
    <li>글번호: <%= board.getBoardNo() %></li>
    <li>글제목: <%= board.getTitle() %></li>
    <li>글내용: <%= board.getContent() %></li>
    <li>글쓴이: <%= board.getWriter() %></li>
    <li>글쓴날: <%= board.getWriteDate() %></li>
    <li>====================================</li>
    <%
    }
    %>
    </ul>
    
    <p>저장정보</p>
    <p>age에 저장된 값은 <%=age %></p>
    
    <%
    if (age > 20) {
    %>
    <p>으른이</p>
    <%} else { %>
    <p>미자</p>
    <%} %>
    
</body>
</html>