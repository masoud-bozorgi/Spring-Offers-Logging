<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


	<h2>Create New Account</h2>
	<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
		<table class="formtable">
			<tr>
				<td class="label">Username:</td>
				<td>
					<div class="error">
						<sf:input class="control" path="username" name="username" type="text" /><br/>
						<sf:errors path="username"></sf:errors>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td>
					<div class="error">
						<sf:input class="control" path="email" name="email" type="text" /><br/>
						<sf:errors path="email" cssClass="error"></sf:errors>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td>
					<div class="error">
						<sf:input id="password" class="control" path="password" name="password" type="password" /><br/>
						<sf:errors path="password" cssClass="error"></sf:errors>
					</div>
				</td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input id="confirmpass" class="control" name="confirmpassword" type="password" /><div id="matchpass" ></div></td><br/>
			</tr>



			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create account" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
