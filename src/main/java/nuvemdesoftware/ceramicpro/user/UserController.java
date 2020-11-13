package nuvemdesoftware.ceramicpro.user;

import ch.qos.logback.classic.Logger;
import nuvemdesoftware.ceramicpro.greeting.GreetingController;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

}
