<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Sidebar -->
<div id="sidebar-wrapper">
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="text-center" style="margin-top: -15px" >
                    <h3>User Panel</h3>
                </li>
                <li>
                    <a href="/student/registrationCourses" class="text-left">Registration on course</a>
                </li>
                <li>
                    <a href="/student/testing/assignmentTest" class="text-left">Starting test</a>
                </li>
                <li>
                    <a href="/student/userProfile" class="text-left">Profile</a>
                </li>

            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
</div>
