<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<table class="offers">
	<tr>
		<td>Name</td>
		<td>Email</td>
		<td>Offer</td>
	</tr>

	<c:forEach var="offer" items="${offers}">
		<tr>

			<td><c:out value="${offer.user.name}"></c:out></td>

			<td><c:out value="${offer.user.email}"></c:out></td>

			<td><c:out value="${offer.text}"></c:out></td>

		</tr>
	</c:forEach>
</table>

<p/>
<c:choose>
	<c:when test="${hasOffer}">
		<a href="${pageContext.request.contextPath}/createoffer">Edit or delete your current offer.</a>
	</c:when>
	
	<c:otherwise>
		<p>
			<a href="${pageContext.request.contextPath}/createoffer">Add a new offer.</a>
		</p>
	</c:otherwise>
</c:choose>


<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p>
		<a href="<c:url value='/admin'/>">Administrator Page</a>
	</p>
</sec:authorize>

<%--
 	<p>
		<a href="${pageContext.request.contextPath}/admin">Admin Page</a>
	</p> 
--%>