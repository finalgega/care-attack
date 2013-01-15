<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/Project.css">
<title>Main Blog Page</title>
</head>
<body>
	<div id="layout">
		<div id="header">
			<h2>Giving Support to the Caregivers Blog</h2>
			<h4>A blog written by caregivers , or the special someone that
				gives caregivers the moral support, and encouragement they need, and
				thats YOU</h4>
		</div>
		<div id="image">
			<img src="images/caregiver_theme.gif" width="750" height="140px" />
		</div>
		<br />
		<div id="blogcontent">
			<%@page import="blog.*,java.util.*"%>
			<%
				if (session.getAttribute("searchResult") == null) {
			%>
			<%
				ArrayList<BlogPost> retrievePost = new ArrayList<BlogPost>();
					BlogPost create = new BlogPost();
					retrievePost = create.retrieveBlogPost();
			%>
			<article> <%
				for (int i = 0; i < retrievePost.size(); i++) {
						create = retrievePost.get(i);
			%>
			<h2><%=create.getTitle()%></h2>
			<div id="datesetting">
				<p><%=create.getDate()%>
					by &nbsp; <a href="#"><%=create.getUserName() %></a>
				</p>
			</div>
			<p><%=create.getContent()%></p>
			<hr>
			<%
				}
			%> <%
 	} else {
 		String words = request.getParameter("searchName");
 		ArrayList<BlogPost> retrieveSearch = new ArrayList<BlogPost>();
 		retrieveSearch = (ArrayList<BlogPost>) session.getAttribute("searchResult");
 		BlogPost retrieve = new BlogPost();
 		for (int i = 0; i < retrieveSearch.size(); i++) {
 			retrieve = retrieveSearch.get(i);
 %>
			<h2><%=retrieve.getTitle()%></h2>
			<div id="datesetting">
				<p><%=retrieve.getDate()%>
					by &nbsp; <a href="#"><%=retrieve.getUserName() %></a>
				</p>
			</div>
			<p><%=retrieve.getContent()%></p>
			<%
				}
				}
			%> </article>
		</div>
		<div id="sidebar">
			<div id="searchengine">
				<form name="search" method="post" action="searchEngineServlet">
					<table width="239" border="1" cellpadding="5">
						<tr>
							<td width="221">Search: <input type="text" name="searchName"
								id="searchName" size="20" maxlength="50"> <input
								type="submit" value="Find" />
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="categories">
				<div id="headingforsidebar">
					<%@ page import="blog.*,java.util.*"%>
					<%
						ArrayList<BlogPost> createBlogTitle = new ArrayList<BlogPost>();
						BlogPost createTitle = new BlogPost();
						createBlogTitle = createTitle.retrieveBlogTitle();
					%>
					<article>
					<h1>Categories</h1>
				</div>
				<%
					for (int i = 0; i < createBlogTitle.size(); i++) {
						createTitle = createBlogTitle.get(i);
				%>
				<p>
					<a href="#"><%=createTitle.getTitle()%></a>
				</p>
				<%
					}
				%>
				</article>
			</div>
			<div id="toprated">
				<div id="headingforsidebar">
					<p>Top Rated Posts</p>
				</div>
				<p>
					<a href="#">Caring For Your Loved Ones</a> &nbsp; 3 comments
				</p>
				<p>
					<a href="#">Care is Important</a> &nbsp; 2 comments
				</p>
			</div>
			<div id="archive">
				<div id="headingforsidebar">
					<p>Archive</p>
				</div>
				<p>
					<a href="#">November 2012</a>
				</p>
				<p>
					<a href="#">October 2012</a>
				</p>
				<p>
					<a href="#">September 2012</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>