<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Cerisaie</title>
    <%@ include file="includes/stylesheet.jsp" %>
    <%@ include file="includes/includeTab.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
    <%--<div class="container">--%>
        <%--<h1>Séjours proposés</h1>--%>

        <%--<table id="tableFilter" class="table table-striped table-hover">--%>
            <%--<br/>--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th onclick="sortTable(0)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Type d'emplacement</th>--%>
                <%--<th onclick="sortTable(1)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Nb de pers. Max</th>--%>
                <%--<th onclick="sortTable(2)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Surface</th>--%>
                <%--<th onclick="sortTable(3)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Tarif/Nuit</th>--%>
                <%--<th onclick="sortTable(4)" class="cursorClic"><p class="glyphicon glyphicon-sort " style="display: inline"></p>  Date de fin de l'offre</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<c:forEach items="${sejours}" var="item">--%>
                <%--<tr>--%>
                    <%--<td>${item.emplacementEntity.typeEmplacementEntity.libtypepl}</td>--%>
                    <%--<td>${item.emplacementEntity.nbPersMaxEmpl}</td>--%>
                    <%--<td>${item.emplacementEntity.surfaceEmpl}</td>--%>
                    <%--<td>${item.emplacementEntity.typeEmplacementEntity.tariftypepl} euros</td>--%>
                    <%--<td>${item.dateFinOffre}</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</div>--%>
<div class="container">
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
                                    <th class="cell100 column1">Emplacement</th>
                                    <th class="cell100 column2">Nbre de pers.</th>
                                    <th class="cell100 column3">Surface</th>
                                    <th class="cell100 column4">Tarif/Nuit</th>
                                    <th class="cell100 column5">Fin de l'offre</th>
                                    <th class="cell100 column5">Réservation</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>

                        <div class="table100-body js-pscroll">
                            <table>
                                <tbody>
                                <c:forEach items="${sejours}" var="item">
                                    <tr class="row100 body">
                                        <td class="cell100 column1">${item.emplacementEntity.typeEmplacementEntity.libtypepl}</td>
                                        <td class="cell100 column2">${item.emplacementEntity.nbPersMaxEmpl}</td>
                                        <td class="cell100 column3">${item.emplacementEntity.surfaceEmpl}</td>
                                        <td class="cell100 column4">${item.emplacementEntity.typeEmplacementEntity.tariftypepl} €</td>
                                        <td class="cell100 column5">${item.dateFinOffre}</td>
                                        <td><button type="button" class="btn btn-reserv">Success</button></td>
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

<script>
    $('.js-pscroll').each(function(){
        var ps = new PerfectScrollbar(this);

        $(window).on('resize', function(){
            ps.update();
        })
    });


</script>

</body>
</html>