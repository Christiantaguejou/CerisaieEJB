<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Cerisaie</title>
    <%@ include file="includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<div>
    <div class="container">
        <table id="tableFilter" class="table table-striped table-hover">
            <br/>
            <thead>
            <tr>
                <th onclick="sortTable(0)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Type d'emplacement</th>
                <th onclick="sortTable(1)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Nb de pers. Max</th>
                <th onclick="sortTable(2)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Surface</th>
                <th onclick="sortTable(3)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Tarif/Nuit</th>
                <th onclick="sortTable(4)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Date de fin de l'offre</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sejours}" var="item">
                <tr>
                    <td>${item.emplacementEntity.typeEmplacementEntity.libtypepl}</td>
                    <td>${item.emplacementEntity.nbPersMaxEmpl}</td>
                    <td>${item.emplacementEntity.surfaceEmpl}</td>
                    <td>${item.emplacementEntity.typeEmplacementEntity.tariftypepl} euros</td>
                    <td>${item.dateFinOffre}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>