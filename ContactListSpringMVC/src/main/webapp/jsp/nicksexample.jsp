<%-- 
    Document   : categories
    Created on : Nov 6, 2017, 7:40:44 PM
    Author     : matt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roles</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        <!-- {pageContext.request.contextPath}/{currentPage.title} don't forget to replace the dollar signs-->
        
            <div class="navbar col-md-12">
                <ul class="nav nav-tabs" >
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/blogs/displayCreateBlog">Blog Details</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/categories/">Category Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/roles/">Role Home</a>
                    </li>
                    <c:forEach items="${rpvm.staticPageList}"
                               var="currentPage">
                        <li role="presentation"> <!-- not sure about page names yet -->
                            <a href="${pageContext.request.contextPath}/${currentPage.title}">
                                <c:out value="${currentPage.title}"/>
                            </a>
                        </li>
                    </c:forEach>
                </ul>    
            </div>
        


        <h1>Hello Roles!</h1>


       
        <div class="row">
        <div id="rolesTableDiv" class="col-sm-6">
                    <h2> Roles</h2>

                    <table id="rolesTable" class="table table-hover">
                      <tr>
                        <th width="40%">Role Name</th>
                        <th width="15%"></th>
                        <th width="15%"></th>
                      </tr>
                    </table>


        </div>
            <div id="add-role-div" class="col-sm-6">
                            <h2> Add Role</h2>
            <form class="form-inline" role="form" id="edit-form">
                <div class="form-group">
                    <label for="add-name" class="col-md-4 control-label">
                        Role Name:
                    </label>
                    
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-name"
                               placeholder="Role Name" required/>
                    </div><br/><br/>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="button"
                                    id="add-button"
                                    class="btn btn-default">
                                Add Role
                            </button>
                        </div>
                    </div>
             
                </div>


            </form>
            </div>
        </div>
        <div id="editRole" style="display: none">
            <h2> Edit Role</h2>
            <form class="form-inline" role="form" id="edit-form">
                <div class="form-group">
                    <label for="edit-name" class="col-md-4 control-label">
                        Role Name:
                    </label>
                    <input type="hidden" id="hidden-id"/>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="edit-name"
                               placeholder="Role Name" required/>
                    </div><br/><br/>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="button"
                                    id="edit-button"
                                    class="btn btn-default">
                                Edit Role
                            </button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <button type="button"
                                    id="cancel-edit-button"
                                    class="btn btn-warning">
                                Cancel
                            </button>
                        </div>
                    </div>
                </div>


            </form>
        </div>


            

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>        
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>        
        <script src="${pageContext.request.contextPath}/js/role.js"></script>        
    </body>
</html>
