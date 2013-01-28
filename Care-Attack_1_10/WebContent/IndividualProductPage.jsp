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
<link rel="stylesheet" type="text/css" href="styles/index.css" />
<link rel="stylesheet" type="text/css" href="styles/IndividualPage.css" />
<title>Rental Services</title>
</head>
<body>

	<script language="JavaScript">
		function clear() {
			$("#IndividualProductPage").prop('input')
		}
		
		function hideshow() {
		    var toggle = document.getElementById('rentrent');
		    toggle.style.display = toggle.style.display == "block" ? "none" : "block";
		}

		function validateForms() {
			var name = document.forms["IndividualProductPage"]["name"].value;
			var nric = document.forms["IndividualProductPage"]["nric"].value;
			var quantity = document.forms["IndividualProductPage"]["quantity"].value;
			var start = document.forms["IndividualProductPage"]["start"].value;
			var end = document.forms["IndividualProductPage"]["end"].value;
			

			if (name == null || name == "") {
				alert("Please enter your name!");
				return false;
			} 
			
			else if (nric == null || nric == "") {
				alert("Please enter your NRIC!");
				return false;
			} 
			
			else if (quantity == null || quantity == "") {
				alert("Please enter the rental quantity!");
				return false;
			} 
			else if (start == null || start == "") {
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

<div id ="content">
<% if((session.getAttribute("productName") !=null)||(session.getAttribute("username")) != null){ %>
				
		<div id="cartoon">
		<table>
		<tr><td><img src="images/help.png" /></td></tr>
		<tr><td><img src="images/help1.png" /></td></tr>
		</table>
		</div>
		<%}else{ %>
		
		<div id="cartoon">
		<table>
		<tr><td><img src="images/help.png" /></td></tr>
		<tr><td><img src="images/help1.png" /></td></tr>
		</table>
		</div>
		<%} %>
		
	<div id="container">
		<center>
		<h1>Rental Services</h1>
	</center>

		<h3>Hello! Welcome to care attack rental services. Over here, we
			provide rental services for disabled people at a lower price! You can
			select the items that you want to view and if you want to rent our products, you have to log in or sign up now!</h3>
		<div id="rent">
		<br/>
		
			<form id="retrieveProducts" name="retrieveProducts" method="get" action="RentalServlet">
						<%
							ArrayList<Products> p = new ArrayList<Products>();
							Products pro = new Products();
							p = pro.retrieveData();
						%>
					
				<table width="302" border="1" style="width: 369px;">
					<tr>
						<td width="132" style="width: 191px;"><strong>Product Name:&nbsp; </strong></td>
						<td width="154" style="width: 127px;">
						<select name="list" id="list">
							<option value="">Select an Item</option>
									<%
							for (int i = 0; i < p.size(); i++) {
								pro = p.get(i);
						%>
								<option value="<%=pro.getProductName()%>"><%=pro.getProductName()%></option>
			<%
						}
					%>
						</select></td>
				
						<td style="width: 131px;"><input type="submit" name="button"
							id="button" class="button" value="Submit" /></td>
							
					</tr>
				</table>
			</form>
			<br />
			<% if(session.getAttribute("productName") != null){ %>
				<div id="info">
				
				<div id="words">
					<div id="name">
						<h3><%=session.getAttribute("productName").toString()%></h3>
					</div>
					<p><%=session.getAttribute("productDescription").toString()%></p>
					<div id="picture">
					<img src="images/wheelchair.jpg" />
				</div>
				</div>
				<%} else{ %>
				<div id="words">
					<div id="name">
				</div>
				</div>
				<% } %>
				</div>
	
		<% if(session.getAttribute("username") != null){ %>
		<div class="button1" id="testclick1" onclick="hideshow()">
				<center><strong>CLICK HERE TO RENT PRODUCTS!</strong></center>
		</div>
			</div>
		<% if(session.getAttribute("productName") != null){ %>
		<div id="rentrent">
		<br/>
			<form id="IndividualProductPage" method="POST" action="RentalServlet" onSubmit="return validateForms()">
				<table width="394" border="1">
					<tr>
						<td><strong>Name of product: &nbsp;</strong></td>
						<td><%=session.getAttribute("productName").toString() %></td>
					</tr>
					<tr>
						<td><strong>Status:&nbsp;&nbsp; </strong> <label for="end"></label></td>
						<td><%=session.getAttribute("status").toString()%></td>
					</tr>
					<tr>
						<td><strong>Quantity available: &nbsp;</strong></td>
						<td><%=session.getAttribute("productQuantity").toString()%></td>
										
					</tr>
					
					<tr>
						<td><strong>Name: &nbsp;</strong></td>
						<td><input type="text" name="name" id="name" /></td>
					</tr>
					
					<tr>
						<td><strong>NRIC: &nbsp;</strong></td>
						<td><input type="text" name="nric" id="nric" /></td>
					</tr>

					<tr>
						<td><strong>Quantity for rent: &nbsp;</strong></td>
						<td><input type="text" name="rentalQuantity" id="quantity" /></td>
					</tr>
					<tr>
						<td><strong>Rental Start Date:</strong> <label for="start2"></label></td>
						<td><input type="text" name="startDate" id="start" /></td>
					</tr>
					<tr>
						<td><strong>Rental End Date:&nbsp;&nbsp; </strong> <label
							for="end"></label></td>
						<td><input type="text" name="endDate" id="end" /></td>
					</tr>

					<tr>
						<td><input type="submit" name="button" id="button"
							class="button" value="Submit"/></td>
						<!--onclick="confirm( 'Are you sure you want to rent these items?' )"  -->
						<td><input type="reset" value="Clear" class="button"
							id="button" name="clearAll" /></td>
					</tr>
				</table>
				<br/><br/>
			</form>

		</div>
				<%}else{} %>
		<%}else{}%>
	
	</div>
</div>
</body>
</html>