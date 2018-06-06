<%@ taglib prefix="h" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 24/05/2018
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Se connecter</title>
    <%@ include file="includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<div id="body">
    <div class="container">
        <div class="col-md-12 col-xs-12">
            <div class="container">
                <div class="page-header">
                    <h2>Sign In</h2>
                </div>
            </div>
            <form class="form-horizontal" name='connexion' method="post" action="doSignIn.htm">
                <p>Vous avez un compte ?</p>
                <div class="form-group">
                    <div class="col-md-1 col-xs-2">
                        <label for="login"><p>Login:</p></label>
                    </div>
                    <div class="col-md-5 col-xs-6">
                        <input type="login" class="form-control" id="login" name="login" placeholder="login" required>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-1 col-xs-2" >
                        <label for="password"><p>Password:</p></label>
                    </div>
                    <div class="col-md-5 col-xs-6">
                        <input type="password" class="form-control" id="password" name="password" placeholder="password" required>
                    </div>
                </div>
                <button type="submit" class="btn btn-default">Connexion</button>
            </form>

            <div class="container">
                <div class="page-header">
                    <h2>Inscription</h2>
                </div>
            </div>
                <form name='inscription' method="post" action="inscriptionClient.htm">
                    <div>
                        <p>Je n'ai pas de compte, je m'inscris</p>
                    </div>
                    <button type="submit" class="btn btn-default">S'inscrire</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
