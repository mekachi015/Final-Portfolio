package com.example.Portfolio_Backend.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Portfolio_Backend.entity.ContactForm;

@Service
public class EmailService {

    // @Autowired
    // private JavaMailSender mailSender;

    // public void sendContactNotification(ContactForm contactForm){
    //     SimpleMailMessage message = new SimpleMailMessage();

    //     message.setTo("katlegomakoti@gmail.com");
    //     message.setSubject("New Contact Form Submission from " + contactForm.getName());

    //     String text = String.format(
    //         "You have received a new message from your portfolio contact form.%n%n" +
    //         "Name: %s%n" +
    //         "Email: %s%n%n" +
    //         "Message:%n%s",
    //         contactForm.getName(),
    //         contactForm.getEmail(),
    //         contactForm.getMessage()  
    //     );

    //     message.setText(text);

    //     mailSender.send(message);
    // }

    // public void sendAutoResponse(ContactForm contactForm){
    //     SimpleMailMessage message = new SimpleMailMessage();

    //     message.setTo(contactForm.getEmail());
    //     message.setSubject("Thank you for contacting me!");

    //     String text = String.format(
    //         "Dear %s,\n\nThank you for reaching out! " +
    //         "I have received your message and will get back to you as soon as possible.\n\n" +
    //         "Best regards,\nKatlego Makoti\nFull-Stack Developer",
    //         contactForm.getName()
    //     );
        
    //     message.setText(text);
        
    //     mailSender.send(message);
    // }

    //brevo implementation
    @Value("${brevo.api.key}")
    private String apiKey;

    @Value("${brevo.from.email}")
    private String fromEmail;

    @Value("${brevo.from.name}")
    private String fromName;

    @Value("${brevo.notification.to}")
    private String notificationTo;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    //Notication to me when contact form is submitted
    public void sendContactNotification(ContactForm contactForm){
        
        String subject = "New Contact Form Submission from " + contactForm.getName();


        String body = String.format(
            "You have received a new message from your portfolio contact form.\n\n" +
            "Name:    %s\n" +
            "Email:   %s\n\n" +
            "Message:\n%s",
            contactForm.getName(),
            contactForm.getEmail(),
            contactForm.getMessage()
        );

        sendEmail(notificationTo, subject, body);
    }

    //Auto respone to enquirer
    public void sendAutoResponse(ContactForm contactForm){
        String subject = "Thank you for contacting me!";

        
        String body = String.format(
            "Dear %s,\n\n" +
            "Thank you for reaching out! I have received your message and " +
            "will get back to you as soon as possible.\n\n" +
            "Best regards,\n" +
            "Katlego Makoti\n" +
            "Full-Stack Developer",
            contactForm.getName()
        );

        sendEmail(contactForm.getEmail(), subject, body);
    }


    //core sending logic using Brevo API
    private void sendEmail(String to, String subject, String text){
        String json = buildJsonPayload(to, subject, text);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.brevo.com/v3/smtp/email"))
            .header("Content-Type", "application/json")
            .header("api-key", apiKey)
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();

            try{
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                if(response.statusCode() >= 400){
                    throw new RuntimeException("Brevo Api error [" + response.statusCode() + "]" + response.body());
                }
            } catch(IOException | InterruptedException e){
                Thread.currentThread().interrupt();
                throw new RuntimeException("Failed to send email via brevo" + e.getMessage(), e);
            }
    }

    //payload helper
    private String buildJsonPayload(String to, String subject, String text){
        
         String safeText    = text.replace("\\", "\\\\")
                                 .replace("\"", "\\\"")
                                 .replace("\n", "\\n")
                                 .replace("\r", "");
        String safeSubject = subject.replace("\"", "\\\"");
        String safeName    = fromName.replace("\"", "\\\"");

        return String.format("""
            {
                "sender":      { "name": "%s", "email": "%s" },
                "to":          [{ "email": "%s" }],
                "subject":     "%s",
                "textContent": "%s"
            }
            """, safeName, fromEmail, to, safeSubject, safeText);
    }
}
