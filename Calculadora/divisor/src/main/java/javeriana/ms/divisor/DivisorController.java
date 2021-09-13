package javeriana.ms.divisor;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivisorController {

	private static String PORT = null;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/division")
	public OperacionResponse suma(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("user") String user) throws Exception{
		if ( b != 0 ) {
			double resultado = a / b;
			OperacionResponse resp = new OperacionResponse(resultado+"", user, "/", LocalDateTime.now(), "SERV" + getPort() );
			FileController.escribirArchivo("logDivision[" + getPort() + "].txt",  resp.toString() );
			return resp;	
		}
		else {
			OperacionResponse resp = new OperacionResponse("Error divisor=0", user, "-", LocalDateTime.now(), "SERV" + getPort() );
			FileController.escribirArchivo("logDivision[" + getPort() + "].txt",  resp.toString() );
			return resp;
		}
		
	}
	
	private String getPort() {
		if ( PORT == null ) {
			PORT = environment.getProperty("local.server.port");
		}
		return PORT;
	}
	
	
}
