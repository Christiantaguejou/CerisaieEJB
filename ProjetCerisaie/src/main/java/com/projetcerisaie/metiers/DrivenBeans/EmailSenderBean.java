package com.projetcerisaie.metiers.DrivenBeans;

import Entities.Order.Order;
import Entities.Order.OrderLine;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.*;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

import static javax.mail.Message.RecipientType.TO;
/*
* ,activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "emailSenderID"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "EmailSender"*/

@MessageDriven(name = "EmailSenderEJB",mappedName = "jms/topic/order")
public class EmailSenderBean implements MessageListener {
    @Resource(mappedName = "jms/javamail/sendmailsession")
    Session session;
    // ======================================
    // =             Attributes             =
    // ======================================

    private final String cname = this.getClass().getName();
    //private Logger logger = Logger.getLogger(Constants.LOGGER_MDB);


    // ======================================
    // =           Private methods          =
    // ======================================

    private void sendEMail(Order order) throws MessagingException {
        final String mname = "createAndSendMail";

        //Properties properties = new Properties();
        //properties.put("mail.smtp.host", SMTP_HOST);
        //properties.put("mail.smtp.auth", "true");

        //Session session = Session.getInstance(properties, null);
    try {
        Message msg = new MimeMessage(session);
        //msg.setFrom(new InternetAddress("no-reply@antoniogoncalves.org"));
        String email = order.getCustomer().getEmail();

        msg.setRecipients(TO, InternetAddress.parse(email, false));
        msg.setSubject(formatSubject(order));
        msg.setText(formatBody(order));
        msg.setSentDate(new Date());
        Transport.send(msg);
    }catch (MessagingException me){

    }
       /* Transport transport = session.getTransport("smtp");
        try {
            transport.connect(SMTP_HOST, USER, PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (MessagingException me) {
        } finally {
            try {
                transport.close();
            } catch (MessagingException e) {
            }
        }*/
    }

    private String formatSubject(Order order) {
        return "[YAPS] Confirmation: Order #" + order.getId();
    }

    private String formatBody(Order order) {
        StringBuffer sb = new StringBuffer();
        sb.append("Dear ");
        sb.append(order.getCustomer().getFirstname());
        sb.append(",\n your order #");
        sb.append(order.getId());
        sb.append(" has been successfully placed.");

        sb.append("Your shopping cart content is:\n");
        for (OrderLine line : order.getOrderLines()) {
            sb.append("\t");
            sb.append(line.getItem().getName());
            sb.append(" x");
            sb.append(line.getQuantity());
            sb.append("\n");
        }
        sb.append("\n\n");
        sb.append("Looking forward to serve you again,");
        sb.append("\n\nThe YAPS team.");
        return sb.toString();
    }

    @Override
    public void onMessage(javax.jms.Message message) {
        final String mname = "onMessage";
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
                Order order = (Order) msg.getObject();
                sendEMail(order);
            }
        } catch (JMSException e) {
            // rollback the undergoing transaction if error occured
            throw new EJBException(e);
        } catch (MessagingException e) {
            // rollback the undergoing transaction if error occured
            throw new EJBException(e);
        }
    }
}
