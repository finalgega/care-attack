<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Products</title>
<script type="text/javascript" language="javascript"></script>
</head>
<body>
	
<script language="javascript">
	function clear() 
	{
		$("#createProducts").prop('input')
	}
	
	function validateForms() {
		var qty = document.forms["createProducts"]["quantity"].value;
		var name = document.forms["createProducts"]["productName"].value;
		var desc = document.forms["createProducts"]["productDescription"].value;
		var status = document.forms["createProducts"]["status"].value;
		
		if (qty == null || qty =="") {
			alert("Please enter the product quantity!");
			return false;
		}
		else if (name == null || name =="") {
			alert("Please enter the product name!");
			return false;
		}
		
		else if (desc == null || desc =="") {
			alert("Please enter the product description!");
			return false;
		}
		
		else if (status == null || status =="") {
			alert("Please enter the product status!");
			return false;
			
		}
		
		else{
			alert("Product successfully created!");
		}
	}
	

</script>
	<form id="createProducts" method="POST" action="ProductServlet" onSubmit="return validateForms()">
		<table>
			<tr>
				<!--  <a href="javascript:TINY.box.hide()">close it</a>-->
				<td>Quantity</td>
				<td><input type="text" name="quantity" id="quantity" autocomplete="off"
					formnovalidate="formnovalidate" placeholder="Numberic digits" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="productName" id="productName"
					placeholder="Name of products" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="productDescription" id="productDescription"
					autocomplete="off" formnovalidate placeholder="Description of products"/></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><input type="text" name="status" id ="status" autocomplete="off"
					formnovalidate placeholder="Available/Unavailable" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create!" id="postProducts" name="postProducts"/></td>
				<td><input type="reset" value="Clear" id="clearAll" name="clearAll" /></td>
			</tr>
		</table>
	</form>
</body>
</html>