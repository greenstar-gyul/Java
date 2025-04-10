<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h3>수정페이지(modifyBoard.jsp)</h3>
<form action="modifyBoard.do">
	<input type="hidden" name="bno" value="${brd.boardNo}">
	<input type="hidden" name="page" value="${page}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${brd.boardNo}</td>
			<th>글쓴이</th>
			<td>${brd.writer}</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3"><input type="text" name="title"
				value="${brd.title}"></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3"><textarea style="" cols="25" rows="3"
					name="content">${brd.content}</textarea></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td colspan="3"><fmt:formatDate value="${brd.writeDate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<button type="submit" class="btn btn-warning">수정</button>
			</td>
		</tr>
	</table>
</form>
