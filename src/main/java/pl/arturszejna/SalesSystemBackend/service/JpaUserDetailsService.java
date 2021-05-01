package pl.arturszejna.SalesSystemBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.entity.UserCredentials;
import pl.arturszejna.SalesSystemBackend.repository.UserCredentialsRepository;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private static final String NO_USER_WITH_USERNAME_S = "No user with username %s";

    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public JpaUserDetailsService(UserCredentialsRepository userCredentialsRepository){
        this.userCredentialsRepository =userCredentialsRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> usernameOptional = userCredentialsRepository.findByLogin(username);
        if (!usernameOptional.isPresent()){
            throw new UsernameNotFoundException(String.format(NO_USER_WITH_USERNAME_S, username));
        }
        return usernameOptional.get();
    }
}
