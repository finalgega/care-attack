<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script language="javascript">
	function clear() 
	{
		$("#createComments").prop('input')
	};
</script>
	<div id="layoutCreateComments">

		<!-- <div id="heading">
			<img src="images/add.png" width="44" height="35" /> Add New Post
		</div>
 -->
		<form id="createComments" method="POST" action="CreateCommentsServlet">
			<div id="title">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Comments &nbsp;  <input type='text' id='comments' name='comments' /> </p>
			</div>
			<div id="button">
				<input type="submit" id="publish" value="Publish" /> 
			</div>
		</form>
		
	</div>

</body>
</html>