<!-- addForm.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String logId = (String) session.getAttribute("logId");
%>
<form action="addBoard.do" method="post">
	<table class="table">
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><input class="form-control" type="hidden" name="writer"
				value="<%=logId%>"><%=logId%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="3" cols="40"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-primary"> <input type="reset"
				class="btn btn-secondary"></td>
		</tr>
	</table>
</form>
