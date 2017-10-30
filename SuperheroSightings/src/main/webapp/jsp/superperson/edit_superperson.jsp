<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Location</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/herostyling.css" rel="stylesheet">

<%
	String superPersonId = request.getParameter("SuperPersonId");
%>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-5 col-xs-offset-2">
				<h1 id="titleHead">Edit SuperPerson</h1>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-xs-5 col-xs-offset-3">
				<div class="alert alert-danger alert-dismissable"
					id="validationError" style="display: none;">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				</div>
				<div class="alert alert-success alert-dismissable" id="successMsg"
					style="display: none;">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				</div>

			</div>
		</div>
		<div class="row">
			<form id="createOrganizationForm" method="post" class="form-horizontal">
				<div class="form-group">
					<label class="col-xs-3 control-label"> Name </label>
					<div class="col-xs-5">
						<input type="text" class="form-control" name="Name" id="name"
							placeholder="Enter Date" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-xs-3 control-label"> Description</label>
					<div class="col-xs-5">
						<input type="text" class="form-control" name="Description" id="description"
							placeholder="Enter Description" />
					</div>
				</div>
                               
                                <div class="form-group">
                <label class="col-xs-3 control-label"> Good or Evil? </label>
                <div class="col-xs-5 inputGroupContainer">
                    <div class="input-group">
        <input type="radio" name="Choice" value="Good" />  Good<br />
        <input type="radio" name="Choice" value="Evil"/>  Evil<br />
                    </div>
                </div>
            </div>

				<div class="form-group">
					<div class="col-xs-5 col-xs-offset-3">
						<button type="button" class="btn btn-default" id="btnCancel">Cancel</button>
						<button type="submit" class="btn btn-default" id="btnCreateDvd">Save Changes</button>
					</div>
				</div>
			</form>
		</div>
		<!-- Main Page Content Start -->

		<!-- Main Page Content Stop -->
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
<script>

</script>
