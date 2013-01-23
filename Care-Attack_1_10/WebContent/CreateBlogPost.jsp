
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Blog Post</title>
<link rel="stylesheet" type="text/css" href="styles/Project.css">
<script type="text/javascript" language="javascript"></script>
</head>
<body>
<!-- <script language="javascript">
	function clear() 
	{
		$("#createBlogPost").prop('input')
	};
</script> -->


	<div id="layoutCreateBlogPost">

		<div id="heading">
			<img src="images/add.png" width="44" height="35" /> Add New Post
		</div>

		<form id="createBlogPost" method="POST" action="CreateBlogPostServlet">
			<div id="title">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Title: &nbsp;  <input type='text' id='title' name='title' /> </p>
			</div>
			<div id="content">
				<p>Content: &nbsp; <textarea name="content" rows="5" cols="16"> </textarea> </p>			
			</div>
			<div id="button">
				<input type="submit" id="publish" value="Publish" /> 
			</div>
		</form>
		
	</div>

</body>
</html>