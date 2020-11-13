package nuvemdesoftware.ceramicpro.authentication;

import ch.qos.logback.classic.Logger;
import nuvemdesoftware.ceramicpro.greeting.GreetingController;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailsImpl implements UserDetailsService {

    private Logger logger = (Logger) LoggerFactory.getLogger(UserDetailsImpl.class);

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername");
        return null;
    }
}
