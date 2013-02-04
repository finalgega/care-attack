<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/Project.css">
<link rel="stylesheet" type="text/css" href="styles/layout.css">
<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
<script type="text/javascript" src="scripts/tinyboxupdated.js"></script>
<title>Main Blog Page</title>
</head>


<body>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
function show ()
{TINY.box.show('CreateBlogPost.jsp',1,300,150,1)}

</script>
	
	
<div id ="content">
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
		
			<hr>
			
			<div id="blogcontent">
				<img src="images/buttonBlogPost.png" onclick="show()"  width="150" height="50"	/>		
				<%@ page import="blog.*, java.util.*" %>
				
				<% if(session.getAttribute("Title") != null){ %>
				<div id="hello">
						<h2><%=session.getAttribute("Title").toString()%></h2>
	
				<div id="datesetting">
					<p><%=session.getAttribute("Dated").toString()%>
						by &nbsp; <%=session.getAttribute("BlogUsername").toString()%>
					</p>
				</div>
				
				<p><%=session.getAttribute("Content").toString()%></p>
	
				<div id="comment">
				
 				<h3>Comments </h3>
					<p> <%=session.getAttribute("AccUsernameContent").toString() %></p>

				<form id="search" name="search" method="get" action="CreateCommentsServlet">
							<input type="hidden" name = "blogid" id="blogid" value=<%= session.getAttribute("BlogID").toString()%> > 
							<textarea id="comment" name = "comment" rows = "3" cols = "50" ></textarea>
							<input type="submit" value="Create" />
				</form>
				</div>
				<%} else{ %>
				
				<%
						ArrayList<BlogPost> retrieveAllBlogPost = new ArrayList<BlogPost>();
						BlogPost retrievePost = new BlogPost();
						retrieveAllBlogPost = retrievePost.retrieveBlog();
				%>
	
				<article> 
				 <%
						for (int i = 0;i< retrieveAllBlogPost.size() ;i++) {
							retrievePost = retrieveAllBlogPost.get(i);
				%>
			
				<h2><%=retrievePost.getTitle()%></h2>
	
				<div id="datesetting">
					<p><%=retrievePost.getDate()%>
						by &nbsp; <a href="#"><%=retrievePost.getBlogUsername()%></a>
					</p>
				</div>
				
				<p><%=retrievePost.getContent()%></p>
	
				<div id="comment">
				
 				<h3>Comments </h3>
					<p> <%=retrievePost.getAccUsernameComment() %></p>
					
					 <hr/>
					 
						<form id="search" name="search" method="post" action="CreateCommentsServlet">
							<input type="hidden" name = "blogid" id="blogid" value=<%= retrievePost.getBlogid() %> > 
							<textarea id="comment" name = "comment" rows = "3" cols = "50" WRAP ></textarea>
							<input type="submit" value="Create" />
						</form>
				</div>
				<hr>
				
				<%
					}}
				%> 
			
	 		</article>

		</div>
	</div>
		<div id="sidebar">


			<div id="categories">
				<div id="headingforsidebar">
					<%@ page import="blog.*,java.util.*"%>
				
					<%
							ArrayList<BlogPost> categoriesTitle = new ArrayList<BlogPost>();
							BlogPost createTitle = new BlogPost();
							categoriesTitle = createTitle.retrieveAllBlogTitle();
						%>


					<article>
					<h1>Categories</h1>
				</div>
				<form id="retrieveCategories" name="retrieveCategories" method="get" action="retrieveArchivePostServlet">
					<h2>	Categories: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<select name="categoriesDDL" id="categoriesDDL">
							<%
							 for (int i = 0; i < categoriesTitle.size(); i++) {
									createTitle = categoriesTitle.get(i);
							%>
								<option value="<%=createTitle.getTitle()%>"><%=createTitle.getTitle()%></option>
							<% } %>
							</select>
							
							<input type="submit" id="clickit" value="Submit">
					</h2>
			</form>
				

				<a href="#"> </a>
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
								retrieveYearMonth = ym.getTheYearMonth();
							%>
						<article>
							<h1>Archive</h1>
						</div>
						
						<form id="createQuestion" method="POST" action="createQuestionsServlet">
					<h2>	Topic &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<select name="archiveDDL" id="archiveDDL">
								<%
							for (int k = 0; k <retrieveYearMonth.size(); k++) {
								ym = retrieveYearMonth.get(k);
								%>
						
						
								<option value="<%=ym.getDate()%>"><%=ym.getDate() %></option>
							
							<%
							}
						%>
							</select>
							
					</h2>
						
						
		
						</article>
				</form>
			</div>
		</div>

	</div>
	</div>

</body>
</html>