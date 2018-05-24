package ejb;


import meserreurs.MonException;
import metier.*;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                System.out.println("dans le bean 1");
                ObjectMessage objectMessage = (ObjectMessage) message;
                System.out.println("dans le bean 2");
                ActiviteEntity uneInscription = new ActiviteEntity();
                uneInscription = (ActiviteEntity) objectMessage.getObject();
                try {
                    // on construit un objet Entity
                   /* ActiviteEntity uneInsEntity = new ActiviteEntity();
                    // on tansfère les données reçues dans l'objet Entity
                    uneInsEntity.setCodeSport(uneInscription.getCodeSport());
                    uneInsEntity.setDateJour(uneInscription.getDateJour());
                    uneInsEntity.setNbLoc(uneInscription.getNbLoc());
                    uneInsEntity.setNumSej(uneInscription.getNumSej());*/
                    EnregistreInscription uneE = new EnregistreInscription();
                    uneE.insertionInscription(uneInscription);
                    //uneE.insertionInscription(uneInsEntity);
                } catch (NamingException er) {
                    EcritureErreur(er.getMessage());
                } catch (MonException e) {
                    EcritureErreur(e.getMessage());
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

