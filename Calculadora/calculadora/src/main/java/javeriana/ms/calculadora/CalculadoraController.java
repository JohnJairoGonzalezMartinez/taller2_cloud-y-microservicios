package javeriana.ms.calculadora;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculadoraController {

	private static final String DB_FILE = "LogCalculadora.txt";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	private static void persistirRespuesta(OperacionResponse op) {
		try {
			FileController.escribirArchivo(DB_FILE, op.toString());
		} catch (Exception e) {}
	}
	
	@GetMapping("calculadora/suma")
	public OperacionResponse calculadoraSuma(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("user") String user) {
		OperacionResponse response = restTemplate.getForObject("http://sumador/suma?a={a}&b={b}&user={user}", OperacionResponse.class, a, b, user);		
		persistirRespuesta(response);
		return response;
	}
	
	@GetMapping("calculadora/resta")
	public OperacionResponse calculadoraResta(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("user") String user) {
		OperacionResponse response = restTemplate.getForObject("http://restador/resta?a={a}&b={b}&user={user}", OperacionResponse.class, a, b, user);		
		persistirRespuesta(response);
		return response;
	}
	
	@GetMapping("calculadora/multiplicacion")
	public OperacionResponse calculadoraMultiplicacion(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("user") String user) {
		OperacionResponse response = restTemplate.getForObject("http://multiplicador/multiplicacion?a={a}&b={b}&user={user}", OperacionResponse.class, a, b, user);		
		persistirRespuesta(response);
		return response;
	}
	
	@GetMapping("calculadora/division")
	public OperacionResponse calculadoraDivision(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("user") String user) {
		OperacionResponse response = restTemplate.getForObject("http://divisor/division?a={a}&b={b}&user={user}", OperacionResponse.class, a, b, user);		
		persistirRespuesta(response);
		return response;
	}
	
	@GetMapping("calculadora/logs")
	public String calculadoraLogs() throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		List<String> response = FileController.leerArchivo(DB_FILE);
		for(String itResp : response) {
			sb.append( itResp + "\n");
			sb.append("\n");
		}
		return sb.toString();
	}
}
