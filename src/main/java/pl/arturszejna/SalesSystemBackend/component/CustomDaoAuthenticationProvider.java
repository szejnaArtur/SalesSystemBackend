package pl.arturszejna.SalesSystemBackend.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import pl.arturszejna.SalesSystemBackend.service.JpaUserDetailsService;

@Component
public class CustomDaoAuthenticationProvider implements AuthenticationProvider {

    private static final String USERNAME_CANNOT_BE_NULL = "Username cannot be null";
    private static final String CREDENSIALS_CANNOT_BE_NULL = "Credensials cannot be null";
    private static final String INCORRECT_PSSWORD = "Incorrect password";

    private final JpaUserDetailsService userDetailsService;

    @Autowired
    public CustomDaoAuthenticationProvider(JpaUserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();

        Assert.notNull(name, USERNAME_CANNOT_BE_NULL);
        Assert.notNull(credentials, CREDENSIALS_CANNOT_BE_NULL);

        if (!(credentials instanceof String)){
            return null;
        }

        String password = credentials.toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);

        if (!userDetails.getPassword().equals(password)){
            throw new BadCredentialsException(INCORRECT_PSSWORD);
        }

        return new UsernamePasswordAuthenticationToken(name, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
