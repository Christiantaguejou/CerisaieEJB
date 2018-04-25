function verif(formulaire) 
{
	var champManquant = false;
	var form = formulaire;

	if (form.elements["nom"].value == "") {
		champManquant = true;
		setChampError(form.elements["nom"]);
	} else
		unsetChampError(form.elements["nom"]);

	if (form.elements["prenom"].value == "") {
		champManquant = true;
		setChampError(form.elements["prenom"]);
	} else
		unsetChampError(form.elements["prenom"]);

	if (form.elements["datenaissance"].value == "") {
		champManquant = true;
		setChampError(form.elements["datenaissance"]);
	} else
		unsetChampError(form.elements["datenaissance"]);

	if (form.elements["adresse"].value == "") {
		champManquant = true;
		setChampError(form.elements["adresse"]);
	} else
		unsetChampError(form.elements["adresse"]);

	if (form.elements["cpostal"].value == "") {
		champManquant = true;
		setChampError(form.elements["cpostal"]);
	} else
		unsetChampError(form.elements["cpostal"]);

	if (form.elements["ville"].value == "") {
		champManquant = true;
		setChampError(form.elements["ville"]);
	} else
		unsetChampError(form.elements["ville"]);

	if (champManquant == true) {
		alert("Un ou plusieurs champs sont manquants !");
		return false;
	} 
	else//Tous les champs sont complétés, on vérifie leur validité
	{
		//On vérifie le champ du code postal
		if (testChampEntier(form.elements["cpostal"]) == true)
		{
			alert("Le code postal doit etre un nombre entier !");
			return false;
		} 
		else 
		{
			
				//On vérifie la date de naissance
				if (!verifDateValid(form.elements["datenaissance"].value)) 
				{
					setChampError(form.elements["datenaissance"]);
					return false;
				} 
				else //La date de naissance est valide
				{
					var dateDuJour = new Date();
					var mois = dateDuJour.getMonth() + 1;
					var jour = dateDuJour.getDate();

					if (mois < 10)
						mois = "0" + mois;
					if (jour < 10)
						jour = "0" + jour;

					var dateDuJourStr = dateDuJour.getFullYear() + "/" + mois
							+ "/" + jour;

					//On vérifie que la date de naissance jour est antérieure à la date du jour
					if (date1AnterieurDate2(form.elements["datenaissance"].value, dateDuJourStr) == true) 
					{
						return true;
					} 
					else 
					{
						alert("La date de naissance n'est pas anterieure a la date du jour");
						setChampError(form.elements["datenaissance"]);
						return false;
					}

					unsetChampError(form.elements["datenaissance"]);
					return true;
				}
		}
	}
}

//Renvoie vrai si date1 est antérieure à date2 (date1 et date2 au format dd/mm/yyyy)
function date1AnterieurDate2(date1, date2) 
{
	var jourDate1 = date1.substring(0, 2);
	var moisDate1 = date1.substring(3, 5);
	var anneeDate1 = date1.substring(6);

	var anneeDate2 = date2.substring(0, 4);
	var moisDate2 = date2.substring(5, 7);
	var jourDate2 = date2.substring(8);
	
	var test1 = new Date(anneeDate1, moisDate1, jourDate1);
	var test2 = new Date(anneeDate2, moisDate2, jourDate2);

	if (test1.getTime() < test2.getTime())
		return true;
	else
		return false;
}

function verifDateValid(date) 
{
	var jour = date.substring(0, 2);
	var sep1 = date.charAt(2);
	var mois = date.substring(3, 5);
	var sep2 = date.charAt(5);
	var annee = date.substring(6);

	//L'année, le mois et le jour sont des entiers
	if (testEntier(annee) == true && testEntier(mois) == true && testEntier(jour) == true) {
		//Les séparateur sont valides
		if (sep1 == '/' && sep2 == '/') {
			//On vérifie la cohérence du mois et du jour
			if (verifNbJourMoisValide(mois, jour) == true) {
				return true;
			}
		} else {
			alert("Les dates doivent être au format dd/mm/yyyy");
			return false;
		}
	} else {
		alert("Les dates doivent être au format dd/mm/yyyy");
		return false;
	}
}

function verifNbJourMoisValide(mois, jour) 
{
	//Mois avec un nombre de jour égal à 31
	if (mois == 1 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) 
	{
		if (jour <= 0 || jour > 31) 
		{
			alert("Le nombre de jour est incorrect par rapport au mois");
			return false;
		} else
			return true;
	}
	//Mois avec un nombre de jour égal à 30
	else if (mois == 4 || mois == 6 || mois == 9 || mois == 11) 
	{
		if (jour <= 0 || jour > 30) 
		{
			alert("Le nombre de jour est incorrect par rapport au mois");
			return false;
		} else
			return true;
	}
	//On considère que le mois de février a toujours 29 jours par simplification
	else if (mois == 2) 
	{
		if (jour <= 0 || jour > 29) 
		{
			alert("Le nombre de jour est incorrect par rapport au mois");
			return false;
		} else
			return true;
	} 
	else 
	{
		alert("Le mois est incorrect");
		return false;
	}
}

function testChampEntier(champ) 
{
	var champPasNbEntier = false;

	//Le champ doit etre un entier et ne pas contenir de '.'
	if (champ.value != parseInt(champ.value) || champ.value.indexOf(".") != -1) 
	{
		champPasNbEntier = true;
		setChampError(champ);
	} 
	else
		unsetChampError(champ);

	return champPasNbEntier;
}

function testEntier(nb) 
{
	//On supprime le premier 0 (par exemple "08", car parseInt renvoie 8)
	if (nb.charAt(0) == "0")
		nb = nb.substr(1);

	if (nb != parseInt(nb))
		return false;
	else
		return true;
}

function setChampError(champ) 
{
	champ.style.backgroundColor = 'red';
	champ.style.color = 'white';
}

function unsetChampError(champ) 
{
	champ.style.backgroundColor = 'white';
	champ.style.color = 'black';
}