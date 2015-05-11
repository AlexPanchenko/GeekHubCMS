<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>GeekHub</title>
	<%@include file="../common/cssResources.jsp"%>
</head>

<body>
    <div class="clearfix page-wrap fixed-header">
		<tiles:insertAttribute name="header"/>
		<div class="container-fluid">
			<div class="row">
				<tiles:insertAttribute name="sideNav"/>
				<section class="col-xs-10 col-xs-offset-2 page-content-wrap">
					<tiles:insertAttribute name="content"/>
                    <div id="spinnerContainer"/>
                </section>
			</div>
		</div>
		<tiles:insertAttribute name="footer"/>
	</div>
    <%@ include file="../common/validationMessages.jsp"%>
	<%@ include file="../common/jsResources.jsp"%>

	<tiles:insertAttribute name="bottom" ignore="true"/>
</body>
</html>