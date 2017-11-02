<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Super Person</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/herostyling.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-10 col-xs-offset-2">
                    <h1>Update Super Person</h1>
                </div>
            </div>
            <hr/>

            <div class="row">
                <sf:form id="updateSuperPersonForm" class="form-horizontal" commandName="uspcm"
                      action="${pageContext.request.contextPath}/superperson/updateSuperPerson" method="POST">
                    <input type="hidden" value="${spvm2.superPerson.superPersonId}" name="superPersonId">
                    <div class="form-group">
                        <label class="col-xs-3 control-label"> Name </label>
                        <div class="col-xs-5">
                            <sf:errors path="name" cssclass="error"></sf:errors>
                            <input type="text" class="form-control" name="name" path="name"
                                   value="${spvm2.superPerson.name}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3 control-label"> Powers </label>
                        <div class="col-xs-5">
                            <sf:errors path="powers" cssclass="error"></sf:errors>
                            <select multiple name="powers" form="updateSuperPersonForm" path="powers">
                                <c:forEach
                                    items="${spvm2.powers}" 
                                    var="currentPower" 
                                    varStatus="loop">
                                    <option selected="true" value="${currentPower.powerId}" >${currentPower.name}</option>
                                </c:forEach>
                                <c:forEach
                                    items="${doesntHavePowers}" 
                                    var="currentPower" 
                                    varStatus="loop">
                                    <option  value="${currentPower.powerId}" >${currentPower.name}</option>
                                </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-3 control-label"> Organizations </label>
                            <div class="col-xs-5">
                                <sf:errors path="organizations" cssclass="error"></sf:errors>
                                <select multiple name="organizations" form="updateSuperPersonForm" path="organizations">
                                <c:forEach
                                    items="${spvm2.organizations}" 
                                    var="currentOrganization" 
                                    varStatus="loop">
                                    <option selected="true" value="${currentOrganization.organizationId}">${currentOrganization.name}</option>
                                </c:forEach>
                                 <c:forEach
                                    items="${doesntHaveOrganizations}" 
                                    var="currentOrganization" 
                                    varStatus="loop">
                                    <option value="${currentOrganization.organizationId}">${currentOrganization.name}</option>
                                </c:forEach>
                                </select>
                            </div>
                        </div>            
                        <div class="form-group">
                            <label class="col-xs-3 control-label"> Description </label>
                            <div class="col-xs-5">
                                <sf:errors path="descriptionpowers" cssclass="error"></sf:errors>
                                <textarea rows ="10" type="textarea" class="form-control" name="description" path="description"
                                          >${spvm2.superPerson.description}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-3 control-label"> Good or Evil? </label>
                            <sf:errors path="reputation" cssclass="error"></sf:errors>
                            <div class="col-xs-5 inputGroupContainer">
                                <div class="input-group">
                                    <input <c:if test="${spvm2.superPerson.isGood}">checked = "checked"</c:if>  type="radio" name="reputation" value="good" path="reputation"/>  Good<br />
                                    <input <c:if test="${not spvm2.superPerson.isGood}">checked = "checked"</c:if> type="radio" name="reputation" value="evil" path="reputation"/>  Evil<br />
                                    <input type="radio" name="reputation" value="unknown" path="reputation"/> Unknown<br />
                                </div>
                            </div>
                        </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-5 col-xs-offset-3">
                    <button type="submit" class="btn btn-default" id="btnCreateSuperPerson">Save Edit</button>
                    <button type="submit" class="btn btn-default" id="btnCancel" formaction="${pageContext.request.contextPath}/superperson/superpersons" formmethod="GET">Cancel</button>
                </div>
            </div>
        </sf:form>
            </div>
    <!-- Main Page Content Start -->
    <!-- Main Page Content Stop -->
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>