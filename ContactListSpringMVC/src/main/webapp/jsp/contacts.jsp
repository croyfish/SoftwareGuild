<%-- 
    Document   : contacts
    Created on : Oct 5, 2017, 9:59:59 AM
    Author     : jeffc
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contacts</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Contact List Spring MVC</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                	<li role="presentation"><a href="${pageContext.request.contextPath}/displaySearchPage">Search Page</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayContactsPage">Contacts</a></li>
                </ul>   
            </div>
            <h2>Company Contacts</h2>
            <!-- Content goes here!!!! -->
            <div class="row">
                <div class="col-md-6">
                    <h2>My Contacts</h2>
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="40%">Contact Name</th>
                            <th width="30%">Company</th>
                            <th width="15"></th>
                            <th width="15"></th>
                        </tr>
                        <c:forEach var="currentContact" items="${contactList}">
                            <tr>
                                <td>
                                    <a href="displayContactDetails?contactId=${currentContact.contactId}">
                                    <c:out value="${currentContact.firstName}" /> <c:out value="${currentContact.lastName}" />
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${currentContact.company}" />
                                </td>
                                <td>
                                    <a href="displayEditContactForm?contactId=${currentContact.contactId}">
                                    Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteContact?contactId=${currentContact.contactId}">
                                    Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Add New Contact</h2>
                    <form class="form-horizontal" role="form" method="POST" action="createContact">
                        <div class="form-group">
                            <label for="add-first-name" class="col-md-4 control-label">First Name</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="firstName" id="add-first-name" placeholder="First Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-last-name" class="col-md-4 control-label">Last Name</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="lastName" id="add-last-name" placeholder="Last Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-company" class="col-md-4 control-label">First Name</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="company" id="add-company" placeholder="Company"/>
                            </div>
                        </div>                        
                        <div class="form-group">
                            <label for="add-email" class="col-md-4 control-label">Email</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="email" id="add-email" placeholder="Email"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-phone" class="col-md-4 control-label">Phone</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="phone" id="add-phone" placeholder="Phone"/>
                            </div>
                        </div>  
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" class="btn btn-default" value="Create Contact">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>