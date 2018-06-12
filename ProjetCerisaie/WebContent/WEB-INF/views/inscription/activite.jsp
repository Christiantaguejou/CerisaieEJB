<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 10/05/2018
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>S'inscrire à une activité</title>
    <%@ include file="../includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="../includes/navbar.jsp" %>
<div class="container">
    <div class="page-header">
        <h1>Inscription à une activité</h1>
    </div>
</div>
<form class="form-horizontal" name='identification' method="post" action="insererActivite.htm">
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Code Sport:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control" id="codeSport" name="codeSport" placeholder="codeSport" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Date de location:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control" id="dateLocation" name="dateLocation" placeholder="dateLocation"
                   required>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-4 col-xs-4">Numéro de séjour:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control" id="numSej" name="numSej" placeholder="numSej" required>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-4 col-xs-4">Nombre d'unité:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control" id="nbloc" name="nbloc" placeholder="nbloc" required>
        </div>
    </div>

    <button type="submit" class="btn btn-default">Ajouter</button>
</form>
<script>$("#dateLocation").datepicker({
    dateFormat: 'dd/mm/yy'
});</script>
</body>
</html>
