<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<p>${empty logId ? 'guest' : logId} 환영해요!!</p>
<c:if test="${logId == null}">
    <p>글을 쓰려면 로그인을 해야해요~~!! (⩌⩊⩌)</p>
</c:if>
