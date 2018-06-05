<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Cerisaie</title>
    <%@ include file="includes/includeTab.jsp" %>
    <%@ include file="includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>

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
                                    <th class="cell100 column6">Réservation</th>
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
                                        <td><button type="button" class="btn btn-reserv" data-href="Controleur?action=modifierOeuvre&id=${item.numSej}">Reserver</button></td>
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
<script>
    $('.clickable-row').click(function(){
        window.location = $(this).data('href');
    });

</script>
</body>
</html>