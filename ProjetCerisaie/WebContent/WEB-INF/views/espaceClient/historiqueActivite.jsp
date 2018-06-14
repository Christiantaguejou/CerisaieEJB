<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Espace Client</title>
    <%@ include file="../includes/includeTab.jsp" %>
    <%@ include file="../includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="../includes/navbar.jsp" %>
<div class="container">
    <div class="container">
        <div class="page-header">
            <h1>Mon historique d'activités</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 col-xs-12">
            <div class="limiter">
                <div class="container-table100">
                    <div class="wrap-table100">

                        <div class="table100 ver2 m-b-110">
                            <div class="table100-head">
                                <table>
                                    <thead>
                                    <tr class="row100 head">
                                        <th class="cell100 column1">Sport</th>
                                        <th class="cell100 column2">Date de Location</th>
                                        <th class="cell100 column5">Nbre de Location</th>
                                    </tr>
                                    </thead>
                                </table>
                            </div>

                            <div class="table100-body js-pscroll">
                                <table>
                                    <tbody>
                                    <c:forEach items="${activities}" var="item">
                                        <tr class="row100 body">
                                            <td class="cell100 column1">${item.sport.libelleSport}</td>
                                            <td class="cell100 column2">${item.dateJour}</td>
                                            <td class="cell100 column5">${item.nbLoc}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
