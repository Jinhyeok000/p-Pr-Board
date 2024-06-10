//package commons;
//
//import java.util.Properties;
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.websocket.Session;
//
//public class EmailFind {
//
//    public static void sendEmail(String to, String subject, String content) {
//        final String username = "hycho2200@gmail.com";
////        final String password = "내 비밀번호";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
//
//        Session session = Session.getInstance(props,
//          new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//          });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("hycho2200@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//            message.setSubject(subject);
//            message.setText(content);
//
//            Transport.send(message);
//
//            System.out.println("Email sent successfully");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
