package pl.arturszejna.SalesSystemBackend.component;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class DaoAuthenticationProvider implements AuthenticationProvider {

    private static final String USERNAME_CANNOT_BE_NULL = "UserName cannot be null";
    private static final String CREDENTIALS_CANNOT_BE_NULL = "UserName cannot be null";
    private static final String INCORRECT_PASSWORD = "Incorrect password!";

    private final UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();

        Assert.notEmpty(Collections.singleton(name), USERNAME_CANNOT_BE_NULL);
        Assert.notEmpty((Object[]) credentials, CREDENTIALS_CANNOT_BE_NULL);

        if (credentials instanceof String) {
            return null;
        }

        String password = credentials.toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(name);

        boolean passwordMatch = userDetails.getPassword().equals(password);

        if (!passwordMatch) {
            throw new BadCredentialsException(INCORRECT_PASSWORD);
        }

        return new UsernamePasswordAuthenticationToken(name, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}