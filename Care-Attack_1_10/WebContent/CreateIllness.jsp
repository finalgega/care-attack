<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Illness</title>
</head>
<body>
<form action="IllnessServlet" method="post" name="illnessRegistration">
<table>
<tr>
<th>Illness Name : </th>
<td><input type="text" name="illnessName" id="illnessName" placeholder="Name of illness"/>
</tr>
<tr>
<th>Category : </th>
<td>
<select name="illnessCategory">
<option>Cardiovascular</option>
<option>Neuromuscular</option>
<option>Respiratory</option>
<option>Musculoskeletal</option>
<option>Metabolic</option>
<option>Skin</option>
<option>Eye</option>
<option>Ear</option>
<option>Congenital</option>
<option>Nervous System</option>
<option>Endocrine</option>
<option>Virus</option>
<option>Parasitic</option>
<option>Bacterial</option>
</select>
</td>
</tr>
<tr>
<th>Illness Description : </th>
<td><input type="text" col=5 /></td>
</tr>
<tr>
<th>Severity *If Applicable*</th>
<td><input type="text" name="severity"/></td>
<tr/>
<tr>
<td><input type="submit" value="Create Illness"/>
</tr>
</table>
</form>
</body>
</html>