<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Questions</title>
<link rel="stylesheet" type="text/css" href="styles/Project.css">
<script type="text/javascript" language="javascript"></script>
</head>
<body>

	<div id="layout">
		<div id="heading">
			<img src="images/question.jpg" width="53" height="50" /> Add A Question
		</div>

		<form id="createQuestion" method="GET" action="retrieveAS">
						Topic &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<select name="topicDDL" id="topicDDL">
								<option value="Elderly">Elderly</option>
								<option value="Diabetes">Diabetes</option>
								<option value="Heart Diseases">Heart Diseases</option>
								<option value="Stroke">Stroke</option>
								<option value="Asthma">Asthma</option>
							</select>
					<h2> Subject&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="subject" id="subject" /> </h2>
					
					<h2>Question&nbsp; <textarea name="question" id="question" cols="20" rows="5"></textarea> </h2>

					<input type="submit" name="SubmitButton" id="SubmitButton" value="Submit" /> 
					<input type="submit" name="CloseButton" id="CloseButton" value="Close" />
		</form>
	</div>

</body>
</html>