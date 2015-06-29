<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%-- <c:if test="${param.error != null}">
	<p class="error">Login failed. Check that your username and password are correct.</p>
</c:if> --%>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offers">
	<sf:input type="hidden" name="id" path="id" />

	<table class="formtable">
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

