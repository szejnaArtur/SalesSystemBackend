package pl.arturszejna.SalesSystemBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.arturszejna.SalesSystemBackend.component.CustomDaoAuthenticationProvider;
import pl.arturszejna.SalesSystemBackend.service.JpaUserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomDaoAuthenticationProvider authenticationProvider;
    private final JpaUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(JpaUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/confirm_email").permitAll()
                .antMatchers("/sign_up").hasAuthority("GENERAL_MANAGER")
                .anyRequest().permitAll()
//                .anyRequest().hasAuthority("JUNIOR_MANAGER")
                .and()

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/start_panel", true)
                .and()

                .logout()
                .logoutUrl("/user_logout")
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("cookies")
                .and()
//        ;
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
