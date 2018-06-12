package com.projetcerisaie.metiers;

import Entities.Inscription;
import com.projetcerisaie.metiers.Entities.ClientEntity;
import com.projetcerisaie.metiers.dao.GeneralOperations;
import com.projetcerisaie.metiers.meserreurs.MonException;

import javax.annotation.Resource;
import javax.jms.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test {
    @Resource(lookup = "java:jboss/exported/topic/InscriptionJmsTopic")
    private static Topic topic;

    // On accède à l'EJB
    @Resource(mappedName = "java:/ConnectionFactory")
    private static TopicConnectionFactory cf;

    // Session établie avec le serveur
    private static TopicSession session = null;

    // Le client utilise un Producteur de messsage pour envoyer une demande de formation
    private static TopicPublisher producer;

    public static void main(String[] args) throws MonException {
        Inscription inscription = new Inscription();
        inscription.setCodeSport(1);
        java.util.Date initDate = null;
        try {
            initDate = new SimpleDateFormat("dd/MM/yyyy").parse("08/06/2018");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String parsedDate = formatter.format(initDate);
            initDate = formatter.parse(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        inscription.setDateJour(new Date(initDate.getTime()));
        inscription.setNbLoc(1);
        inscription.setNumSej(1);


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



        // Add Persons
       // generalOperations.insert(new ClientEntity("Bor"));

    }
}
