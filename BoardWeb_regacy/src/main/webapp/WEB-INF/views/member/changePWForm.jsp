<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form name="changePWForm" action="changepw.do" method="post">
  <table class="table">
    <tr>
      <th>현재비밀번호</th>
      <td><input type="password" class="form-control" name="current_pw" required></td>
    </tr>
    <tr>
      <th>새로운 비밀번호</th>
      <td><input type="password" class="form-control" name="new_pw" required></td>
    </tr>
    <tr>
      <th>비밀번호 확인</th>
      <td><input type="password" class="form-control" name="confirm_pw" required></td>
    </tr>
    <tr>
      <td>
      <c:choose>
        <c:when test="${!empty msg }">
          <span style="color:red;">${msg}</span>
        </c:when>
        <c:otherwise>
          <span></span>
        </c:otherwise>
      </c:choose>
      </td>
      <td align="center">
        <button type="submit" class="btn btn-primary">변경</button>
      </td>
    </tr>
  </table>
</form>

<script>
  document.forms.passwdForm.addEventListener('submit', function (e) {
    let cpw = document.querySelector('input[name="new_pw"]').value;
    let rpw = document.querySelector('input[name="confirm_pw"]').value;
    if (cpw != rpw) {
      alert('비밀번호가 동일하지 않습니다.')
      return;
    }
    this.submit();
  })
</script>