package pl.arturszejna.SalesSystemBackend.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.arturszejna.SalesSystemBackend.entity.UserCredentials;
import pl.arturszejna.SalesSystemBackend.repository.UserCredentialsRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserCredentials> optionalUserCredentials = userCredentialsRepository.findByLogin(login);
        if (!optionalUserCredentials.isPresent()) {
            throw new UsernameNotFoundException("There is no such user");
        }
        return optionalUserCredentials.get();
    }
}
