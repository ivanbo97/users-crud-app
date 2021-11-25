<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<h1>Edit User Info</h1>
	<form action="updateUser" method="post">
		<input type="hidden" name="id" value=${applicationScope.user.id} />
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname" value=${applicationScope.user.firstName} /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"
					value=${applicationScope.user.lastName} /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>

</body>
</html>