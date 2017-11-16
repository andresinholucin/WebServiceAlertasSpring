package ec.edu.upse.alertas.ws;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.json.Json;
import javax.json.JsonException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import ec.edu.upse.alertas.modelo.EmisionAlerta;
import ec.edu.upse.alertas.modelo.Usuario;
import ec.edu.upse.alertas.modelo.UsuarioAsignado;
import ec.edu.upse.alertas.modelo.TipoAlerta;
import ec.edu.upse.alertas.modelo.repository.AlertaRepository;
import ec.edu.upse.alertas.modelo.repository.UsuarioRepository;
import ec.edu.upse.alertas.notificaciones.PushNotificacion;

@RestController 


@RequestMapping(value="/emisionAlerta")
public class WsAlerta {
	
	PushNotificacion notificaciones2 = new PushNotificacion();
	@Autowired
	UsuarioRepository usuarioRepository ;
	
	@Autowired
	AlertaRepository alertaRepository;
	
	
	@RequestMapping(value = "/buscaAlertaPorId/{id}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	@JsonTypeInfo(include=As.WRAPPER_OBJECT, use=Id.NAME) 
	public EmisionAlerta getEmisionAlerta(@PathVariable long id) {

		return alertaRepository.findOne(id);
	}
	
	@RequestMapping(value = "/alertas/{pais}", 
            method = RequestMethod.GET, 
            headers="Accept=application/json"
            ) 
    public List<EmisionAlerta> getemisionAlertaPorPais(@PathVariable String pais){
		return alertaRepository.emisionAlertaPorPais(pais);
    }
	
	@RequestMapping(value = "/alertasUsuario/{usuario}", 
            method = RequestMethod.GET, 
            headers="Accept=application/json"
            ) 
    public List<EmisionAlerta> getemisionAlertaPorUsuario(@PathVariable String usuario){
		Usuario usuario2 = new Usuario();
		Gson gson = new Gson();
		usuario2 = gson.fromJson(usuario, Usuario.class);
		System.out.println(usuario2.getUsuUNombres());
		//return usuario2.getUsuUNombres();
		System.out.println("imprime lista : "+ alertaRepository.emisionAlertaPorUsuario(usuario2)); 
		
		return alertaRepository.emisionAlertaPorUsuario(usuario2);
		
    }
	
	@RequestMapping(value = "/alertasUsuario2/{usuario}", 
            method = RequestMethod.GET, 
            headers="Accept=application/json"
            ) 
    public List<EmisionAlerta> getemisionAlertaPorUsuario2(@PathVariable String usuario){
		Usuario usuario2 = new Usuario();
		Gson gson = new Gson();
		usuario2 = gson.fromJson(usuario, Usuario.class);
		
		ArrayList<EmisionAlerta> retorno = new ArrayList<EmisionAlerta>();
		List<EmisionAlerta> lista = alertaRepository.emisionAlertaPorUsuario(usuario2);
		ArrayList<EmisionAlerta> milista = new ArrayList<EmisionAlerta>();
	        		
		for(int i=0; i<lista.size();i++){
			
			EmisionAlerta usuarioAux = new EmisionAlerta();
			
			retorno.add(usuarioAux);
			milista.add(lista.get(i));
			System.out.println("imprime lista : "+ milista.get(i).getIdemisionAlerta() +","+milista.get(i).getUsuAlerCiudad() ); 
		 	
		}
	
		return milista;
	
		/*
		//return usuario2.getUsuUNombres();
		//System.out.println("imprime lista : "+ alertaRepository.emisionAlertaPorUsuario(usuario2)); 
		alertaRepository.emisionAlertaPorUsuario(usuario2);
		System.out.println("imprime lista : "+ alertaRepository.emisionAlertaPorUsuario(usuario2).get(0).getUsuAlerPais()); 
		return alertaRepository.emisionAlertaPorUsuario(usuario2);*/
		  
	}
	
	 @RequestMapping(value = "/udt/{idusuario}", 
	            method = RequestMethod.GET, 
	            headers="Accept=application/json"
	            ) 
	    public List<EmisionAlerta> getListaAlertas(@PathVariable Long idusuario){
	        Usuario usuario = new Usuario();
	        EmisionAlerta emisionAlerta = new EmisionAlerta();
	        
	        usuario=usuarioRepository.findOne(idusuario);
	        ArrayList<EmisionAlerta> milista = new ArrayList<EmisionAlerta>();
	        
	        for(int i=0; i<usuario.getEmisionAlertas().size();i++){
	        
	            Long id=usuario.getEmisionAlertas().get(i).getIdemisionAlerta();
	            emisionAlerta=alertaRepository.findOne(id);
	            
	            //usuarioasignado=usuarioAsignadoRepositorio.findOne(id);
	            milista.add(emisionAlerta);
	           // milista.add(usuarioasignado.getUsuario2());
	            System.out.println("imprime lista : "+ milista.get(i).getUsuAlerViapublica());  
	        }
	           
	        return milista;
	    }
	
	@RequestMapping(value = "/eliminarAlerta/{id}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public void EliminarEmisionAlerta(@PathVariable long id) {
		if (alertaRepository.findOne(id)!=null)	
			alertaRepository.delete(id);
	}
	
	/*@RequestMapping(value="/guarda/{cadena}", 
		    method= RequestMethod.GET)
			public Object getGuardarByJson(@PathVariable("cadena") String todoId) {
				
				String todoId1 = todoId.replace("&", " ");
				String todoId2 = todoId1.replace("*", ".");
				System.out.println(todoId2);
				EmisionAlerta dato = new EmisionAlerta();
				Gson gson = new Gson();
				dato = gson.fromJson(todoId2, EmisionAlerta.class);
				System.out.println(dato.getUsuAlerCodigopais());
				System.out.println(dato.getUsuAlerPais());
				
				//System.out.println(dato.getIdTipoDiscapacidad());
				System.out.println(dato.toString());
				alertaRepository.save(dato);
				return (dato.toString());

	}*/	
	
	
	@RequestMapping(value = "/guardapost/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrapersonaprueba(@RequestBody EmisionAlerta emisionAlerta, HttpServletResponse response) {
		try {
			//Preconditions.checkNotNull(emisionAlerta);
			Date fecha= new Date();
			emisionAlerta.setUsuAlerFecha(fecha);
			alertaRepository.save(emisionAlerta);
			notificaciones2.send();
			System.out.println(emisionAlerta.getUsuario().getIdusuario().toString());
			String usuario = emisionAlerta.getUsuario().getIdusuario().toString();
			notificaciones2.sendUsuario(usuario);
			//notificaciones.pushFCMNotification("cjUE9iy6y1Q:APA91bElOnDP-PjLYM26lbxSVMtWIfRjBCYs4d0Ry3Im6Zz-nQn6GbM3dbP3pUCe1ur1ikLrqpv2KvxgGL5MzdNQ094rje4YXT1p-bsKJV4jdrCS523iqdT6RfiSDCTSdjCVD_4AQWKZ", "hola", "hola");	
			System.out.println(emisionAlerta.getUsuAlerPais());
	        return emisionAlerta;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	
}
