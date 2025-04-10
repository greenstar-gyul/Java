<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BoardVO board = (BoardVO) request.getAttribute("brd");
int paging = (int) request.getAttribute("page");
%>
<h3>상세페이지(board.jsp)</h3>
<form action="deleteBoard.do">
	<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
	<input type="hidden" name="page" value="<%=paging%>">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo()%></td>
			<th>글쓴이</th>
			<td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3"><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3"><textarea style="" cols="50" rows="3" readonly><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td colspan="3"><%=board.getWriteDate()%></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<p style="font-weight: bold; text-align: center;">정말로 삭제할까요?</p>
				<button type="submit" class="btn btn-danger">예</button>
				<button type="button" class="btn btn-secondary">취소</button>
			</td>
		</tr>
	</table>
</form>
<p>
	<a href="boardList.do">목록이동</a>
</p>
<script>
        document.querySelector('button.btn.btn-secondary').addEventListener('click', function() {
            location.href = "boardList.do?page=<%=paging%>";
			});
</script>
