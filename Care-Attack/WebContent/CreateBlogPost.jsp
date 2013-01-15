
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Blog Post</title>
</head>
<body>
	<div id="layout">
		<div id="heading">
			<img src="images/add.png" width="44" height="35" alt="Add New Post" />
			Add New Post
		</div>
		<form id="createBlogPost" method="POST" action="CreateBlogPostServlet">
			<div id="title">
				<p>
					Title &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type='text'
						id='title' name='title' />
				</p>
			</div>
			<div id="content">
				<p>Content &nbsp;&nbsp;</p>
				<textarea name="content" id="content" cols="45" rows="5"></textarea>
				<label for="content"></label>
			</div>
			<div id="insertimage">
				<p>
					Insert Image <input type="file" name="fileImage" id="fileImage" />
				</p>
				<label for="fileImage"></label>
			</div>
			<div id="publishBlogPost">
				<input type="submit" id="publish" value="Publish" /> <input
					type="button" id="close" value="Close" /> <br />
			</div>
		</form>
	</div>
</body>
</html>