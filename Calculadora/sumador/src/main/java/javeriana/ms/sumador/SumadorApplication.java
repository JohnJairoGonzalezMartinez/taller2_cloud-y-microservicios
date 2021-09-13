package javeriana.ms.sumador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SumadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SumadorApplication.class, args);
	}

}
