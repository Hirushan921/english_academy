package model;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
   

    public static void send(String email, String sub, String content) {
        
        final String User_Name = "eduwebsch@gmail.com"; // Insert Your gmail address
        final String Password = "yaqmpwdkimcbozld"; // Insert Your gmail password
        final String Sender = "eduwebsch@gmail.com"; // Insert your gmail
        final String Receiver = email; // Insert Receiver's email address

        //Set the properties to send email
        Properties Mail_Prop = new Properties();
        Mail_Prop.put("mail.smtp.host", "smtp.gmail.com");
        Mail_Prop.put("mail.smtp.port", "465");
        Mail_Prop.put("mail.smtp.auth", "true");
        Mail_Prop.put("mail.smtp.starttls.enable", true);
        Mail_Prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Mail_Prop.put("mail.smtp.socketFactory.port", "465");
        Mail_Prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(Mail_Prop, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(User_Name, Password);
                    }
                });

        try {

            Message Mail_Content = new MimeMessage(session);
            Mail_Content.setFrom(new InternetAddress(Sender));
            Mail_Content.setRecipients( Message.RecipientType.TO, InternetAddress.parse(Receiver) );
            Mail_Content.setSubject(sub);
            Mail_Content.setText(content);
            Transport.send(Mail_Content);
//            System.out.println("Your Email has been sent successfully!");

        }
        catch (MessagingException e) {
//            System.out.println("Email Sending Failed");
            e.printStackTrace();
        }
    }
  
}
