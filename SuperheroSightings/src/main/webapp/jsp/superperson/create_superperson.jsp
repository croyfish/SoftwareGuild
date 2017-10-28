<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create SuperPerson</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-3 col-xs-offset-2">
            <h1>Create SuperPerson</h1>
        </div>
    </div>
    <hr/>
    <div class="row">
        <div class="col-xs-5 col-xs-offset-3">
            <div class="alert alert-danger alert-dismissable" id="validationError"
                 style="display:none;">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            </div>
            <div class="alert alert-success alert-dismissable" id="successMsg"
                 style="display:none;">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            </div>

        </div>
    </div>
    <div class="row">
        <form id="createLocationForm" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-xs-3 control-label"> Name </label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="name" id="title"
                           placeholder="Enter Name"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label"> Description </label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="description" id="year"
                           placeholder="Enter Description"/>
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
            
            
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-5 col-xs-offset-3">
                    <input type="hidden" name="nameHidden" value="">
                    <input type="hidden" name="addressHidden" value="">
                    <input type="hidden" name="latitudeHidden" value="">
                    <input type="hidden" name="longitudeHidden" value="">
                    <button type="button" class="btn btn-default" id="btnCancel">Cancel</button>
                    <button type="submit" class="btn btn-default" id="btnCreateDvd">Create
                        SuperPerson
                    </button>
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
