<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Products</title>
<script type="text/javascript" language="javascript"></script>
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Paprika" />
	<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Shadows Into Light Two" />
<link rel="stylesheet" type="text/css" href="styles/index.css" />
<link rel="stylesheet" type="text/css" href="styles/createProd.css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<script language="javascript">
		function clear() {
			$("#createProducts").prop('input')
		}

		function validateForms() {
			var qty = document.forms["createProducts"]["quantity"].value;
			var name = document.forms["createProducts"]["productName"].value;
			var desc = document.forms["createProducts"]["productDescription"].value;
			var status = document.forms["createProducts"]["status"].value;

			if (name == null || name == "") {
				alert("Please enter the product name!");
				return false;
			}

			else if (desc == null || desc == "") {
				alert("Please enter the product description!");
				return false;
			}

			else if (qty == null || qty == "") {
				alert("Please enter the product quantity!");
				return false;
			}
			
			else if (qty < 50) {
				alert("Product quantity must be >= 50!");
				return false;
			}
			

			else if (status == null || status == "") {
				alert("Please enter the product status!");
				return false;
			}
			
			else if ((status !== "available")&&(status !== "Available")&&(status !== "AVAILABLE")){
				alert("Product status is AVAILABLE");
				return false;
			}

			else {
				alert("Product successfully created!");
			}
		}
	</script>
	<div class="content">
	<br />
	<center>
		<h2 id="text">CREATE PRODUCTS!</h2>
	</center>
	<div id="img"><img src="images/heart.png"/></div>
	
	<form id="createProducts" method="POST" action="ProductServlet"
		onSubmit="return validateForms()">
		<div id = "table1">
		<table>
			<tr>
				<td><h3>Name:</h3></td>
				<td><input type="text" name="productName" id="productName"/></td>
			</tr>

			<tr>
				<td><h3>Description:</h3></td>
				<td><textarea name="productDescription" id="productDescription"></textarea></td>
			</tr>
			<tr>
				<td><h3>Quantity:</h3></td>
				<td><input type="text" name="quantity" id="quantity"/></td>
			</tr>
			<tr>
				<td><h3>Status:</h3></td>
				<td><input type="text" name="status" id="status"/></td>
			</tr>
			</table>
			<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Create!" id="button" name="button" class="button" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" class="button" id="clearAll" name="clearAll" />
					</div>
	</form>
			
				
	</div>

</body>
</html>