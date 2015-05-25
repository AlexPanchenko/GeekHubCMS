<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
Hello world! It's index page
<security:authorize access="hasAnyRole('ROLE_STUDENT','ROLE_TEACHER','ROLE_ADMIN')">
    <a href="/logout">Log out</a>
    <a href="/student/registrationCourses">Registration on Courses</a>
    <a href="/student/test/selectCourse">Test</a>
    <security:authentication property="principal.username"/>
</security:authorize>
<security:authorize access="hasRole('ROLE_ANONYMOUS')">
<a href="/auth">Log In</a>
    </security:authorize>
</body>
</html>
