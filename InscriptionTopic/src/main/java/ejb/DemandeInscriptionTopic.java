package ejb;
/*
import meserreurs.MonException;
import Entities.*;

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
// On se connecte � la file d'attente InscriptionTopic

/*
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/topic/InscriptionJmsTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")}, mappedName = "InscriptionJmsTopic")
public class DemandeInscriptionTopic implements MessageListener {

    @Resource
    private MessageDrivenContext context;

    public DemandeInscriptionTopic() {
        // TODO Auto-generated constructor stub
    }


    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        boolean ok = false;
        // On g�re le message r�cup�r� dans le topic
        try {
            // On transforme le message en demande d'inscription
            if (message != null) {
                System.out.println("je suis l� ");
                ObjectMessage objectMessage = (ObjectMessage) message;
                Inscription uneInscription = (Inscription) objectMessage.getObject();
                // On ins�re cette demande d'inscription dans la base de donn�es
                // on s'assure que l'�criture ne se fera qu'une fois.
                message = null;
                try {
                    // on construit un objet Entity
                    InscriptionEntity uneInsEntity = new InscriptionEntity();
                    // on tansf�re les donn�es re�ues dans l'objet Entity
                    uneInsEntity.setNomcandidat(uneInscription.getNomcandidat());
                    uneInsEntity.setPrenomcandidat(uneInscription.getPrenomcandidat());
                    uneInsEntity.setCpostal(uneInscription.getCpostal());
                    uneInsEntity.setVille(uneInscription.getVille());
                    uneInsEntity.setAdresse(uneInscription.getAdresse());
                    uneInsEntity.setDatenaissance(uneInscription.getDatenaissance());
                    EnregistreInscription uneE = new EnregistreInscription();
                    uneE.insertionInscription(uneInsEntity);
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


    public void EcritureErreur(String message) {
        BufferedWriter wr;
        String nomf = "erreurs.log";
        Date madate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
        try {
            // On �crit � la fin du fichier
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
*/