<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 10/05/2018
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" name='identification' method="post" action="insererClient.htm" >
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Nom de l'adhérent:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom de l'adhérent" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Ville de l'adhérent:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control"  id="ville" name="ville" placeholder="Ville de l'adhérent" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Numéro de Pièce d'identité:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control"  id="numPieceCli" name="numPieceCli" placeholder="ex:12345" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Adresse:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control"  id="adresse" name="adresse" placeholder="ex:12 rue des allouettes" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Code Postal:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control"  id="codePostal" name="codePostal" placeholder="ex:69110" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Type de Pièce d'identité:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control"  id="pieceCli" name="pieceCli" placeholder="CI/PS/PC" required>
        </div>
    </div>
    <button type="submit" class="btn btn-default">Ajouter</button>
</form>
</body>
</html>
