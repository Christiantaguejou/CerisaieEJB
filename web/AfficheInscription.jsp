<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/tableau.css" />
<title>Affichage</title>
 <script>
function Chargement()
      {
          var obj = document.getElementById("id_erreur");
          if (obj.value!='')
             alert('Erreur signalée  : "'+obj.value+"'");
      }
  </script>
</head>
<body onLoad="Chargement();" > 
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Affichage des demandes d'inscription</a></h1>
		</div>
	</div>
	<div id="menu">
		<ul>
			<li><a href='index.jsp'>Accueil</a></li>
			<li><a href='PostMessage.jsp'>Ajout</a></li>
			<li><a href='Controleur?action=afficheInscription'>Affichage</a></li>
		</ul>
		<br class="clearfix" />
	</div>
	<div id="page">
		<div id="content">
			<div class="box">
				
		<c:if test="${listeDmdInscription != null}">
		<h3>Demandes d'inscription</h3>
			<div class="corps">
<table summary="Affichage des inscriptions">
<thead>
<tr>
<th scope="col">Nom</th>
<th scope="col">Prenom</th>
<th scope="col">Date de naissance</th>
<th scope="col">Adresse</th>
<th scope="col">Code postal</th>
<th scope="col">Ville</th>
</tr>
</thead>
<tbody>
<c:forEach var="candidat" items="${listeDmdInscription}">
		<tr>
			<td><c:out value="${candidat.nomcandidat}" /></td>
			<td><c:out value="${candidat.prenoncandidat}" /></td>
			<td><fmt:formatDate type="both"	value="${candidat.datenaissance}" pattern="dd/MM/yyyy" /></td>
			<td><c:out value="${candidat.adresse}" /></td>
			<td><c:out value="${candidat.cpostal}" /></td>
			<td><c:out value="${candidat.ville}" /></td>
		</tr>
</c:forEach>
</tbody>
<tfoot>
<tr>
<th scope="row">Total : </th>
<td colspan="5"><c:out value="${nbInscription}"/> demandes d'inscription</td>
</tr>
</tfoot>
</table>
			</div>	
			<span class="clear"></span>
		</c:if>
		</div>
			</div>
			<input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
		</div>
		<br class="clearfix" />
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3>TD POLYTECH</h3>
		</div>
		<br class="clearfix" />
	</div>
	</div>
</body>
</html>
