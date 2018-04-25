<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/tableau.css" />
<title>Ajout</title>
 <script>
function Chargement()
      {
          var obj = document.getElementById("id_erreur");
          if (obj.value!='')
             alert('Erreur signalée  : "'+obj.value+"'");
      }
  </script>
  <script src="js/js_verif.js" type="text/javascript"></script>
</head>
<body onLoad="Chargement();" > 
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Ajout d'une demande d'inscription</a></h1>
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
				<h3>Veuillez remplir le formulaire ci-dessous :</h3>
				<form   action='Controleur?action=envoiInscription'  method='post' onsubmit="return verif(this);">
					<label for="nom" style="margin-left:84px">Nom :</label> <input type='text' name='nom' id="nom">  <br/><br/>
					<label for="prenom" style="margin-left:65px"> Prénom :</label>  <input type='text'name='prenom' id="prenom"> <br/><br/>
					<label for="datenaissance">Date de naissance : </label> <input type='text' name='datenaissance' id="datenaissance">  au format : dd/mm/yyyy<br/><br/>
					<label for="adresse" style="margin-left:68px"> Adresse :</label> <input type='text' name='adresse' id="adresse"><br/><br/>
					<label for="cpostal " style="margin-left:41px"> Code Postal :</label> <input type='text' name='cpostal'id ="cpostal"><br/><br/>
					<label for="ville" style="margin-left:89px">  Ville :</label> <input type='text' name='ville'id="ville"><br/><br/>
					<input type='submit' value="Valider" style="height: 25px; width: 100px; align:center; margin-left:150px"><br/>
				</form>
			</div>
			<input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
		</div>
		<br class="clearfix" />
	</div>
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3>TD POLYTECH</h3>
		</div>
		<br class="clearfix" />
	</div>
</div>
</body>
</html>
