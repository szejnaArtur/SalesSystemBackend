package pl.arturszejna.SalesSystemBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.entity.User;
import pl.arturszejna.SalesSystemBackend.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User add(User newUser) {
        return userRepository.save(newUser);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public ResponseEntity delete(Long idUser){
        userRepository.deleteById(idUser);
        return ResponseEntity.ok().build();
    }


}
