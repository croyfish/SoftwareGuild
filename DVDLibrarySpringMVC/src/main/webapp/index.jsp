<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Main Page</title>
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel ="stylesheet" type="text/css" href="/css/dvd-library-styles.css"/>        
    </head>
    <!-- 
    The page is separated horizontally by a rule into a top row and a content area.
    The top row contains columns containing the following:
        A Create DVD link is present on the left.
        A search category select element and a search term input element are placed to the right along with a search button.
    A horizontal rule separates the top row from the bottom portion
    The bottom portion is the details area which contains a table of DVD records. The columns from left to right are Title, Release Date, Director, Rating, and an unlabled column whose rows contain edit and delete elements that are styled to look like links. The DVD titles are links that load a details view.
    -->
    <body>
        <div class="row" style="padding: 30px">
            <div class="col-md-3" style="border-style: solid; border-width: 1px;">
                <sf:form>
                    <div class="col-md-12" style="border-style: solid; border-width: 1px;">
                        <input type="submit" class="btn btn-default" value="Create DVD" style="height: 40px"/>
                    </div>
                </sf:form>                
            </div>
            <div class="col-md-9" style="border-style: solid; border-width: 1px;">
                <sf:form>
                    <div class="col-md-6" style="border-style: solid; border-width: 1px; text-align: right">
                        <input type="submit" class="btn btn-default" value="Search" style="height: 40px"/>
                    </div>
                    <div class="col-md-2" style="border-style: solid; border-width: 1px;">
                        <select name="search-category" style="height: 40px">
                            <option value="" selected disabled hidden>Search Category</option>
                            <option value="title">Title</option>
                            <option value="release-year">Release Year</option>
                            <option value="director-name">Director Name</option>
                            <option value="audi">Rating</option>
                        </select> 
                    </div>
                    <div class="col-md-4" style="border-style: solid; border-width: 1px;">
                        <input type="text" name="search-term" id="search-term" value="Search Term" style="height: 40px"/>
                    </div>
                </sf:form>  
            </div>
        </div>

        <hr style="margin-top: 1px; margin-bottom: 1px"/>

        <div class="row">
            <div class="col-md-12" style="padding: 30px">
                <table id="contactTable" class="table table-hover">
                    <tr>
                        <th width="20%">Title</th>
                        <th width="20%">Release Date</th>
                        <th width="20%">Director</th>
                        <th width="20%">Rating</th>
                        <th width="10"></th>
                        <th width="10"></th>
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
        </div>
            
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

