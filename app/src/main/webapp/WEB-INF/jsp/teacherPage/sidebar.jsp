<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Sidebar -->
<div id="sidebar-wrapper">
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="text-center" style="margin-top: -15px" >
                    <h3>Teacher Panel</h3>
                </li>
                <li>
                    <a href="/teacher/registrationCourses" class="text-left">Students</a>
                </li>
                <li>
                    <a href="#" class="text-left">Classrooms</a>
                </li>
                <li>
                    <a href="/teacher/testing/selectCourse" class="text-left">Tests</a>
                </li>
                <li>
                    <a href="/teacher/teacherPage" class="text-left">Teacher Profile</a>
                </li>

            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
</div>