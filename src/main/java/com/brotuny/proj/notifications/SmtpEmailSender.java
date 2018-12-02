package com.brotuny.proj.notifications;

import com.brotuny.proj.data.mapper.StageMapper;
import com.brotuny.proj.data.model.Stage;
import com.brotuny.proj.data.model.User;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Service
public class SmtpEmailSender {

    private final String FROM = "dzhedu@yandex.ru";
    private final String USERNAME = "dzhedu";
    private final String PASSWORD = "hjpty,fev1991";

    private final String SERVER = "smtp.yandex.ru";
    private final int PORT = 465;

    private final StageMapper stageMapper;
    private final EmailCreater emailCreater;

    public SmtpEmailSender(StageMapper stageMapper, EmailCreater emailCreater) {
        this.stageMapper = stageMapper;
        this.emailCreater = emailCreater;
    }

    /**
     * sending email
     */
    public void sendEmail(Stage stage) {
        try {

            String subject = String.format("Обновление статуса этапа: %s", stage.getTitle());
            String msg = emailCreater.createMail(stage);

            User[] users = stageMapper.getUsersByStage(stage.getId());

            for (User user : users) {

                String to = user.getEmail();


                Properties props = new Properties();
                props.put("mail.transport.protocol", "smtps");

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.socketFactory.port", PORT);
                props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");

                props.put("mail.smtp.auth", "true");

                props.put("mail.smtp.host", SERVER);
                props.put("mail.smtp.port", PORT);
                props.put("mail.smtp.timeout", "10000");

                props.put("mail.smtp.ssl.checkserveridentity", "false");
                props.put("mail.smtp.ssl.trust", "*");
                props.put("mail.smtp.connectiontimeout", "10000");

                props.put("mail.smtp.debug", "true");
                props.put("mail.smtp.socketFactory.fallback", "false");
                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(USERNAME, PASSWORD);
                            }
                        });
                session.setDebug(true);

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(FROM));
                message.setRecipients(
                        Message.RecipientType.TO, InternetAddress.parse(to));
                message.setSubject(subject);

                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);

                message.setContent(multipart);

                Transport.send(message);
            }


        } catch (Throwable t) {
            System.out.println(t);
        }
    }

}
