<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/navbar.css">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Cerisaie</a>
        </div>
        <ul class="nav navbar-nav" id="menus">
            <li class="menu current" ><a href="home.htm">Home</a></li>
            <li class="menu" ><a href="planning.htm">Planning</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty loggedInClient}">
                <li><a href="inscriptionClient.htm"><span class="glyphicon glyphicon-user"></span> S'inscrire</a></li>
                <li><a href="login.htm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
            <c:if test="${not empty loggedInClient}">
                <li><a active> Utilisateur ${loggedInClient.username}</a></li>
                <li><a href="disconnect.htm"><span class="glyphicon glyphicon-log-out"></span> Deconnexion</a></li>
            </c:if>
        </ul>
    </div>
</nav>
<script src="${pageContext.request.contextPath}/resources/js/fonctionsUtiles.js"></script>