<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Announcements</title>
<script type="text/javascript" language="javascript"></script>
</head>
<body>
	<script language="javascript">
	function clear() 
	{
		$("#createAnnouncements").prop('input')
	};
</script>
	<jsp:include page="header.jsp"></jsp:include>
	<form id="createAnnouncements" method="POST"
		action="AnnouncementServlet">
		<table>
			<tr>
				<td>Topic</td>
				<td><input type="text" name="annon-topic" id="annon-topic"
					placeholder="Topic goes here" /></td>
			</tr>
			<tr>
				<td>Announcement</td>
				<td><input type="text" name="annon-content" autocomplete="off"
					formnovalidate /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Post Announcement"
					id="postAnnouncement" name="postAnnouncement" /></td>
				<td><input type="reset" value="Clear" id="clearAll"
					name="clearAll" /></td>
			</tr>
		</table>
	</form>
</body>
</html>