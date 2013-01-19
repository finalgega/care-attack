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
	};
</script>
	<form id="createProducts" method="POST" action="ProductServlet">
		<table>
			<tr>
				<!--  <a href="javascript:TINY.box.hide()">close it</a>-->
				<td>Quantity</td>
				<td><input type="text" name="quantity" autocomplete="off"
					formnovalidate /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="productName" id="productName"
					placeholder="Desciption" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="productDescription"
					autocomplete="off" formnovalidate /></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><input type="text" name="status" autocomplete="off"
					formnovalidate /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Post Products"
					id="postProducts" name="postProducts" /></td>
				<td><input type="reset" value="Clear" id="clearAll"
					name="clearAll" /></td>
			</tr>
		</table>
	</form>
</body>
</html>