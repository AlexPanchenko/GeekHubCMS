<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Sidebar -->
<div id="sidebar-wrapper">
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="text-center" style="margin-top: -15px" >
                    <h3> Admin Panel</h3>
                </li>
                <li>
                    <a href="/admin/users"> Users</a>
                </li>
                <li>
                    <a href="/admin/course/list"> Courses</a>
                </li>
                <li>
                    <a href="/admin/classRoomList"> ClassRoom</a>
                </li>
                <li>
                    <a href="#" class="nav-collapse" data-togle="collapse" data-target=".collapse-menu">Tests</a>
                    <ul class="collapse-menu">
                        <li>
                            <a href="/admin/testType">Test type</a>
                        </li>
                        <li>
                            <a href="/admin/testConfig"> Test config</a>
                        </li>
                        <li>
                            <a href="/admin/assignTest">Assign test </a>
                        </li>
                        <li>
                            <a href="/admin/questions">Base questions</a>
                        </li>
                        <li>
                            <a href="/admin/userTestResult">User test result</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="/admin/adminPage">Admin Profile</a>
                </li>
                <li>
                    <a href="/admin/schedulers">Schedulers</a>
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
</div>





<script src="<c:url value="/resources/js/sidebar.js" /> " type="text/javascript"></script>

