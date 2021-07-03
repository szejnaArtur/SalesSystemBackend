package pl.arturszejna.SalesSystemBackend.component.mailer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SignUpMailTextFactoryTest {

    @Test
    public void getConfirmationMailTextTest(){
        SignUpMailTextFactory textFactory = new SignUpMailTextFactory();
        String token = "a34584d7e4d8d4s115ds1s41d5";
        String message = "In order to activate your account enter: http://localhost:8080/confirm_email?token="+token;
        Assertions.assertEquals(message, textFactory.getConfirmationMailText(token));
    }

}