package com.projetcerisaie.metiers.DrivenBeans;
/*
import com.projetcerisaie.metiers.Entities.ActiviteEntity;
import com.projetcerisaie.metiers.dao.GeneralOperations;
import com.projetcerisaie.metiers.meserreurs.MonException;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;


@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/topic/CerisaieTopic"), @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")}, mappedName = "CerisaieTopic")
public class InscriptionSportBean implements MessageListener {
    @Resource
    private MessageDrivenContext context;

    public InscriptionSportBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            // On transforme le message en demande d'inscription
            if (message != null) {
            System.out.println("je suis là ");
            ObjectMessage objectMessage = (ObjectMessage) message;
            ActiviteEntity activite = (ActiviteEntity) objectMessage.getObject();
            // On insère cette demande d'inscription dans la base de données
                // on s'assure que l'écriture ne se fera qu'une fois.
                message = null;
                try {
                    // on construit un objet Entity
                    // on tansfère les données reçues dans l'objet Entity
                    GeneralOperations generalOperations = new GeneralOperations();
                    generalOperations.insert(activite);
                     }
                     catch (MonException e) {
                    //EcritureErreur(e.getMessage());
                         }
                    }
        } catch (JMSException jmse) {
            System.out.println(jmse.getMessage());
            context.setRollbackOnly();
        }
    }
}
*/