package nuvemdesoftware.ceramicpro;

import ch.qos.logback.classic.Logger;
import nuvemdesoftware.ceramicpro.customer.Customer;
import nuvemdesoftware.ceramicpro.customer.ICustomerRepository;
import nuvemdesoftware.ceramicpro.greeting.GreetingController;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "nuvemdesoftware.ceramicpro" })
public class CeramicproApplication implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	private Logger logger = (Logger) LoggerFactory.getLogger(GreetingController.class);

	public static void main(String[] args) {

		 SpringApplication.run(CeramicproApplication.class, args);
/*
		new SpringApplicationBuilder(JettyServer.class)
				.web(WebApplicationType.NONE)
				.build()
				.run(args);
*/
		//SpringApplication springApplication =  new SpringApplicationBuilder().build(args);
		//springApplication.run(JettyServer.class);
	}


	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		//factory.setPort(9000);
		//factory.setContextPath("/myapp");
	}

	/*
	@Bean
	public CommandLineRunner demo(ICustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			logger.info("Customers found with findAll():");
			logger.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				logger.info(customer.toString());
			}
			logger.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			logger.info("Customer found with findById(1L):");
			logger.info("--------------------------------");
			logger.info(customer.toString());
			logger.info("");

			// fetch customers by last name
			logger.info("Customer found with findByLastName('Bauer'):");
			logger.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				logger.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			logger.info("");
		};
	}*/

}
