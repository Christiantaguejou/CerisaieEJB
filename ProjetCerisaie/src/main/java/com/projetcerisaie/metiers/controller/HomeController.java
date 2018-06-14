package com.projetcerisaie.metiers.controller;

import Entities.Inscription;
import com.projetcerisaie.metiers.Entities.*;
import com.projetcerisaie.metiers.dao.*;
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
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
    public ModelAndView Afficheindex(HttpServletRequest request, HttpServletResponse response) {
        beforeTask(request);
        return new ModelAndView("home");
    }

    public void beforeTask(HttpServletRequest request) {
        SejourService service = new SejourService();
        request.setAttribute("sejours", service.geSejoursProposes());
    }

    @RequestMapping(value = "home.htm", method = RequestMethod.GET)
    public ModelAndView AfficheHome(HttpServletRequest request, HttpServletResponse response) {
        beforeTask(request);
        return new ModelAndView("home");
    }
    //TODO affichage erreur
    //TODO increment Nbloc lors de prochaine loc
    //TODO revoir laffichage du planning
/*
    public ModelAndView Erreur(Object o) {

        return new ModelAndView("erreur");
    }*/

    @RequestMapping(value = "login.htm", method = RequestMethod.GET)
    public ModelAndView AfficheLogin(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }

    /*
           @RequestMapping(value = "reservationConfirme.htm")
            public ModelAndView reservationConfirme(HttpServletRequest request, HttpServletResponse response) {

                return new ModelAndView("planning");
            }
    */
    @RequestMapping(value = "planning.htm")
    public ModelAndView listActivities(HttpServletRequest request, HttpServletResponse response) {
        ActivityService service = new ActivityService();
        request.setAttribute("activities", service.listActivities());
        if (true) {

        }
        return new ModelAndView("planning");
    }

    @RequestMapping(value = "reservationConfirme.htm")
    public ModelAndView reservationConfirme(HttpServletRequest request) {
        String destinationPage = "reservationConfirme";
        try {
            insererSejour(request);
            request.getSession().removeAttribute("numSej");
            // request.setAttribute("detailsResa",constructSejourReserveEntity(request));
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "confirmeReservation.htm")
    public ModelAndView confirmeReservation(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "confirmeReservation";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "espaceClient.htm")
    public ModelAndView espaceClient(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        ClientEntity clientSession = (ClientEntity) httpSession.getAttribute("loggedInClient");
        SejourService sejourService = new SejourService();
        List<SejoursReservesEntity> sejoursDuCli = sejourService.getSejoursReservesByClient(clientSession.getNumCli());
        request.setAttribute("sejoursReserves", sejoursDuCli);
        String destinationPage = "espaceClient/pageAccueilClient";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "insererClient.htm")
    public View insererClient(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "confirmeReservation";
        try {
            //si une reservation est en cours on va vers la confirmation de la resa
            ClientEntity client = constructClientEntity(request);
            if (client.getPassword().equals(request.getParameter("repeatSignonPassword"))) {
                GeneralOperations generalOperations = new GeneralOperations();
                generalOperations.insert(client);
                request.getSession().setAttribute("loggedInClient", client);
                if (request.getSession().getAttribute("numSej") != null) {
                    if (!request.getSession().getAttribute("numSej").equals("")) {
                        SejourService sejourService = new SejourService();
                        SejoursProposesEntity sejourPropose = sejourService.getSejourProposesEntity((int) request.getSession().getAttribute("numSej"));
                        request.setAttribute("sejourProposeEntity", sejourPropose);
                        destinationPage = "confirmeReservation.htm";
                    }
                } else {
                    ClientEntity clientSession = (ClientEntity) request.getSession().getAttribute("loggedInClient");
                    SejourService sejourService = new SejourService();
                    List<SejoursReservesEntity> sejoursDuCli = sejourService.getSejoursReservesByClient(clientSession.getNumCli());
                    request.setAttribute("sejoursReserves", sejoursDuCli);
                    destinationPage = "espaceClient/pageAccueilClient";
                }
            } else {
                request.setAttribute("MesErreurs", "Les deux mots de passe ne correspondent pas !");
                destinationPage = "erreur.htm";
            }
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur.htm";
        }

        return new RedirectView(destinationPage);
    }

    @RequestMapping(value = "insererActivite.htm")
    public ModelAndView insererActivite(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "espaceClient/pageAccueilClient";
        ClientEntity clientSession = (ClientEntity) request.getSession().getAttribute("loggedInClient");
        SejourService sejourService = new SejourService();
        List<SejoursReservesEntity> sejoursDuCli = sejourService.getSejoursReservesByClient(clientSession.getNumCli());
        request.setAttribute("sejoursReserves", sejoursDuCli);
        try {
            //TODO check si on est le même jour alors on incremente
            /*ActivityService activityService = new ActivityService();
            Inscription inscription = constructActivite(request);
            ActiviteEntity activiteEntity = activityService.getSpecificEntities(inscription.getCodeSport(),inscription.getDateJour(),inscription.getNumSej());
            System.out.println(activiteEntity);*/
          boolean ok = enregistrerActivite(constructActivite(request));
            if(!ok) {
                request.setAttribute("MesErreurs", "L'enregistrement a échoué");
                destinationPage = "erreur";
            }
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        return new ModelAndView(destinationPage);
    }

    public void insererSejour(HttpServletRequest request) {
        try {
            GeneralOperations generalOperations = new GeneralOperations();
            generalOperations.insert(constructSejourReserveEntity(request));
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
        }
    }

    @RequestMapping(value = "inscriptionClient.htm")
    public ModelAndView inscriptionClient(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            destinationPage = "inscription/client";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "doSignIn.htm")
    public ModelAndView authentification(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        ClientDaoImp clientDao = new ClientDaoImp();
        HttpSession httpSession = request.getSession();
        try {
            ClientEntity client = null;
            String login = "\'" + request.getParameter("login") + "\'";
            String mdp = "\'" + request.getParameter("password") + "\'";
            client = clientDao.autenticate(login, mdp);
            if (client != null) {
                httpSession.setAttribute("loggedInClient", client);
            }
            if (httpSession.getAttribute("numSej") != null) {
                if (!httpSession.getAttribute("numSej").equals("")) {
                    SejourService sejourService = new SejourService();
                    SejoursProposesEntity sejourPropose = sejourService.getSejourProposesEntity((int) httpSession.getAttribute("numSej"));
                    request.setAttribute("sejourProposeEntity", sejourPropose);
                    destinationPage = "confirmeReservation";
                }
            } else {
                ClientEntity clientSession = (ClientEntity) httpSession.getAttribute("loggedInClient");
                SejourService sejourService = new SejourService();
                List<SejoursReservesEntity> sejoursDuCli = sejourService.getSejoursReservesByClient(clientSession.getNumCli());
                request.setAttribute("sejoursReserves", sejoursDuCli);
                destinationPage = "espaceClient/pageAccueilClient";
            }
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "disconnect.htm")
    public View disconnection(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            request.getSession().removeAttribute("loggedInClient");
            destinationPage = "home.htm";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur.htm";
        }
        return new RedirectView(destinationPage);
    }

    @RequestMapping(value = "inscriptionActivite.htm")
    public ModelAndView inscriptionActivite(HttpServletRequest request, HttpServletResponse response) {
        String destinationPage = "";
        try {
            //get numsej if not redirect to espace client
            SejourService sejourService = new SejourService();
            ClientEntity clientEntity = (ClientEntity) request.getSession().getAttribute("loggedInClient");
            if (clientEntity != null) {
                SejoursReservesEntity sejoursReservesEntity = sejourService.getActiveSejour(clientEntity.getNumCli());
                if (sejoursReservesEntity != null) {
                    request.setAttribute("sej",sejoursReservesEntity);
                    destinationPage = "inscription/activite";
                } else {
                    HttpSession httpSession = request.getSession();
                    ClientEntity clientSession = (ClientEntity) httpSession.getAttribute("loggedInClient");
                    List<SejoursReservesEntity> sejoursDuCli = sejourService.getSejoursReservesByClient(clientSession.getNumCli());
                    request.setAttribute("sejoursReserves", sejoursDuCli);
                    destinationPage = "espaceClient/pageAccueilClient";
                }
            } else destinationPage = "home";

        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "reservationSejour.htm")
    public ModelAndView reservationSejour(HttpServletRequest request) {
        String destinationPage = "login";
        HttpSession http = request.getSession();
        try {
            int numSej = Integer.parseInt(request.getParameter("numSej"));
            http.setAttribute("numSej", numSej);
            if (http.getAttribute("loggedInClient") != null) {
                if (!http.getAttribute("loggedInClient").equals("")) {
                    SejourService sejourService = new SejourService();
                    SejoursProposesEntity sejourPropose = sejourService.getSejourProposesEntity((int) http.getAttribute("numSej"));
                    request.setAttribute("sejourProposeEntity", sejourPropose);
                    destinationPage = "confirmeReservation";
                }
            }
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "erreur";
        }
        return new ModelAndView(destinationPage);
    }

    // / Affichage de la page d'accueil
    // /
    @RequestMapping(value = "erreur.htm", method = RequestMethod.GET)
    public ModelAndView AfficheErreur(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("erreur");
    }

    @RequestMapping(value = "historiqueActivite.htm")
    public ModelAndView historique(HttpServletRequest request, HttpServletResponse response) {
        ActivityService activityService = new ActivityService();
        ClientEntity clientEntity = (ClientEntity) request.getSession().getAttribute("loggedInClient");
        List<ActiviteEntity> activiteEntities = activityService.getClientActivities(clientEntity.getNumCli());
        request.setAttribute("activities",activiteEntities);
        return new ModelAndView("espaceClient/historiqueActivite");
    }

    private ClientEntity constructClientEntity(HttpServletRequest request) {
        ClientEntity client = new ClientEntity();
        client.setNomCli(request.getParameter("nom"));
        client.setNumPieceCli(Integer.parseInt(request.getParameter("numPieceCli")));
        client.setAdrRueCli(request.getParameter("adresse"));
        client.setCpCli(Integer.parseInt(request.getParameter("codePostal")));
        client.setVilleCli(request.getParameter("ville"));
        client.setPieceCli(request.getParameter("pieceCli"));
        client.setUsername(request.getParameter("signonLogin"));
        client.setPassword(request.getParameter("signonPassword"));
        return client;
        //TODO javascript pour verifier que les deux mdp sont ok
    }

    private SejoursReservesEntity constructSejourReserveEntity(HttpServletRequest request) throws ParseException {
        SejoursReservesEntity sejour = new SejoursReservesEntity();
        SejourService sejourService = new SejourService();
        sejour.setClientEntity((ClientEntity) request.getSession().getAttribute("loggedInClient"));
        sejour.setDatedebSej(convertStringToDate(request.getParameter("dateDebSejour")));
        sejour.setDateFinSej(convertStringToDate(request.getParameter("dateFinSejour")));
        sejour.setNbPersonnes(Integer.parseInt(request.getParameter("nbPersonnes")));
        sejour.setSejoursProposesEntity(sejourService.getSejourProposesEntity((int) request.getSession().getAttribute("numSej")));
        sejour.setDateExpirationCarte(convertStringToDate(request.getParameter("dateExpiration")));
        sejour.setNumCarteCredit(Integer.parseInt(request.getParameter("numCarteCredit")));
        sejour.setTypeCarteCredit(request.getParameter("typeCarteCredit"));
        sejour.setTotalTtc(Integer.parseInt(request.getParameter("totalTtc")));
        return sejour;
    }

    public Date convertStringToDate(String date) throws ParseException {
        java.util.Date initDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String parsedDate = formatter.format(initDate);
        initDate = formatter.parse(parsedDate);
        return new Date(initDate.getTime());
    }

    private Inscription constructActivite(HttpServletRequest request) throws ParseException {
        Inscription inscription = new Inscription();
       // inscription.setNbLoc(Integer.parseInt(request.getParameter("nbloc")));
        inscription.setNbLoc(1);
        inscription.setCodeSport(Integer.parseInt(request.getParameter("codeSport")));
        inscription.setNumSej(Integer.parseInt(request.getParameter("numSej")));
        inscription.setDateJour(convertStringToDate(request.getParameter("dateLocation")));
        return inscription;
    }

    //TODO date de deb et fin de sejour doivent etre superieru a la date actuelle

    private boolean enregistrerActivite(Inscription inscription) throws Exception {

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
            message.setObject(inscription);
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
