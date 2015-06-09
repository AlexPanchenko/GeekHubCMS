<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-lg-offset-2 col-md-offset-2 " style="width: 600px;">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">${user.firstName}&nbsp&nbsp${user.lastName}</h3>
                    </div>
                    <div class="row">
                        <div class="col-md-3 col-lg-3 col-lg-offset-1 col-md-offset-1"><img alt="User Pic"
                                                                                            src="<c:url value='/resources/img/vysaur.png'/>"
                                                                                            class="img-rounded"
                                                                                            width="170"
                                                                                            style="margin-top: 40px;margin-left: -20px;">
                        </div>

                        <div class="col-md-6 col-lg-6 col-lg-offset-1 col-md-offset-1">
                            <table class="table table-user-information text-black">
                                <tbody>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="${user.email}">${user.email}</a></td>
                                </tr>
                                <tr>
                                    <td>Registrtion date:</td>
                                    <td>${user.registrationDate}</td>
                                </tr>
                                <tr>
                                    <td>Date of Birth</td>
                                    <td>${user.birthDay}</td>
                                </tr>
                                <tr>
                                    <td>Skype</td>
                                    <td>${user.skype}</td>
                                </tr>
                                <td>Phone Number</td>
                                <td>${user.phoneNumber}</td>
                                </tr>

                                </tbody>
                                </tbody>
                            </table>
                            <a href="#feedbackForm" class="btn btn-success pull-right" data-toggle="modal">Send FeedBack</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /#page-content-wrapper -->
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
                    <textarea id="feedbackText" type="text" cols="68" rows="5" name="feedback"
                              placeholder="Write feedback here..."></textarea>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Save feedback</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    var userId = ${user.id};
</script>

<script src="<c:url value="/resources/js/shared/sendFeedback.js"/> "></script>
<script src="<c:url value="/resources/js/teacher/userProfile.js"/> "></script>
</body>
</html>
