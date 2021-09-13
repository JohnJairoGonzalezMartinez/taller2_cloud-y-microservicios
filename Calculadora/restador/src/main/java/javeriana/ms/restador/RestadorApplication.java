package javeriana.ms.restador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestadorApplication.class, args);
	}

}
