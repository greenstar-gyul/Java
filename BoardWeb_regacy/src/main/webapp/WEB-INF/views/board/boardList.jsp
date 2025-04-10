<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h3>게시글 목록</h3>
<!-- 검색조건 -->
<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option>선택하세요</option>
				<c:choose>
					<c:when test="${searchCondition == null}">
						<option value="T">제목</option>
						<option value="W">작성자</option>
						<option value="TW">제목&작성자</option>
					</c:when>
					<c:when test="${searchCondition == 'T'}">
						<option value="T" selected="selected">제목</option>
						<option value="W">작성자</option>
						<option value="TW">제목&작성자</option>
					</c:when>
					<c:when test="${searchCondition == 'W'}">
						<option value="T">제목</option>
						<option value="W" selected="selected">작성자</option>
						<option value="TW">제목&작성자</option>
					</c:when>
					<c:when test="${searchCondition == 'TW'}">
						<option value="T">제목</option>
						<option value="W">작성자</option>
						<option value="TW" selected="selected">제목&작성자</option>
					</c:when>
					<c:otherwise>
						<option value="T">제목</option>
						<option value="W">작성자</option>
						<option value="TW">제목&작성자</option>
					</c:otherwise>
				</c:choose>
			</select>
		</div>
		<div class="col-sm-4">
			<c:choose>
				<c:when test="${keyword != null && keyword != 'null'}">
					<input type="text" name="keyword" class="form-control"
						value="${keyword}">
				</c:when>
				<c:otherwise>
					<input type="text" name="keyword" class="form-control">
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-sm-2">
			<button type="submit" class="btn btn-info">검색</button>
		</div>
	</div>
</form>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>글내용</th>
			<th>글쓴이</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${blist}">
			<tr>
				<td>${board.boardNo}</td>
				<td><a
					href='board.do?bno=${board.boardNo}&page=${page.currentPage}'>${board.title}</a></td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td><fmt:formatDate value="${board.writeDate}"
						pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- 페이징 -->
<nav aria-label="...">
	<ul class="pagination">
		<c:choose>
			<c:when test="${page.prev}">
				<li class="page-item"><a class="page-link"
					href="boardList.do?page=${page.startPage - 1}&searchCondition=${searchCondition}&keyword=${keyword}">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">Previous</span>
				</li>
			</c:otherwise>
		</c:choose>

		<c:forEach var="p" begin="${page.startPage}" end="${page.endPage}">
			<c:choose>
				<c:when test="${page.currentPage == p}">
					<li class="page-item active" aria-current="page"><span
						class="page-link">${p}</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="boardList.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}">${p}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${page.next}">
				<li class="page-item"><a class="page-link"
					href="boardList.do?page=${page.endPage + 1}&searchCondition=${searchCondition}&keyword=${keyword}">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">Next</span>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>