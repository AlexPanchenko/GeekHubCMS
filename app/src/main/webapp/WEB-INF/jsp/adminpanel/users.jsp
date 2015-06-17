<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>User edit page</title>


    <jsp:include page="../source.jsp"></jsp:include>
    <!-- /#wrapper -->
</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center">
                        <a href="/admin/createUser" class="pull-right glyphicon glyphicon-plus" title="Create new user"></a>
                        <b>Users manage</b></h1>
                    <table class="table text-black">
                        <div id="rows" class="col-lg-12">
                        </div>
                    </table>
                    <div class="text-center">
                        <nav>
                            <c:if test="${pagesCount > 1}">
                            <ul id="course" class="pagination" data-pages-count="${pagesCount}">
                                <li>
                                    <a href="#" aria-label="Previous" id="prev-page">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>

                                <c:forEach var="page" begin="1" end="${pagesCount}">
                                    <li><a href="#" class="page-number" id="page${page}">${page}</a></li>
                                </c:forEach>

                                <%--<div class="pagination-pages">--%>

                                <%--</div>--%>
                                <li>
                                    <a href="#" aria-label="Next" id="next-page">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                            </c:if>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- /.col-lg-12 -->

            <div class="comment-box"></div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.row -->
</div>
<!-- /.container-fluid -->
</div>

<div id="feedbackForm" class="modal fade">
    <div class="modal-dialog text-black">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Write FeedBack</h4>
            </div>
            <form id="sendFeedback">
                <div class="modal-body">
                    <textarea id="feedbackText"type="text" cols="68" rows="5" name="feedback" placeholder="Write feedback here..."></textarea>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Save feedback</button>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../shared/deleteConfirmation.jsp"></jsp:include>
<script src="<c:url value="/resources/js/shared/feedbacks.js"/>"></script>
<script src="<c:url value="/resources/js/pagination.js"/>"></script>
<script src="<c:url value="/resources/js/shared/users.js"/>"></script>
</body>
</html>

