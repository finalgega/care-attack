<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rental Details</title>
<script type="text/javascript" language="javascript"></script>
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Paprika" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Shadows Into Light Two" />
<link rel="stylesheet" type="text/css" href="styles/index.css" />
<link rel="stylesheet" type="text/css" href="styles/rentDetails.css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
		<br />
		<center>
			<h2 id="text">RENTAL DETAILS</h2>
		</center>
		<%@ page import="entity.*,java.util.*, util.*"%>
		<%
			Rental r = new Rental();
		%>
		<form id="viewRental" method="POST" action="RentalServlet">
			<div id="table1">
				<div id="infomation">
					<h3>PERSONAL DETAILS</h3>
					<div id="info1">
					<table>
						<tr>
							<td><h4>Name:</h4></td>
							<td><%=session.getAttribute("name").toString()%></td>
						</tr>

						<tr>
							<td><h4>NRIC:</h4></td>
							<td><%=session.getAttribute("nric").toString()%></td>
						</tr>
						
						<tr>
							<td><h4>Phone No:</h4></td>
							<td><%=session.getAttribute("phone").toString()%></td>
						</tr>
					</table>
					</div>
				</div>
				<div id="details">
					<h3>PRODUCT INFORMATION AND PRICE</h3>
					<div id ="detail1">
					<table>
						<tr>
							<td><h4>Product Name:</h4></td>
							<td><%=session.getAttribute("productName").toString()%></td>
						</tr>
						<tr>
							<td><h4>Product Price:</h4></td>
							<td>$<%=session.getAttribute("price").toString()%></td>
						</tr>
						<tr>
							<td><h4>Quantity:</h4></td>
							<td><%=session.getAttribute("rentalQuantity").toString()%></td>
						</tr>
						<tr>
							<td><h4>Total Price:</h4></td>
							<td>$<%=session.getAttribute("totalPrice").toString()%></td>
						</tr>
					</table>
					</div>
				</div>
				<div id="date">
					<h3>RENTAL DATE</h3>
					<div id="date1">
					<table>
						<tr>
							<td><h4>Start Date:</h4></td>
							<td><%=session.getAttribute("startDate").toString()%></td>
						</tr>
						<tr>
							<td><h4>End Date:</h4></td>
							<td><%=session.getAttribute("endDate").toString()%></td>
						</tr>
					</table>
					</div>
				</div>

			</div>

		</form>

		<a href="index.jsp">
			<div class="button" id="button" onclick="index.jsp">
				<center>
					<strong>BACK TO HOME >>></strong>
				</center>
			</div>
		</a>


	</div>

</body>
</html>