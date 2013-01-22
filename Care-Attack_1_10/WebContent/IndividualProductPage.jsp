<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Paprika" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Shadows Into Light Two" />

<link rel="stylesheet" type="text/css" href="styles/IndividualPage.css" />
<title>Rental Services</title>
</head>
<body>

	<script language="JavaScript">
		function clear() {
			$("#IndividualProductPage").prop('input')
		}

		function validateForms() {
			var quantity = document.forms["IndividualProductPage"]["quantity"].value;
			var start = document.forms["IndividualProductPage"]["start"].value;
			var end = document.forms["IndividualProductPage"]["end"].value;

			if (quantity == null || quantity == "") {
				alert("Please enter the rental quantity!");
				return false;
			} else if (start == null || start == "") {
				alert("Please enter the rental start date!");
				return false;
			}

			else if (end == null || end == "") {
				alert("Please enter the rental end date!");
				return false;
			}

			else {
				alert("Rental successfully created!");
			}
		}
	</script>

	<jsp:include page="header.jsp"></jsp:include>



	<%@ page import="entity.*, java.util.*"%>
	<%-- <% 
	Products pd = new Products();	
	Rental rent = new Rental();
	String productID = pd.retrieveProductID();
	String rentalName = pd.getProductName();
	String rentalQuantity = rent.getRentalQuantity();
	String startDate = rent.getStartDate();
	String quantity = pd.getQuantity();
	String status = pd.getStatus();
%>
<%
	if(productID==null){
		System.out.println("NO ID FOUND!!!!!!!");
	}
	else{
		rent.createRental(rentalName, rentalQuantity, startDate);
	}
%> --%>
	<center>
		<br />
		<h1>Rental Services</h1>
	</center>
	
				<%
							ArrayList<Products> p = new ArrayList<Products>();
							Products pro = new Products();
							p = pro.retrieveData();
						%>
						<%
							for (int i = 0; i < p.size(); i++) {
								pro = p.get(i);
						%>
	<div id="container">

		<h3>Hello! Welcome to care attack rental services. Over here, we
			are renting products for disabled people at a lower price! You can
			select the items that you want to view and then enter the details of
			rental at the table below.</h3>
		<div id="rent">
		<br/>
		
			<form id="form1" name="form1" method="post" action="">
				<table width="302" border="1" style="width: 369px;">
					<tr>
						<td width="132" style="width: 191px;"><strong>Product Name:&nbsp; </strong></td>
						<td width="154" style="width: 127px;"><select name="list"
							id="list">
								<option><%=pro.getProductName()%></option>

						</select></td>
						<td style="width: 131px;"><input type="submit" name="button"
							id="button" class="button" value="Submit" /></td>
					</tr>
				</table>
			</form>
			<br />
			<div id="info">
				<div id="words">
					<div id="name">
						<h3><%=pro.getProductName()%></h3>
					</div>
					<p><%=pro.getProductDescription()%></p>
				</div>
				<%
					}
				%>
				<div id="picture">
					<img src="images/wheelchair.jpg" />
				</div>
			</div>
		</div>
		<br />
		<div id="rentrent">
			<h3>RENT YOUR ITEMS HERE!</h3>
			<form id="IndividualProductPage" method="POST" action="RentalServlet"
				onSubmit="return validateForms()">
				<table width="394" border="1">
					<tr>
						<td><strong>Name of product: &nbsp;</strong></td>
						<td><%=pro.getProductName()%></td>
					</tr>
					<tr>
						<td><strong>Status:&nbsp;&nbsp; </strong> <label for="end"></label></td>
						<td><%=pro.getStatus()%></td>
					</tr>
					<tr>
						<td><strong>Quantity available: &nbsp;</strong></td>
						<td><%=pro.getQuantity()%></td>
					</tr>

					<tr>
						<td><strong>Quantity for rent: &nbsp;</strong></td>
						<td><input type="text" name="quantity" id="quantity" /></td>
					</tr>
					<tr>
						<td><strong>Rental Start Date:</strong> <label for="start2"></label></td>
						<td><input type="text" name="start" id="start" /></td>
					</tr>
					<tr>
						<td><strong>Rental End Date:&nbsp;&nbsp; </strong> <label
							for="end"></label></td>
						<td><input type="text" name="end" id="end" /></td>
					</tr>

					<tr>
						<td><input type="submit" name="button" id="button"
							class="button" value="Submit" /></td>
						<!-- 							onclick="confirm( 'Are you sure you want to rent these items?' )"  -->
						<td><input type="reset" value="Clear" class="button"
							id="button" name="clearAll" /></td>
					</tr>
				</table>
			</form>

		</div>
	</div>

	<div id="cartoon">
		<img src="images/help.jpg" /> <br /> <img src="images/help1.jpg" />
	</div>
</body>
</html>