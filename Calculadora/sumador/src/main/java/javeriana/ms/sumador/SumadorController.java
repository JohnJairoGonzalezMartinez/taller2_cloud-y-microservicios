package javeriana.ms.sumador;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumadorController {

	private static String PORT = null;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/suma")
	public OperacionResponse suma(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("user") String user) throws Exception{
		double resultado = a + b;
		OperacionResponse resp = new OperacionResponse(resultado+"", user, "+", LocalDateTime.now(), "SERV" + getPort() );
		FileController.escribirArchivo("logSuma[" + getPort() + "].txt",  resp.toString() );
		return resp;
	}
	
	private String getPort() {
		if ( PORT == null ) {
			PORT = environment.getProperty("local.server.port");
		}
		return PORT;
	}
	
	
}
