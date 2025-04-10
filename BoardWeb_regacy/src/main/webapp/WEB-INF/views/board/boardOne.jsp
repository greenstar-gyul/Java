<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3>상세페이지(board.jsp)</h3>
<form action="modifyForm.do">
	<input type="hidden" name="bno" value="${brd.boardNo}"> 
	<input type="hidden" name="page" value="${page}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${brd.boardNo}</td>
			<th>글쓴이</th>
			<td><c:out value="${brd.writer}"></c:out></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3"><c:out value="${brd.title}"></c:out></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="3"><textarea style="" cols="25" rows="3" readonly><c:out value="${brd.content}"></c:out></textarea></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td colspan="3"><fmt:formatDate value="${brd.writeDate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-warning">수정</button> 
				<c:choose>
					<c:when test="${logId ne null && logId eq brd.writer}">
						<button type="button" class="btn btn-danger">삭제</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-danger" disabled>삭제</button>
					</c:otherwise>
				</c:choose>

			</td>
		</tr>
		<tr>
			<td align="center" colspan="4">
			    <c:if test="${msg != null}">
					<span style="color: red">${msg}></span>
				</c:if></td>
		</tr>
	</table>
</form>
<p>
	<a href="boardList.do">목록이동</a>
</p>
<script>
        document.querySelector('button.btn.btn-danger').addEventListener('click', function() {
            location.href = "deleteForm.do?bno=${brd.boardNo}&page=${page}";
					});
</script>
