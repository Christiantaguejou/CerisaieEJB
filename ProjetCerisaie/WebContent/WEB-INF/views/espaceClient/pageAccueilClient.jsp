<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Espace Client</title>
    <%@ include file="../includes/stylesheet.jsp" %>
</head>
<body>
<%@ include file="../includes/navbar.jsp" %>
<h1>Bienvenue ${loggedInClient.nomCli}</h1>
<div class="container">
    <table cellspacing="0" cellpadding="0" width="100%" border="0" >
        <tr>
            <td valign="top" align="center">
                <form name='inscription' method="post" action="inscriptionActivite.htm">
                    <button type="submit" class="btn btn-default">S'inscrire à une activité</button>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
