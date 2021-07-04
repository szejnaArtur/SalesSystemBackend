package pl.arturszejna.SalesSystemBackend.component.mailer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomStringFactoryTest {

    @Test
    public void givenNewTokenWhenLengthThenNewTokenLengthIsCorrect() {
        String token = RandomStringFactory.getRandomString(20);
        Assertions.assertEquals(20, token.length());
    }

    @Test
    public void givenNewTokenWhenLengthThenNewUniqueToken() {
        String token1 = RandomStringFactory.getRandomString(20);
        String token2 = RandomStringFactory.getRandomString(20);
        Assertions.assertNotEquals(token1, token2);
    }
}