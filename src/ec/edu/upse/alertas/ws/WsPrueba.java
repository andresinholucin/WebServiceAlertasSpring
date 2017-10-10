package ec.edu.upse.alertas.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value="/prueba")
public class WsPrueba {

	@RequestMapping(value = "/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        ) 
	public String getcadena(){
		return "hola";
	}
}
