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
	
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Rambla"/>
		
<link rel="stylesheet" type="text/css" href="styles/header.css" />
<link rel="stylesheet" type="text/css" href="styles/IndividualPage.css" />
<title>Rental Services</title>
<script language="JavaScript" src="scripts/ts_picker.js">

//Script by Denis Gritcyuk: tspicker@yahoo.com
//Submitted to JavaScript Kit (http://javascriptkit.com)
//Visit http://javascriptkit.com for this script

</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<script language="JavaScript">
		function clear() {
			$("#IndividualProductPage").prop('input')
		}
		
		function Validate()
		{
		if(document.getElementById('list').selectedIndex == 0)
		{
		alert("Please select a product.");
		return false;
		}
		return true;
		}
		
		function hideshow() {
		    var toggle = document.getElementById('rentrent');
		    toggle.style.display = toggle.style.display == "block" ? "none" : "block";
		}

		function validateForms() {
			var name = document.forms["IndividualProductPage"]["name"].value;
			var nric = document.forms["IndividualProductPage"]["nric"].value;
			var phone = document.forms["IndividualProductPage"]["phone"].value;
			var quantity = document.forms["IndividualProductPage"]["quantity"].value;
			var end = document.forms["IndividualProductPage"]["endDate"].value;
			

			if (name == null || name == "") {
				alert("Please enter your name!");
				return false;
			} 
			
			else if (nric == null || nric == "") {
				alert("Please enter your NRIC!");
				return false;
			} 
			
			else if (phone == null || phone == "") {
				alert("Please enter your phone number!");
				return false;
			} 
			
			else if (quantity == null || quantity == "") {
				alert("Please enter the rental quantity!");
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


	<%@ page import="entity.*, util.*, java.util.*"%>
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
			select the items that you want to view and log in to rent the products!<br/> If the product is faulty, please let us know as soon as possible.</h3>
		<div id="rent">

			<form id="retrieveProducts" name="retrieveProducts" method="get" action="RentalServlet">
						<%
							ArrayList<Products> p = new ArrayList<Products>();
							Products pro = new Products();
							CalendarC c = new CalendarC();
							p = pro.retrieveData();
						%>
					
				<table width="302" border="1" style="width: 410px;">
					<tr>
						<td width="132" style="width: 464px;"><h3><strong>Product Name:&nbsp; </strong></h3></td>
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
							id="button" class="button" value="Submit" onclick="return Validate()" /></td>
							
					</tr>
				</table>
			</form>
			<br />
			<% if(session.getAttribute("productName") != null){ %>
				<div id="info">
				<div id="words">
					<div id="name">
						<h3 id="3"><%=session.getAttribute("productName").toString()%></h3>
					</div>
					<p id="4"><%=session.getAttribute("productDescription").toString()%></p>
				</div>
				<%if(session.getAttribute("imageID") != null) {
					Image img = new Image();
					int imgID = (Integer)session.getAttribute("imageID");
					%>
				<img id="productImage" src="<%=img.getImagePath(imgID) %>" height="240px" width="240px"/>
			
				<%}else{System.out.println(pro.getImageID());} %>
				
				<%} else { %>
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
			<form id="IndividualProductPage" method="POST" action="RentalServlet" name="test" onSubmit="return validateForms()">
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
						<td><strong>Price: &nbsp;</strong></td>
						<td>$<%=session.getAttribute("price").toString()%></td>
										
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
						<td><strong>Phone Number: &nbsp;</strong></td>
						<td><input type="text" name="phone" id="phone" /></td>
					</tr>
					<tr>
						<td><strong>Quantity for rent: &nbsp;</strong></td>
						<td><input type="text" name="rentalQuantity" id="quantity" /></td>
					</tr>
					<tr>
						<td><strong>Rental Start Date:</strong> <label for="start2"></label></td>
						<td><input type="text" name="startDate" value="<%=c.getCurrentDate()%>" id="startDate" readonly/></td>
					</tr>
					<tr>
						<td><strong>Rental End Date:&nbsp;&nbsp; </strong> <label
							for="end"></label></td>
						<td><input type="text" name="endDate" id="endDate" value="" readonly><a href="javascript:show_calendar('document.test.endDate', document.test.endDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a></td>
	

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