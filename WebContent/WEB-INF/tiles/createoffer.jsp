<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h3>Login with your Username and Password.</h3>
<c:if test="${param.error != null}">
	<p class="error">Login failed. Check that your username and password are correct.</p>
</c:if>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offers">
	<table class="formtable">
		<tr>
			<td class="label">Name:</td>
			<td><sf:input class="control" path="name" name="name" type="text" /> <sf:errors path="name" cssClass="error"></sf:errors>
			</td>
		</tr>
		<tr>
			<td class="label">Email:</td>
			<td><sf:input class="control" path="email" name="email" type="text" /> <sf:errors path="email" cssClass="error"></sf:errors>
			</td>
		</tr>
		<tr>
			<td class="label">Your offer:</td>
			<td><sf:textarea class="control" name="text" path="text" rows="10" cols="100"></sf:textarea> <sf:errors
					path="text" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><input class="control" value="Create offer" type="submit" /></td>
		</tr>
	</table>
</sf:form>

