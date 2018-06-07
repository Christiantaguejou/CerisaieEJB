<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 03-06-18
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <title>Confirmer Réservation</title>
    <%@ include file="includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<div class="container">
    <div class="container">
        <div class="page-header">
            <h1>Confirmer Réservation</h1>
        </div>
    </div>
    <div class="formMarge">
        <form class="form-horizontal" name='identification' method="post" action="reservationConfirme.htm">
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Nom du Client:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="nom" name="nom" value="${loggedInClient.nomCli}"
                           readonly>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Ville :</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="ville" name="ville" value="${loggedInClient.villeCli}"
                           readonly>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Numéro de Pièce d'identité:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="numPieceCli" name="numPieceCli"
                           value="${loggedInClient.numPieceCli}" readonly>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Adresse:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="adresse" name="adresse"
                           value="${loggedInClient.adrRueCli}"
                           readonly>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Code Postal:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="codePostal" name="codePostal"
                           value="${loggedInClient.cpCli}"
                           readonly>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Type de Pièce d'identité:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="pieceCli" name="pieceCli"
                           value="${loggedInClient.pieceCli}"
                           readonly>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Date de début de séjour:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="dateDebSejour" name="dateDebSejour"
                           placeholder="Date de début de séjour" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Date de fin de séjour:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="dateFinSejour" name="dateFinSejour"
                           placeholder="Date de fin de sejour" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Total TTC:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="totalTtc" name="totalTtc"
                           placeholder="Tarif TTC" readonly>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Nombre de personnes:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <select name="nbPersonnes">
                        <c:forEach var="i" begin="1" end="${sejourProposeEntity.emplacementEntity.nbPersMaxEmpl}">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Numéro de carte de crédit:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="numCarteCredit" name="numCarteCredit"
                           placeholder="Numéro de carte de crédit" required>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Type de carte de crédit:</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <select name="typeCarteCredit" id="typeCarteCredit">
                        <option value="1">VISA</option>
                        <option value="2">MASTERCARD</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3 col-xs-4">
                    <label>Date d'expiration :</label>
                </div>
                <div class="col-md-5 col-xs-6">
                    <input type="text" class="form-control" id="dateExpiration" name="dateExpiration"
                           placeholder="Date d'expiration" required>
                </div>
            </div>
            <input type="hidden" id="tarif" name="tarif"
                   value="${sejourProposeEntity.emplacementEntity.typeEmplacementEntity.tariftypepl}" required>
            <button type="submit" class="btn btn-default">Confirmer</button>
        </form>
    </div>
</div>
</body>
<script>
    $("#dateDebSejour").datepicker({
        dateFormat: 'dd/mm/yy' ,
        onSelect: function () {
            myfunc();
        }
    });

    $("#dateExpiration").datepicker({
        dateFormat: 'dd/mm/yy'
    });

    $("#dateFinSejour").datepicker({
        dateFormat: 'dd/mm/yy' ,
        onSelect: function () {
            myfunc();
        }
    });

    function myfunc() {
        var start = $("#dateDebSejour").datepicker("getDate");
        var end = $("#dateFinSejour").datepicker("getDate");
        if(end > 0 && start> 0 && (end - start)< 0){
            alert("La date de fin ne peut être antérieur à la date de début !");
            $("#dateFinSejour").val("");
        }else{
            days = (end - start) / (1000 * 60 * 60 * 24);
            total = (Math.round(days) + 1) * ($("#tarif").val());
            if(total>0){
                $("#totalTtc").val(total);
            }
        }
    }
</script>
</html>
