<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>

        </button>
        <a class="navbar-brand" href="/admin">Admin Panel</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

        <a href="#" enabled="false"><i class="fa" style="color:blue"></i>TODO: Principal.name</a>
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                </li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li>
                    <a href="/admin/users"><i class="fa fa-table fa-fw"></i> Users</a>
                </li>

                <li>
                    <a href="/admin/courses"><i class="fa fa-table fa-fw"></i> Courses</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table fa-fw"></i> ClassRoom</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table fa-fw"></i> Tests</a>
                </li>
                <li>
                    <a href="/admin/questions"><i class="fa fa-table fa-fw"></i>Base questions</a>
                </li>
                <li>
                    <a href="/admin/userTestResult"><i class="fa fa-table fa-fw"></i> User test result</a>
                </li>

            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>

