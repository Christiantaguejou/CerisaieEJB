<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Espace Client</title>
    <%@ include file="../includes/stylesheet.jsp" %>
    <%@ include file="../includes/includeTab.jsp" %>
</head>
<body>
<%@ include file="../includes/navbar.jsp" %>
<div class="container">
    <div class="container">
        <div class="page-header">
            <h1>Bienvenue ${loggedInClient.nomCli}</h1>
        </div>
    </div>
    <table cellspacing="0" cellpadding="0" width="100%" border="0" >
        <tr>
            <td valign="top" align="center">
                <form name='inscription' method="post" action="inscriptionActivite.htm">
                    <button type="submit" class="btn btn-default">S'inscrire à une activité</button>
                </form>
            </td>
            <td valign="top" align="center">
                <form name='monHistorique' method="post" action="historiqueActivite.htm">
                    <button type="submit" class="btn btn-default">Mes inscriptions</button>
                </form>
            </td>
        </tr>
    </table>
    <c:if test="${empty sejoursReserves}">
        <h1>Reserver un sejour</h1>
        <a href="home.htm" class="btn btn-default">Reserver un sejour</a>
    </c:if>
    <c:if test="${not empty sejoursReserves}">
        <div class="container">
            <div class="page-header">
                <h1>Séjours proposés</h1>
            </div>
        </div>
        <div class="row>
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
                                                <th class="cell100 column3">Debut sejour</th>
                                                <th class="cell100 column4">Fin sejour</th>
                                                <th class="cell100 column5">Prix payé</th>
                                            </tr>
                                        </thead>
                                    </table>
                                 </div>

                            <div class="table100-body js-pscroll">
                                <table>
                                    <tbody>
                                        <c:forEach items="${sejoursReserves}" var="item">
                                            <tr class="row100 body">
                                                <td class="cell100 column1">${item.sejoursProposesEntity.emplacementEntity.typeEmplacementEntity.libtypepl}</td>
                                                <td class="cell100 column2">${item.nbPersonnes}</td>
                                                <td class="cell100 column3">${item.datedebSej}</td>
                                                <td class="cell100 column4">${item.dateFinSej} </td>
                                                <td class="cell100 column5">${item.totalTtc} €</td>
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
    </c:if>
</div>
</body>
</html>
