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
<style>
#container {
	border: 5px solid black;
	width: 800px;
	height: 700px;;
	float: center;
	margin-left: 270px;
}

#info {
	width: 780px;
	height: auto;
	margin-left: 320px;
	margin-top: 10px;
}

body {
	background-color: black;
}

p {
	color: white;
}

h1 {
	color: white;
	font-family: Paprika, serif;
}

#rent {
	width: auto;
	height: auto;
	margin-left: 8px;
	margin-top: 10px;
}

#picture {
	border: 2px solid black;
	width: 200px;
	height: 200px;
	float: right;
	margin-top: -205px;
	margin-right: 5px;
}

#form1 {
	height: auto;
	width: auto;
}

#words {
	height: 200px;
	width: 550px;
	margin-top: 20px;
	margin-left: 3px;
	font-family: Shadows Into Light Two, serif;
}

table {
	color: white;
	border-color: transparent;
	margin-left: 320px;
	font-family: Shadows Into Light Two, serif;
}

.button {
	border-top: 1px solid #02090d;
	background: #8fa3b0;
	background: -webkit-gradient(linear, left top, left bottom, from(#bca5d1),
		to(#8fa3b0) );
	background: -webkit-linear-gradient(top, #bca5d1, #8fa3b0);
	background: -moz-linear-gradient(top, #bca5d1, #8fa3b0);
	background: -ms-linear-gradient(top, #bca5d1, #8fa3b0);
	background: -o-linear-gradient(top, #bca5d1, #8fa3b0);
	padding: 2.0px 25px;
	-webkit-border-radius: 40px;
	-moz-border-radius: 40px;
	border-radius: 40px;
	-webkit-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	-moz-box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	box-shadow: rgba(0, 0, 0, 1) 0 1px 0;
	text-shadow: rgba(0, 0, 0, .4) 0 1px 0;
	color: white;
	font-size: 12px;
	font-family: Shadows Into Light Two, serif;
	text-decoration: none;
	vertical-align: middle;
}

.button:hover {
	border-top-color: #828282;
	background: #828282;
	color: #ccc;
}

.button:active {
	border-top-color: #1b435e;
	background: #1b435e;
}

h3 {
	color: white;
	font-family: Shadows Into Light Two, serif;
}
</style>
<title>Rental Services</title>
</head>
<body>

	<script language="JavaScript">
function checkQuantity()
{
	var qty = document.getElementById("quantity").value;
	if(qty == null){
		alert( 'Please enter the quantity!' );
	}
}

function clear() 
{
	$("#IndividualProductPage").prop('input')
};

</script>
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
	<% 
ArrayList<Products> p = new ArrayList<Products>();
Products pro = new Products();
p = pro.retrieveData();
%>
	<% for(int i=0; i<p.size(); i++) 
{
	pro = p.get(i);
%>

	<center>
		<h1>Rental Services</h1>
	</center>

	<div id="rent">
		<form id="form1" name="form1" method="post" action="">
			<br />
			<table width="302" border="1" style="width: 369px;">
				<tr>
					<td width="132" style="width: 152px;"><strong>Product
							Name:&nbsp; </strong></td>
					<td width="154" style="width: 127px;"><select name="list"
						id="list">
							<option value="Wheel Chair">Wheel Chair</option>
							<option value="Walking Stick">Walking Stick</option>

					</select></td>
					<td style="width: 131px;"><input type="submit" name="button"
						id="button" class="button" value="Submit"
						onclick="confirm( 'Are you sure you want to rent these items?' )" /></td>
				</tr>
			</table>
		</form>
		<div id="info">
			<div id="words">
				<div id="name">
					<h3><%= pro.getProductName() %></h3>
				</div>
				<p><%= pro.getProductDescription() %></p>
				<%
}
%>
			</div>
			<div id="picture">
				<img src="wheelchair.jpg" />
			</div>
		</div>
		<br />
		<form id="IndividualProductPage" method="POST" action="RentalServlet">
			<table width="394" border="1">
				<tr>
					<td><strong>Name of product: &nbsp;</strong></td>
					<td><%= pro.getProductName() %></td>
				</tr>
				<tr>
					<td><strong>Status:&nbsp;&nbsp; </strong> <label for="end"></label></td>
					<td><%= pro.getStatus() %></td>
				</tr>
				<tr>
					<td><strong>Quantity available: &nbsp;</strong></td>
					<td><%= pro.getQuantity() %></td>
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
					<td><input type="text" name="end" id="end"
						contenteditable="false" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="button" id="button"
						class="button" value="Submit"
						onclick="confirm( 'Are you sure you want to rent these items?' )" /></td>
					<td><input type="reset" value="Clear" class="button"
						id="button" name="clearAll" /></td>
				</tr>
			</table>

		</form>

	</div>

	</div>
</body>
</html>