<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Questions</title>
</head>
<body>
	<div id="layout">
		<div id="heading">
			<img src="images/question.jpg" width="53" height="50" /> Add A
			Question
		</div>
		<div id="createTitle">
			<h2>
				Topic &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select name="topicDDL"
					id="topicDDL">
					<option value="Elderly">elderly</option>
					<option value="Diabetes">Diabetes</option>
					<option value="Heart Diseases">Heart Diseases</option>
					<option value="Stroke">Stroke</option>
					<option value="Asthma">Asthma</option>
				</select>
			</h2>
			<form id="form2" name="form2" method="post" action="">
				<label for="topicDDL"></label>
			</form>
		</div>
		<div id="createSubject">
			<h2>
				Subject&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
					name="SubjectTextField" id="SubjectTextField" />
			</h2>
		</div>
		<div id="createQuestion">
			<h2>
				Question&nbsp;
				<textarea name="QuestionTextArea" id="QuestionTextArea" cols="45"
					rows="5"></textarea>
			</h2>
			<form id="form1" name="form1" method="post" action="">
				<label for="QuestionTextArea"></label> <input type="submit"
					name="SubmitButton" id="SubmitButton" value="Submit" /> <input
					type="submit" name="CloseButton" id="CloseButton" value="Close" />
			</form>
		</div>
	</div>
</body>
</html>