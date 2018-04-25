package controle;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.text.SimpleDateFormat;

import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import javax.jms.Topic;

import service.*;
import metier.Inscription;

import javax.naming.NamingException;

/**
 * Servlet implementation class Traitement
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {




	private static final long serialVersionUID = 10L;
	private static final String ACTION_TYPE = "action";
	private static final String AFFICHER_INSCRIPTION = "afficheInscription";
	private static final String AJOUTER_INSCRIPTION = "ajouteInscription";
	private static final String ENVOI_INSCRIPTION = "envoiInscription";
	private static final String RETOUR_ACCUEIL = "Retour";

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Resource(lookup = "java:jboss/exported/topic/DemandeInscriptionJmsTopic")
	private Topic topic;
	// On accède à l'EJB

	@Resource(mappedName = "java:/ConnectionFactory")
	private TopicConnectionFactory cf;

	// Session établie avec le serveur
	private TopicSession session = null;

	// Le client utilise un Producteur de messsage pour envoyer une demande de
	// formation
	private TopicPublisher producer;




	// Appel de l'EJB Session 
	//@Resource(lookup = "ejb:/EJBInscription//AppelInscription!service.AppelInscriptionRemote")


	@EJB
	private service.AppelInscriptionRemote unAppelInscription ;



	/**
	 * Constructeur par défaut de la classe
	 */
	public Controleur() {
		super();
	}

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			TraiteRequete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			TraiteRequete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Procédure principale de démarrage
	 */
	public void TraiteRequete(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// On récupère l'action
		String actionName = request.getParameter(ACTION_TYPE);

		// Si on veut afficher l'ensemble des demandes d'inscription
		if (AJOUTER_INSCRIPTION.equals(actionName)) {

			request.getRequestDispatcher("PostMessage.jsp").forward(request, response);

		} else

		if (AFFICHER_INSCRIPTION.equals(actionName)) {

			ArrayList<Inscription> listeDmdInscription;




			try {
/*
				try {
					// on appelle l'EJB
					Context ctx = JBossContext.getInitialContext();
					String nom = getLookupNom();
						unAppelInscription = (AppelInscriptionRemote) ctx.lookup(nom);
						System.out.println(nom);
				} catch (NamingException ne) {
					request.setAttribute("MesErreurs", ne.getMessage());
				}*/

				// On récupère la liste des demandes d'inscription
				listeDmdInscription = unAppelInscription.recupererDmdInscription();
				// On fixe l'attribut correspondant � cette liste
				request.setAttribute("listeDmdInscription", listeDmdInscription);
				// On fixe l'attribut correspondant au nombre total de demandes
				// d'inscription
				request.setAttribute("nbInscription", listeDmdInscription.size());
				this.getServletContext().getRequestDispatcher("/AfficheInscription.jsp").include(request, response);
			} catch (Exception e) {
				// On passe l'erreur � la page JSP
				System.out.println("Erreur client  :" + e.getMessage());
				request.setAttribute("MesErreurs", e.getMessage());
				request.getRequestDispatcher("Erreur.jsp").forward(request, response);
			}

		} else if (RETOUR_ACCUEIL.equals(actionName)) {
			this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
		}

		else if (ENVOI_INSCRIPTION.equals(actionName))

		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			// On r�cup�re le nom et le pr�nom saisis
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");

			if ((nom != null) && (prenom != null)) {
				try {
					// On r�cup�re la valeur des autres champs saisis par
					// l'utilisateur
					String datenaissance = request.getParameter("datenaissance");
					Date unedate = sdf.parse(datenaissance);
					String adresse = request.getParameter("adresse");
					String cpostal = request.getParameter("cpostal");
					String ville = request.getParameter("ville");

					// On cr�e une demande d'inscription avec ces valeurs
					Inscription unedemande = new Inscription();
					unedemande.setNomcandidat(nom);
					unedemande.setPrenoncandidat(prenom);
					unedemande.setDatenaissance(unedate);
					unedemande.setAdresse(adresse);
					unedemande.setCpostal(cpostal);
					unedemande.setVille(ville);

					// On envoie cette demande d'inscription dans le topic
					boolean ok = envoi(unedemande);
					if (ok)
						// On retourne � la page d'accueil
						this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
					else {
						this.getServletContext().getRequestDispatcher("/Erreur.jsp").include(request, response);
					}
				} catch (Exception e) {
					// On passe l'erreur � la page JSP
					System.out.println("Erreur client  :" + e.getMessage());
					request.setAttribute("MesErreurs", e.getMessage());
					request.getRequestDispatcher("PostMessage.jsp").forward(request, response);
				}

			}
		}
	}

	/**
	 * Permet de publier une demande d'inscription dans le topic
	 * 
	 * @param unedemande
	 *            La demande d'inscription � publier
	 * @return
	 * @throws Exception
	 */
	boolean envoi(Inscription unedemande) throws Exception {

		TopicConnection connection = null;

		try {

			// On cr�e la connexion JMS , session, producteur et message;
			/*
			 * connection = connectionFactory.createConnection(
			 * System.getProperty("username", DEFAULT_USERNAME),
			 * System.getProperty("password", DEFAULT_PASSWORD));
			 */

			// Cr�ation Connection et Session JMS
			connection = cf.createTopicConnection();
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

			// On cr�e le producteur utilis� pour envoyer un message
			producer = session.createPublisher(topic);
			// On lance la connection
			connection.start();
			ObjectMessage message = session.createObjectMessage();
			message.setObject(unedemande);

			// On publie le message
			producer.publish(message);
			producer.close();
		} catch (Exception e) {
			System.out.println("Erreur client  :" + e.getMessage());
		} finally {
			// Fermeture de la connection , Sinon Jboss Messaging pas content.
			if (connection != null) {
				session.close();
				connection.close();
			}
		}
		return true;
	}

	private static String getLookupNom() {
		/*
		 * appname d�signe le nom de l'EAR qui es d�ploy�. Le suffixe ear est
		 * absent. Ce nom peut �tre laiss� vide mais il est pr�f�rable de le
		 * renseigner
		 */
		String appName = "";
		String nom ="";

		/*
		 * modulename d'signe le nom du JAR dans le quel l'EJB est encapsul�.
		 */
		String moduleName = "EJBInscription";

		/*
		 * ce nom n'est pas renseigné
		 */
		String distinctName = "";

		try {
		// Le nom de la classe Bean de l'EJB
		String beanName = AppelInscriptionBean.class.getSimpleName();

		// le nom de l'interface de l'EJB
		final String interfaceName = AppelInscriptionRemote.class.getName();

		// on crée la chaîne pour former le nom de la recherche
		 nom = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;

		} catch (Exception e) {
			System.out.println("Erreur client  :" + e.getMessage());
			e.printStackTrace();
		}
		return nom;
	}

}
