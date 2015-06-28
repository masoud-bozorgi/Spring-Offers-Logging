<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	
	
	


<%-- 	<c:forEach var="myOffers" items="${offers}">
		
		<P><c:out value="${myOffers}"></c:out></P>
	    
	    ID: ${row.id}<br/>
	    Name: ${row.name}<br/>
	    Email: ${row.email}<br/>
	    Text: ${row.text}<br/>
	</c:forEach> 
--%>

