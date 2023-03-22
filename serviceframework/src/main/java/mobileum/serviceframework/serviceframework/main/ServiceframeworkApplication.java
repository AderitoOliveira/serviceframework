package mobileum.serviceframework.serviceframework.main;

import mobileum.serviceframework.serviceframework.controller.RestServiceController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = RestServiceController.class)
public class ServiceframeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceframeworkApplication.class, args);
	}

}
