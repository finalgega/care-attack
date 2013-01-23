<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/Project.css">
<link rel="stylesheet" type="text/css" href="styles/layout.css">

<script type="text/javascript" src="scripts/tinybox.js"></script>
<title>Main Blog Page</title>
</head>


<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="layout">
		<div id="heed">
			<h2>Giving Support to the Caregivers Blog</h2>
			<h4>A blog written by caregivers , or the special someone that
				gives caregivers the moral support, and encouragement they need, and
				thats YOU</h4>
		</div>

		<div id="image">
			<img src="images/care.jpg" width="750" height="140px" />
		</div>

		<div id="blogcontent">
			<img src="images/button.png" onclick="TINY.box.show('CreateBlogPost.jsp',1,220,160,1)"  width="150" height="50"/>
		
			<%@ page import="blog.*, java.util.*" %>
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
					by &nbsp; <a href="#"><%=create.getUsername()%></a>
				</p>
			</div>
			<p><%=create.getContent()%></p>
			
			<p><input type="button" value="Create Comment" id="commentButton" onclick="TINY.box.show('CommentBox.jsp',1,220,160,1)" >
			</p>
			<hr>
			
			<%
				}
			%> <%
 	} else{
 		String words = request.getParameter("searchName");
 		ArrayList<BlogPost> retrieveSearch = new ArrayList<BlogPost>();
 		retrieveSearch = (ArrayList<BlogPost>) session
 				.getAttribute("searchResult");
 		BlogPost retrieve = new BlogPost();
 		for (int i = 0; i < retrieveSearch.size(); i++) {
 			retrieve = retrieveSearch.get(i);
 %>
			<h2><%=retrieve.getTitle()%></h2>
			<div id="datesetting">
				<p><%=retrieve.getDate()%>
					by &nbsp; <a href="#"><%=retrieve.getUsername()%></a>
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
							ArrayList<BlogPost> categoriesTitle = new ArrayList<BlogPost>();
							BlogPost createTitle = new BlogPost();
							categoriesTitle = createTitle.retrieveBlogTitle();
						%>


					<article>
					<h1>Categories</h1>
				</div>

				<%
							 for (int i = 0; i < categoriesTitle.size(); i++) {
									createTitle = categoriesTitle.get(i);
							%>

				<p>
					<a href="#"><%=createTitle.getTitle()%></a>
				</p>


				<% } %>


				</article>
			</div>

			<div id="toprated">
				<div id="headingforsidebar">
					<%@ page import="blog.*,java.util.*"%>
					<%
					
						ArrayList<BlogPost> retrieveTopPosts = new ArrayList<BlogPost>();
						BlogPost bp = new BlogPost();
						retrieveTopPosts = bp.retrieveTopRatedBlogTitle();
					%>
					<article>
					<h1>Top Rated Posts</h1>
				</div>
				<%
					for (int i = 0; i < retrieveTopPosts.size(); i++) {
						bp = retrieveTopPosts.get(i);
				%>

				<p>
					<%=bp.getTitle()%>
					&nbsp; &nbsp;
					<%=bp.getCount()%>
					comments
				</p>

				<%
					}
				%>

				</article>
			</div>


			<div id="archive">
				<div id="headingforsidebar">
					<%@ page import="blog.*,java.util.*"%>
					<%@ page import="util.*"%>
					<%
						ArrayList<archive> retrieveYearMonth = new ArrayList<archive>();
						archive ym = new archive();
						retrieveYearMonth = ym.trytry();
					%>

					<article>
					<h1>Archive</h1>
				</div>
				<%
					for (int k = 0; k <retrieveYearMonth.size(); k++) {
						ym = retrieveYearMonth.get(k);

				%>


				<p>
					<a href="#"><%=ym.getDate()%></a> &nbsp;&nbsp;
				</p>


				<%
					}
				%>

				</article>
			</div>
		</div>

	</div>

</body>
</html>