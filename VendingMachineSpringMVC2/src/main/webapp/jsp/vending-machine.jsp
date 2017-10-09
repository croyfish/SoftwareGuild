<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/css/vending-machine-styles.css" rel="stylesheet"/>
        <style>
            #box${selectionString} {
            background-color: yellow;
            }
        </style>      
    </head>
    <body>
        <div class="row" style="background-color: black; text-align: center"><a onclick="getWeather()"><img src="images/snacks.jpg" width="200px"></a></div>

        <div class="row">
                <div class="col-md-8" style="background-color: brown">
                    <sf:form class="form-horizontal" role="form" modelAttribute="selectionString"
                             action="selectItem" method="POST">  
                        <div class="row" style="text-align: center">
                            <c:forEach var="currentItem" items="${itemList}">
                                <div class="col-md-4">
                                    <button type="submit" class="slot" role="button" id="box${currentItem.itemId}" 
                                            name="item" value="${currentItem.itemId}" style="width: 180px; height: 140px">
                                        <div style="text-align: left">${currentItem.itemId}</div>
                                        <div id="img${currentItem.itemId}">
                                            <img src="${pageContext.request.contextPath}/images/${currentItem.itemId}.jpg" style="height:50px" />
                                        </div>
                                        <div>-----</div>
                                        <div>$${currentItem.price}</div>
                                        <div>In stock: ${currentItem.inStock}</div>
                                    </button>
                                </div>
                            </c:forEach>
                        </div>
                    </sf:form>
                </div>    

            <div class="col-md-4" style="background-color: silver">

                <h2>Money Entered</h2>

                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="moneyInserted" placeholder="$${moneyEntered}" readonly="true" />
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-6" style="text-align:right">
                            <sf:form class="form-horizontal" role="form" modelAttribute="button"
                                     action="addUserMoney" method="POST"> 
                                <input type="submit" class="btn btn-default" name="button" value="Add Dollar" />
                            </sf:form>
                        </div>                     
                        <div class="col-md-6">
                            <sf:form class="form-horizontal" role="form" modelAttribute="button"
                                     action="addUserMoney" method="POST">                             
                                <input type="submit" class="btn btn-default" name="button" value="Add Quarter" />
                            </sf:form>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12"> 
                        <div class="col-md-6" style="text-align:right">
                            <sf:form class="form-horizontal" role="form" modelAttribute="button"
                                     action="addUserMoney" method="POST">                             
                                <input type="submit" class="btn btn-default" name="button" value="Add Dime" />
                            </sf:form>
                        </div>
                        <div class="col-md-6">
                            <sf:form class="form-horizontal" role="form" modelAttribute="button"
                                     action="addUserMoney" method="POST">                             
                                <input type="submit" class="btn btn-default" name="button" value="Add Nickel" />
                            </sf:form>
                        </div>
                    </div>
                </div>

                <hr/>

                <h2>Messages</h2>

                <div class="row">
                    <input type="text" class="form-control" id="messages" placeholder="${messages}" readonly="true" />
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-6" style="text-align:right">
                            <label for="itemSelection" class="control-label">Item:</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="itemSelection" placeholder="${selectionString}" readonly="true" />
                        </div>
                    </div>
                </div>

                <div class="row" style="text-align:center">                            
                    <sf:form class="form-horizontal" role="form" modelAttribute="moneyEntered"
                             action="purchaseItem" method="GET">  
                        <input type="submit" class="btn btn-default" value="Make Purchase" />
                    </sf:form>
                </div>

                <hr/>

                <h2>Change</h2>

                <div class="row">
                    <sf:form class="form-horizontal" role="form" modelAttribute="moneyEntered"
                             action="resetDisplay" method="GET"> 
                    <input type="submit" class="btn btn-block" id="changeReturned" value="${changeToReturn}" readonly="true" />
                    </sf:form>
                </div>

                <div class="row" style="text-align:center">
                    <sf:form class="form-horizontal" role="form" modelAttribute="moneyEntered"
                             action="getChange" method="GET">                      
                        <input type="submit" class="btn btn-default" value="Return Change" />
                    </sf:form>
                </div>

                <div style="height: 14px"></div>

            </div>
        </div>

        <div style="height:40px; background-color: black"></div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

