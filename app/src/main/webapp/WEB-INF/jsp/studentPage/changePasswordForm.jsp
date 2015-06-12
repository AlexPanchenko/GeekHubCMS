<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--Modal window for change password--%>

<div id="change-password" class="modal fade">
    <div class="modal-dialog text-black">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Change password</h4>
            </div>
            <form id="changePwd">
                <input type="hidden" id="user-id" value="${user.id}">
                <div class="modal-body form-horizontal">
                    <div class="form-group">
                        <label for="oldPassword" class="col-sm-3 control-label">Current password</label>

                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="oldPassword" placeholder="Current password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newPassword" class="col-sm-3 control-label">New password</label>

                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="newPassword" placeholder="New password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword" class="col-sm-3 control-label">Confirm</label>

                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="confirmPassword"
                                   placeholder="Confirm password">
                        </div>
                    </div>
                    <div class="text-center">
                        <span class="text-info" id="change-status"></span>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Confirm</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/student/changePassword.js"/> "></script>