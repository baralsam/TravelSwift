/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author samik
 */
public class SendEmail {

    public static int generateVerificationCode() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); // Generates a random number between 100000 and 999999
    }

    public static boolean sendVerificationCode(String toEmail, String name, int verificationCode, boolean isForgotPassword) {
        final String username = "stravelswift@gmail.com"; // Replace with your Gmail email address
        final String password = "ocfq fzjt jyka ruor"; // Replace with your Gmail password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Verification Code for Customer Registration");
            String messageText;
            if (!isForgotPassword) {
                messageText = String.format("Hi " + name + ",\n\n"
                        + "Thank you for choosing our service! To complete your registration, please enter the following one-time verification code: %s.\n\n"
                        + "This code is valid for a single use and ensures the security of your account. If you did not request this code, please ignore this email. Welcome aboard!\n\n\n"
                        + "Thanks and Regards,\n"
                        + "Travel Swift", verificationCode);
            } else {
                messageText = String.format("Hi " + name + ",\n\n"
                        + "We received a request to reset your password for your Travel Swift account. Please use the following one-time verification code to proceed with the password reset: %s.\n\n"
                        + "This code is valid for a single use and is time-sensitive. If you did not initiate this password reset, please ignore this email.\n\n"
                        + "Thanks and Regards,\n"
                        + "Travel Swift", verificationCode);

            }
            message.setText(messageText);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", 587, username, password);
            Transport.send(message);

            System.out.println("Verification code sent to " + toEmail);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
