<%-- 
    Document   : update_sighting
    Created on : Oct 31, 2017, 1:19:08 PM
    Author     : jeffc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html> 
<html>
    <head>
        <title>Update Sighting</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/herostyling.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-10 col-xs-offset-2">
                    <h1>Update Sighting</h1>
                </div>
            </div>
            <hr/>
            <div class="row"> <!-- form wide errors? -->

            </div>
            <div class="row">
                <sf:form id="updateSightingForm" class="form-horizontal" commandName="scm"
                         action="${pageContext.request.contextPath}/sighting/updateSighting" method="POST">
                    <input type="hidden" value="${svm.sighting.sightingId}" name="sightingId" path="sightingId"/>
                    <input type="hidden" value="${sightingToUpdate}" name="sightingToUpdate" />

                    <!-- text form for DATE -->
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Date </label>
                        <div class="col-xs-5">
                            <span><sf:errors path="date" cssclass="error"></sf:errors></span>
                            <input id="date" name="date" type="date" path="date" value="${htmlDate}"/>
                        </div>
                    </div>        

                    <!-- text form for LOCATION -->

                    <div class="form-group">
                        <label class="col-xs-3 control-label">Location </label>
                        <div class="col-xs-5">
                            <sf:errors path="description" cssclass="error"></sf:errors>
                                <select name="locationId" id="locationId" form="updateSightingForm" path="locationId">
                                <c:forEach
                                    items="${allLocations}" 
                                    var="currentLocation" 
                                    varStatus="loop">
                                    <option value="${currentLocation.locationId}"
                                            <c:if test="${currentLocation.locationId == svm.location.locationId}">
                                                selected
                                            </c:if>
                                            >${currentLocation.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-xs-3 control-label">Super Persons </label>
                        <div class="col-xs-5">
                            <select multiple name="superPersons" form="updateSightingForm" path="superPersons">
                                <c:forEach
                                    items="${allSuperPersons}" 
                                    var="currentSuperPerson">
                                    <option value="${currentSuperPerson.superPersonId}"
                                            <c:forEach
                                                items="${svm.superPersons}"
                                                var="currentKnownSuperPerson"
                                                >
                                                <c:if test="${currentSuperPerson.superPersonId == currentKnownSuperPerson.superPersonId}">
                                                    selected
                                                </c:if>
                                            </c:forEach>
                                            >
                                        ${currentSuperPerson.name}
                                    </option>
                                </c:forEach>
                            </select><span><sf:errors path="superPersons" cssclass="error"></sf:errors></span>
                            </div>
                        </div>


                    <!-- tel form for DESCRIPTION -->
                    <div class="form-group">
                        <label class="col-xs-3 control-label">Description</label>
                        <div class="col-xs-5">
                            <sf:errors path="description" cssclass="error"></sf:errors>
                                <textarea name="description" id="description" class="form-control" rows="5"
                                          path="description">${svm.sighting.description}</textarea>         
                            </div>
                        </div>

                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-5 col-xs-offset-3">
                        <button type="submit" class="btn btn-default" id="btnUpdateSighting">Update Sighting</button>
                        <button type="submit" class="btn btn-default" id="btnCancel" formaction="${pageContext.request.contextPath}/sighting/sightings" formmethod="GET">Cancel</button>
                </div>
            </div>
        </sf:form>

    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>

<!-- 
NOTES


-->