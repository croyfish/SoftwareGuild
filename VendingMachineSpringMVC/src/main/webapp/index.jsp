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
    </head>
    <body>
        <div class="row" style="background-color: black; text-align: center"><a onclick="getWeather()"><img src="images/snacks.jpg" width="200px"></a></div>

        <div class="row">
            <div class="col-md-8" style="background-color: brown">
                <table class="col-md-12" style="text-align: center">

                    <tr>
                        <th class="col-md-4"></th>
                        <th class="col-md-4"></th>
                        <th class="col-md-4"></th>
                    </tr>

                    <tr>
                        <td>
                            <a onclick="selectItem(1)">
                                <div class="slot" id="box1">
                                    <div style="text-align: left">1</div>
                                    <div id="img1"></div>
                                    <div id="slot1"></div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a onclick="selectItem(2)">
                                <div class="slot" id="box2">
                                    <div style="text-align: left">2</div>
                                    <div id="img2"></div>
                                    <div id="slot2"></div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a onclick="selectItem(3)">
                                <div class="slot" id="box3">
                                    <div style="text-align: left">3</div>
                                    <div id="img3"></div>
                                    <div id="slot3"></div>
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a onclick="selectItem(4)">
                                <div class="slot" id="box4">
                                    <div style="text-align: left">4</div>
                                    <div id="img4"></div>
                                    <div id="slot4"></div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a onclick="selectItem(5)">
                                <div class="slot" id="box5">
                                    <div style="text-align: left">5</div>
                                    <div id="img5"></div>
                                    <div id="slot5"></div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a onclick="selectItem(6)">
                                <div class="slot" id="box6">
                                    <div style="text-align: left">6</div>
                                    <div id="img6"></div>
                                    <div id="slot6"></div>
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a onclick="selectItem(7)">
                                <div class="slot" id="box7">
                                    <div style="text-align: left">7</div>
                                    <div id="img7"></div>
                                    <div id="slot7"></div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a onclick="selectItem(8)">
                                <div class="slot" id="box8">
                                    <div style="text-align: left">8</div>
                                    <div id="img8"></div>
                                    <div id="slot8"></div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a onclick="selectItem(9)">
                                <div class="slot" id="box9">
                                    <div style="text-align: left">9</div>
                                    <div id="img9"></div>
                                    <div id="slot9"></div>
                                </div>
                            </a>
                        </td>
                    </tr>

                </table>
            </div>

            <div class="col-md-4" style="background-color: silver">

                <h2>Money Entered</h2>

                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="moneyInserted" placeholder="$0.00" readonly="true" />
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-6" style="text-align:right">
                            <sf:form class="form-horizontal" role="form" modelAttribute="dollars"
                                     action="addCoin" method="POST"> 
                                <input type="submit" class="btn btn-default" value="1.00" />
                            </sf:form>
                        </div>                     
                        <div class="col-md-6">
                            <sf:form class="form-horizontal" role="form" modelAttribute="quarters"
                                     action="addCoin" method="POST">                             
                                <input type="submit" class="btn btn-default" value="0.25" />
                            </sf:form>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12"> 
                        <div class="col-md-6" style="text-align:right">
                            <sf:form class="form-horizontal" role="form" modelAttribute="dimes"
                                     action="addCoin" method="POST">                             
                                <input type="submit" class="btn btn-default" value="0.10" />
                            </sf:form>
                        </div>
                        <div class="col-md-6">
                            <sf:form class="form-horizontal" role="form" modelAttribute="nickels"
                                     action="addCoin" method="POST">                             
                                <input type="submit" class="btn btn-default" value="0.05" />
                            </sf:form>
                        </div>
                    </div>
                </div>

                <hr/>

                <h2>Messages</h2>

                <div class="row">
                    <input type="text" class="form-control" id="messages" placeholder="(no messages)" readonly="true" />
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-6" style="text-align:right">
                            <label for="itemSelection" class="control-label">Item:</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="itemSelection" placeholder="(no item seleted)" readonly="true" />
                        </div>
                    </div>
                </div>

                <div class="row" style="text-align:center">                            
                    <sf:form class="form-horizontal" role="form" modelAttribute="moneyEntered"
                             action="addNickel" method="POST">  
                        <input type="submit" class="btn btn-default" value="Make Purchase" />
                    </sf:form>
                </div>

                <hr/>

                <h2>Change</h2>

                <div class="row">
                    <a onclick="takeChange()"><input type="text" class="form-control" id="changeReturned" placeholder="(no change)" readonly="true" /></a>
                </div>

                <div class="row" style="text-align:center">
                    <sf:form class="form-horizontal" role="form" modelAttribute="moneyEntered"
                             action="addNickel" method="POST">                      
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

