<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User Form</title>
<style>
<%@include file="/resources/css/formStyle.css"%>
<%@include file="/resources/css/linksStyle.css"%>
</style>

</head>
<body>
    <c:remove var="user" scope="application" /> 
	<c:set var="formAction" value="insertUser" scope="application" />
	<jsp:include page="userInputForm.jsp"></jsp:include>
</body>
</html>
