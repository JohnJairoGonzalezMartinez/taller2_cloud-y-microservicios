package javeriana.ms.multiplicador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MultiplicadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplicadorApplication.class, args);
	}

}
