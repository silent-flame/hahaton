package com.brotuny.proj.notifications;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class SmtpEmailSender {
  private final String from = "dzhedu@yandex.ru";
  private final String username = "dzhedu";
  private final String password = "hjpty,fev1991";

  private final String server = "smtp.yandex.ru";
  private final int port = 465;

  /**
   * sending email
   *
   * @param to      recipient
   * @param subject topic
   * @param msg     message body
   */
  public void sendEmail(String to, String subject, String msg) {
    try {
      Properties props = new Properties();
      props.put("mail.transport.protocol", "smtps");

      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.socketFactory.port", port);
      props.put("mail.smtp.socketFactory.class",
              "javax.net.ssl.SSLSocketFactory");

      props.put("mail.smtp.auth", "true");

      props.put("mail.smtp.host", server);
      props.put("mail.smtp.port", port);
      props.put("mail.smtp.timeout", "10000");

      props.put("mail.smtp.ssl.checkserveridentity", "false");
      props.put("mail.smtp.ssl.trust", "*");
      props.put("mail.smtp.connectiontimeout", "10000");

      props.put("mail.smtp.debug", "true");
      props.put("mail.smtp.socketFactory.fallback", "false");
      Session session = Session.getInstance(props,
              new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(username, password);
                }
              });
      session.setDebug(true);

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.setRecipients(
              Message.RecipientType.TO, InternetAddress.parse(to));
      message.setSubject(subject);

      MimeBodyPart mimeBodyPart = new MimeBodyPart();
      mimeBodyPart.setContent(msg, "text/html");

      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(mimeBodyPart);

      message.setContent(multipart);

      Transport.send(message);


    } catch (Throwable t) {
      log.error("Error", t);
      System.out.println(t);
    }
  }

}
