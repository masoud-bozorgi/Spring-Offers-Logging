<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		document.f.username.focus();
	});
</script>

<h3>Login with your Username and Password.</h3>

<c:if test="${param.error != null}">
	<p class="error">Login failed. Check that your username and password are correct.</p>
</c:if>

<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
	<table class="formtable">
		<tr>
			<td>User:</td>
			<td><input type='text' name='username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='password' /></td>
		</tr>
		<tr>
			<td>Remember me:</td>
			<td><input type='checkbox' name='remember-me' checked="checked" /></td>
		</tr>
		<tr>
			<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
		</tr>
		<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
		<!--  <input name="_csrf" type="hidden" value=""/> -->
	</table>
</form>
<p>
	<a href="${pageContext.request.contextPath}/newaccount">Create new account.</a>
</p>
