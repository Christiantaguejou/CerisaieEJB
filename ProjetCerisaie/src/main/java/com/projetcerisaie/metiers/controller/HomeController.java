package com.projetcerisaie.metiers.controller;

import com.projetcerisaie.metiers.Entities.ActiviteEntity;
import com.projetcerisaie.metiers.Entities.ClientEntity;
import com.projetcerisaie.metiers.Entities.SejoursReservesEntity;
import com.projetcerisaie.metiers.dao.ActivityService;
import com.projetcerisaie.metiers.dao.GeneralOperations;
import com.projetcerisaie.metiers.dao.SejourService;
import com.projetcerisaie.metiers.dao.SportService;
import com.projetcerisaie.metiers.meserreurs.MonException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class HomeController {
    @Resource(lookup = "java:jboss/exported/topic/InscriptionJmsTopic")
    private Topic topic;

    // On accède à l'EJB
    @Resource(mappedName = "java:/ConnectionFactory")
    private TopicConnectionFactory cf;

    // Session établie avec le serveur
    private TopicSession session = null;

    // Le client utilise un Producteur de messsage pour envoyer une demande de formation
    private TopicPublisher producer;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "home.htm", method = RequestMethod.GET)
    public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("home");
    }
    //TODO affichage erreur
    //TODO increment Nbloc lors de prochaine loc
/*
    public ModelAndView Erreur(Object o) {

        return new ModelAndView("Erreur");
    }*/

    @RequestMapping(value = "planning.htm")
    public ModelAndView listActivities(HttpServletRequest request, HttpServletResponse response) {
        ActivityService service = new ActivityService();
        request.setAttribute("activities", service.listActivities());
        if (true) {

        }
        return new ModelAndView("planning");
    }


    @RequestMapping(value = "insererClient.htm")
    public View insererAdherent(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "listerAdherent.htm";
        try {
            GeneralOperations generalOperations = new GeneralOperations();
            generalOperations.insert(constructClientEntity(request));
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur.htm";
        }

        return new RedirectView(destinationPage);
    }

    @RequestMapping(value = "insererActivite.htm")
    public View insererActivite(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "listerAdherent.htm";
        try {
            boolean ok = enregistrerActivite(constructActivite(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try {
           boolean ok = enregistrerActivite(constructActivite(request));
            if(!ok) {
                request.setAttribute("MesErreurs", "L'enregistrement a échoué");
                destinationPage = "Erreur.htm";
            }
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur.htm";
        }
*/
        return new RedirectView(destinationPage);
    }


    @RequestMapping(value = "insererSejour.htm")
    public View insererSejour(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "listerAdherent.htm";
        try {
            GeneralOperations generalOperations = new GeneralOperations();
            generalOperations.insert(constructSejourEntity(request));
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur.htm";
        }

        return new RedirectView(destinationPage);
    }

    @RequestMapping(value = "inscriptionClient.htm")
    public ModelAndView inscriptionClient(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            destinationPage = "inscription/client";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }
    @RequestMapping(value = "inscriptionActivite.htm")
    public ModelAndView inscriptionActivite(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            destinationPage = "inscription/activite";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "reservationSejour.htm",method = RequestMethod.GET)
    public ModelAndView reservationSejour(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            destinationPage = "reservationSejour";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
    public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("Erreur");
    }

    private ClientEntity constructClientEntity(HttpServletRequest request) {
        ClientEntity client = new ClientEntity();
        client.setNomCli(request.getParameter("nom"));
        client.setNumPieceCli(Integer.parseInt(request.getParameter("numPieceCli")));
        client.setAdrRueCli(request.getParameter("adresse"));
        client.setCpCli(Integer.parseInt(request.getParameter("codePostal")));
        client.setVilleCli(request.getParameter("ville"));
        client.setPieceCli(request.getParameter("pieceCli"));
        return client;
    }

    private SejoursReservesEntity constructSejourEntity(HttpServletRequest request) {
        SejoursReservesEntity sejour = new SejoursReservesEntity();

        return sejour;
    }

    private ActiviteEntity constructActivite(HttpServletRequest request) throws ParseException {
        ActiviteEntity activite = new ActiviteEntity();
        SportService sportService = new SportService();
        SejourService sejourService =new SejourService();
        String dateLocation = request.getParameter("dateLocation");
        java.util.Date initDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateLocation);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String parsedDate = formatter.format(initDate);
        initDate = formatter.parse(parsedDate);
        Date dateLoc = new Date(initDate.getTime());
        activite.setNbLoc(Integer.parseInt(request.getParameter("nbloc")));
        activite.setSport(sportService.getSportEntity(Integer.parseInt(request.getParameter("codeSport"))));
        activite.setSejoursReservesEntity(sejourService.getSejourEntity(Integer.parseInt(request.getParameter("numSej"))));
        activite.setDateJour(dateLoc);
//
        return activite;
    }
    //TODO ajouter colonne disponibilite a emplacement et penser à espace client
    //TODO tarif en fonction de la durée du sejour

    private boolean enregistrerActivite(ActiviteEntity activite) throws Exception {

        boolean ok = true;
        TopicConnection connection = null;

        try {
            // On crée la connexion JMS , session, producteur et message;          /*           *
            //connection = connectionFactory.createConnection(System.getProperty("username", DEFAULT_USERNAME), System.getProperty("password", DEFAULT_PASSWORD));
            // Création Connection et Session JMS
            connection = cf.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            // On crée le producteur utilisé pour envoyer un message
            producer = session.createPublisher(topic);
            // On lance la connection
            connection.start();
            ObjectMessage message = session.createObjectMessage();
            message.setObject(activite);
            // On publie le message
            producer.publish(message);
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException j) {
            new MonException(j.getMessage());
            System.out.println(j.getMessage());
            ok = false;
        } catch (Exception e) {
            new MonException(e.getMessage());
            System.out.println(e.getMessage());
            ok = false;
        }
        return ok;
    }
}
