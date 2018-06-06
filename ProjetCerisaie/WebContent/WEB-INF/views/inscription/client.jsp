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
    <title>Inscription Client</title>
    <%@ include file="../includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="../includes/navbar.jsp" %>
<div class="container">
    <div class="container">
        <div class="page-header">
            <h1>Inscription client</h1>
        </div>
    </div>
    <form class="form-horizontal" name='identification' method="post" action="insererClient.htm" >
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Nom d'utilisateur:</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="text" class="form-control" id="signonLogin" name="signonLogin" placeholder="login" required>
            </div>
        </div>
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Mot de passe:</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="password" class="form-control" id="signonPassword" name="signonPassword" placeholder="mot de passe" required>
            </div>
        </div>
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Mot de passe (Re-tapez):</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="password" class="form-control" id="repeatSignonPassword" name="repeatSignonPassword" placeholder="Retapez le mot de passe" required>
            </div>
        </div>
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Nom du Client:</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom de l'adhérent" value="" required>
            </div>
        </div>
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Ville de l'adhérent:</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="text" class="form-control"  id="ville" name="ville" placeholder="Ville de l'adhérent" required>
            </div>
        </div>
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Numéro de Pièce d'identité:</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="text" class="form-control"  id="numPieceCli" name="numPieceCli" placeholder="ex:12345" required>
            </div>
        </div>
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Adresse:</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="text" class="form-control"  id="adresse" name="adresse" placeholder="ex:12 rue des allouettes" required>
            </div>
        </div>
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Code Postal:</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="text" class="form-control"  id="codePostal" name="codePostal" placeholder="ex:69110" required>
            </div>
        </div>
        <div class="form-group">
            <div  class="col-md-3 col-xs-4">
                <label>Type de Pièce d'identité:</label>
            </div>
            <div class="col-md-5 col-xs-6">
                <input type="text" class="form-control"  id="pieceCli" name="pieceCli" placeholder="CI/PS/PC" required>
            </div>
        </div>
        <button type="submit" class="btn btn-default">S'inscrire</button>
    </form>
</div>
</body>
</html>
