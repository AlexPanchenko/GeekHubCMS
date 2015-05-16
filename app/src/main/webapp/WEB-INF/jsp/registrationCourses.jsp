<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>registration on courses</title>
</head>
<body>
<div>
    registr courses

    <h2>REGISTRATION COURSES</h2>
    <form method="post" action="/registrationCourses">
<c:forEach items="${listCourses}" var="course">


        <div>
            <p>${course.id}</p>
            <p>${course.name}</p>
            <p>${course.description}</p>
            <input type="checkbox" name="courseId" value="${course.id}"/>

        </div>

</c:forEach>
        <button type="submit">Save</button>
    </form>

</div>
</body>
</html>
