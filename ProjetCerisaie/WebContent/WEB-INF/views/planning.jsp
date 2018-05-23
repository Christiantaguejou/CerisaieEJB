<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Planning de Cerisaie</title>
    <%@ include file="includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<div>
    <div class="container">
        <<table id="tableFilter" class="table table-striped table-hover">
        <br/>
        <thead>
        <tr>
            <th onclick="sortTable(0)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Sport</th>
            <th onclick="sortTable(1)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  dateJour</th>
            <th onclick="sortTable(2)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  date debut sejour</th>
            <th onclick="sortTable(2)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  date fin sejour</th>
            <th onclick="sortTable(3)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  nbLoc</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${activities}" var="item">
            <tr>
                <td>${item.sportEntity.libelleSport}</td>
                <td>${item.activityEntity.dateJour}</td>
                <td>${item.sejourEntity.datedebSej}</td>
                <td>${item.sejourEntity.dateFinSej}</td>
                <td>${item.activityEntity.nbLoc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>
</body>
</html>