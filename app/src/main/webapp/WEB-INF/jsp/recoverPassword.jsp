<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="<c:url value='/resources/vendors/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div style="margin-top: 200px"></div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h3 class="text-center">RecoverPassword</h3>
                        <p>Write new password</p>
                        <div class="panel-body">

                            <form class="form" action="/recoverPassword/${passwordId}/${link}" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-key"></i></span>
                                            <!--EMAIL ADDRESS-->
                                            <input id="emailInput" class="form-control" type="password" name="recoverPassword" oninvalid="setCustomValidity('Please enter a new password!')" onchange="try{setCustomValidity('')}catch(e){}" required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input class="btn btn-lg btn-primary btn-block" value="new password" type="submit" name="recoverPassword">
                                    </div>
                                </fieldset>
                            </form><!--/end form-->

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
