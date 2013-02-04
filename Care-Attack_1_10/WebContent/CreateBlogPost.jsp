
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

	<div id="layoutCreateBlogPost">

		<div id="heading">
			<img src="images/add.png" width="44" height="35" /> Add New Post
		</div>
		
		<form id="createBlogPost" method="POST" action="CreateBlogPostServlet">
				
				<p>Title: <input type="text" name="title" id="title" /> </p>
				<p>Content: <textarea name="content" rows="4" cols="13"> </textarea></p>
				<input type="submit" value="submit" />
				<input type="reset" value="Clear" id="clear" name="clear" />
		</form>
		
	</div>

</body>
</html>