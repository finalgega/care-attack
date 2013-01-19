<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Medicine</title>
</head>
<body>
	<form>
		<table>
			<tr>
				<th>Medicine Name :</th>
				<td><input type="text" name="medicineName" />
			</tr>
			<tr>
				<th>Medicine Description :</th>
				<td><textarea name="medicineDescription"></textarea></td>
			</tr>
			<tr>
				<th>Contraindications :</th>
				<td><textarea name="contraindications"></textarea></td>
			<tr>
				<th>Instructions :</th>
				<td><textarea name="instructions"></textarea>
			</tr>
			<tr>
				<th>Times per Day :</th>
				<td><input type="text" name="timesPerDay" /></td>
			</tr>
			<tr>
				<th>Side Effects :</th>
				<td><textarea name="sideEffects"></textarea>
			</tr>
			<tr>
				<td><input type="submit" value="Create Medicine" />
			</tr>
		</table>
	</form>
</body>
</html>