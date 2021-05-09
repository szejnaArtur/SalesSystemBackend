package pl.arturszejna.SalesSystemBackend.component.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SignUpMailer {

    private final JavaMailSender emailSender;
    private final SignUpMailTextFactory textFactory;

    @Autowired
    public SignUpMailer(JavaMailSender emailSender, SignUpMailTextFactory textFactory) {
        this.emailSender = emailSender;
        this.textFactory = textFactory;
    }

    public void sendConfirmationLink(String email, String token){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(textFactory.getConfirmationMailSubject());
        message.setText(textFactory.getConfirmationMailText(token));
        emailSender.send(message);
    }

    public void sendMessage(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

}
