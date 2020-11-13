package nuvemdesoftware.ceramicpro.authentication;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyDatabaseUserDetailsService implements UserDetailsService {

    private Logger logger = (Logger) LoggerFactory.getLogger(MyDatabaseUserDetailsService.class);

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyDatabaseUserDetailsService(); // (1)
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}