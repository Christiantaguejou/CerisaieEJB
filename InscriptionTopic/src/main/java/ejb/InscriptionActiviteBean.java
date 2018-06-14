package ejb;


import dao.ActivityService;
import dao.SejourService;
import dao.SportService;
import Entities.*;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import service.EnregistreInscription;

/**
 * Message-Driven Bean implementation class for: DemandeInscriptionTopic
 */
// On se connecte à la file d'attente InscriptionTopic
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/topic/InscriptionJmsTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")}, mappedName = "InscriptionJmsTopic")
public class InscriptionActiviteBean implements MessageListener {

    @Resource
    private MessageDrivenContext context;

    /*
     * Default constructor.
     */
    public InscriptionActiviteBean() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        boolean ok = false;
        // On gère le message récupéré dans le topic
        try {
            // On transforme le message en demande d'inscription
            if (message != null) {
                System.out.println("bean 1");
                ObjectMessage objectMessage = (ObjectMessage) message;
                System.out.println("bean 2");
                if(objectMessage.getObject() != null ){
                    System.out.println("bean 3");
                    System.out.println((objectMessage.getObject()).toString());
                    System.out.println("bean 4");

                    System.out.println("bean 5");
                }else {
                    System.out.println("bean 6");
                }
                Serializable obj = objectMessage.getObject();
                //Inscription uneInscription = (Inscription) obj;
               message=null;
                try {
                    System.out.println("bean 7");
                    Inscription uneInscription = (Inscription) obj;
                    System.out.println("bean 8");
                    // on construit un objet Entity
                   ActiviteEntity activite = new ActiviteEntity();
                    System.out.println("bean 9");
                    // on transfère les données reçues dans l'objet Entity
                    SportService sportService = new SportService();
                    ActivityService activityService = new ActivityService();
                    activite = activityService.getSpecificEntities(uneInscription.getCodeSport(),uneInscription.getDateJour(),uneInscription.getNumSej());
                    if(activite == null){
                        activite = new ActiviteEntity();
                        System.out.println("bean 10");
                        SejourService sejourService = new SejourService();
                        System.out.println("bean 12");
                        activite.setSejoursReservesEntity(sejourService.getSejourReservesEntity(uneInscription.getNumSej()));
                        System.out.println("bean 13");
                        activite.setSport(sportService.getSportEntity(uneInscription.getCodeSport()));
                        System.out.println("bean 14");
                        activite.setDateJour(uneInscription.getDateJour());
                        System.out.println("bean 15");
                        activite.setNbLoc(1);
                        EnregistreInscription uneE = new EnregistreInscription();
                        System.out.println("bean 16");
                        uneE.insertionInscription(activite);
                        System.out.println("bean 17");
                    }else{
                        EnregistreInscription uneE = new EnregistreInscription();
                        System.out.println("bean 18");
                        activite.setNbLoc(activite.getNbLoc()+1);
                        uneE.updateInscription(activite);
                        System.out.println("bean 19");
                    }

                    //uneE.insertionInscription(uneInsEntity);
                } catch (Exception ex) {
                    EcritureErreur(ex.getMessage());
                }
            }

        } catch (JMSException jmse) {
            System.out.println(jmse.getMessage());
            EcritureErreur(jmse.getMessage());
            context.setRollbackOnly();
        }
    }

    /**
     * Permet d'enregistrer une erreur dans un fichier log
     *
     * @param message Le message d'erreur
     */
    public void EcritureErreur(String message) {
        BufferedWriter wr;
        String nomf = "erreurs.log";
        Date madate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
        try {
            // On écrit à la fin du fichier
            wr = new BufferedWriter(new FileWriter(nomf, true));
            wr.newLine();
            wr.write(sdf.format(madate));
            wr.newLine();
            wr.write(message);
            wr.close();
        } catch (FileNotFoundException ef) {
            ;
        } catch (IOException eio) {
            ;
        }
    }
}

