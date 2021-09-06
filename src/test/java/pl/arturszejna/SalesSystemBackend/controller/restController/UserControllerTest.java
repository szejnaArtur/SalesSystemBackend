package pl.arturszejna.SalesSystemBackend.controller.restController;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import pl.arturszejna.SalesSystemBackend.entity.User;

import java.util.ArrayList;
import java.util.List;

class UserControllerTest {

    @Test
    public void getUsers() {
        //Given
        UserController userController = Mockito.mock(UserController.class);
        BDDMockito.given(userController.findAll()).willReturn(prepareMockData());
        //When
        List<User> users = userController.findAll();
        //Then
        MatcherAssert.assertThat(users, Matchers.hasSize(3));
    }

    private List<User> prepareMockData() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Monika", "Brodka", "brodka@testmail.com", 555666777));
        userList.add(new User("Krzysztof", "Krawczyk", "krawczyk@testmail.com", 777888999));
        userList.add(new User("Cezary", "Pazura", "pazura@testmail.com", 666777888));
        return userList;
    }

    @Test
    public void addUser() {
        //Given
        UserController userController = Mockito.mock(UserController.class);
        BDDMockito.given(userController.add(Mockito.any(User.class))).willReturn(
                new User("Artur", "Kowalski", "kowalski@testmail.com", 888445566)
        );
        //When
        User user = userController.add(new User());
        //Then
        Assertions.assertEquals(user.getFirstName(), "Artur");
    }
}