<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 10/05/2018
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" name='identification' method="post" action="insererActivite.htm" >
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Code Sport:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control" id="codeSport" name="codeSport" placeholder="codeSport" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Date de location:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control"  id="dateLocation" name="dateLocation" placeholder="dateLocation" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Numéro de séjour:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control"  id="numSej" name="numSej" placeholder="numSej" required>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 col-xs-4">Ville de l'adhérent:</label>
        <div class="col-md-8 col-xs-8">
            <input type="text" class="form-control"  id="nbLoc" name="nbLoc" placeholder="nbLoc" required>
        </div>
    </div>
    <button type="submit" class="btn btn-default">Ajouter</button>
</form>
</body>
</html>
