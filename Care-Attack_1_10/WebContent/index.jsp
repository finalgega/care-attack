<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" "/>
<title>Welcome to Care-Attack</title>
<link href="styles/layout.css" rel="stylesheet" />
<link href="styles/index.css" rel="stylesheet" />
<script src="scripts/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
		<form name="uploadForm" id="uploadForm" method="POST"
			action="UploadImage" enctype="multipart/form-data">
			<input type="file" value="sy" name="sy"></input> <input type="submit" />
		</form>
		<%@ page import="announcements.*,java.util.*"%>
		<%
			ArrayList<Announcement> announceArrList = new ArrayList<Announcement>();
			Announcement annon = new Announcement();
			announceArrList = annon.retrieveAnnouncement();
		%>

		<article>
			<h1>Announcements</h1>
			<%
				for (int i = announceArrList.size() - 1; i > 0; i--) {
					annon = announceArrList.get(i);
			%>

			<h2><%=annon.getaTopic()%></h2>
			<p>
				Posted on :
				<%=annon.getaDate()%></p>
			<p><%=annon.getaContent()%></p>
			<hr />
			<%
				}
			%>

		</article>
	</div>
	<div class="sideContent">
		<div class="auntSarahCorner">
			<aside>
				<h1>Auntie Sarah's Corner</h1>
				<h2>Tip Per Day</h2>
				<p>Some text here~</p>
			</aside>
		</div>
		<div id="lettersOfGratitude">
			<!--  letters of gratitude code here -->
			<h1>Letters Of Gratitude</h1>
			<div id="letters">
				<div id="appear"></div>
				<div id="text">
					<form id="form1" name="form1" method="post" action="">
						<label for="text"></label>
						<textarea name="text" id="text" cols="45" rows="5"></textarea>
						<input id="go" name="goButton" type="submit" value="Go" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>