package ec.edu.upse.alertas.ws;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.json.JsonObject;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;

import ec.edu.upse.alertas.modelo.MetodosGenerales;
import ec.edu.upse.alertas.modelo.UbicacionUsuario;
import ec.edu.upse.alertas.modelo.Usuario;
import ec.edu.upse.alertas.modelo.UsuarioAsignado;
import ec.edu.upse.alertas.modelo.repository.UbicacionUsuarioRepository;
import ec.edu.upse.alertas.modelo.repository.UsuarioRepository;

@RestController 
@RequestMapping(value="/ubicacionusuario")
public class WsUbicacionUsuario {
	
	@Autowired
	UbicacionUsuarioRepository ubicacionUsuarioRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/buscarubicacion/{id}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public UbicacionUsuario getubicacion(@PathVariable long id) {
		return ubicacionUsuarioRepository.findOne(id);
	}
	
	/**
	 * retorna la ubicacion  del usuario 
	 * @return
	 */
    @RequestMapping(value = "/ubicacionUsuario/{idusuario}", 
            method = RequestMethod.GET, 
            headers="Accept=application/json"
            ) 
    public List<UbicacionUsuario> getDiezUltimasUbicacion(@PathVariable Long idusuario){
    	
        Usuario tutoriados= new Usuario();
        UbicacionUsuario ubicacionUsuario = new UbicacionUsuario(); 
         
        tutoriados=usuarioRepository.findOne(idusuario);
        //ArrayList<String> ultimaUbicacion = new ArrayList<String>();
        ArrayList<UbicacionUsuario> diezUltimasUbicaciones = new ArrayList<UbicacionUsuario>();
        int acum=1;
        //System.out.println(tutoriados.getUbicacionUsuarios().size()); 
        
        for(int i=tutoriados.getUbicacionUsuarios().size()-1;i>0;i--){
            Long id=tutoriados.getUbicacionUsuarios().get(i).getIdubicacion();
            ubicacionUsuario=ubicacionUsuarioRepository.findOne(id);
            
            	 if( ubicacionUsuario.getUsuUbiLatitud()!=null && ubicacionUsuario.getUsuUbiLongitud()!=null ){
            		 if(acum<=10){
            		 diezUltimasUbicaciones.add(ubicacionUsuario);
            		 acum++;
            		 }
            	 }
                          
            //System.out.println("imprime ubicaciones : "+ misUbicaciones.get(i).getIdubicacion());  
        }
        
        //ultimaUbicacion.add("id:"+ubicacionUsuario.getIdubicacion()+" latitud:"+ubicacionUsuario.getUsuUbiLatitud()+" longitud:"+ubicacionUsuario.getUsuUbiLongitud());
     
       return diezUltimasUbicaciones;
    }
	
	
	/*
	 @RequestMapping(value = "/guardarUbicacion", 
		        method = RequestMethod.GET, 
		        headers="Accept=application/json")
	    @ResponseStatus(HttpStatus.OK)
	    public void saveUsuario() {
		    Usuario usuario = null; 
		    Date inicio = new Date() ,fin = new Date() ;
	        UbicacionUsuario ubicacionUsuario = new UbicacionUsuario();
	        Preconditions.checkNotNull(ubicacionUsuario);
            ubicacionUsuario.setUsuario(null);
            ubicacionUsuario.setUsuUbiPais("Ecuador");
            ubicacionUsuario.setUsuUbiProvincia("Santa Elena");
            ubicacionUsuario.setUsuUbiCiudad("La Libertad");
            ubicacionUsuario.setUsuUbiViapublica("La Libertad");
            ubicacionUsuario.setUsuUbiCodigopais("EC");
            ubicacionUsuario.setUsuUbiLongitud("-80.8802279");
            ubicacionUsuario.setUsuUbiLatitud("-2.2325452");
            ubicacionUsuario.setUsuUbiHoraInicio(inicio);
            ubicacionUsuario.setUsuUbiHoraFin(fin);
            ubicacionUsuario.setUsuUbiEstado("A");
	        ubicacionUsuarioRepository.save(ubicacionUsuario);
	    }
	
	*/
	
	/*
		@RequestMapping(value = "/verificar", 
		        method = RequestMethod.GET, 
		        headers="Accept=application/json") 
		public UbicacionUsuario getcadena(){
			
			Date inicio = new Date() ,fin = new Date() ;
			UbicacionUsuario ubicacionUsuario = new UbicacionUsuario();
			
			ubicacionUsuario.setUsuario(null);
            ubicacionUsuario.setUsuUbiPais("Ecuador");
            ubicacionUsuario.setUsuUbiProvincia("Santa Elena");
            ubicacionUsuario.setUsuUbiCiudad("La Libertad");
            ubicacionUsuario.setUsuUbiViapublica("La Libertad");
            ubicacionUsuario.setUsuUbiCodigopais("EC");
            ubicacionUsuario.setUsuUbiLongitud("-80.8802279");
            ubicacionUsuario.setUsuUbiLatitud("-2.2325452");
            ubicacionUsuario.setUsuUbiHoraInicio(inicio);
            ubicacionUsuario.setUsuUbiHoraFin(fin);
            ubicacionUsuario.setUsuUbiEstado("A");
            
            
            MetodosGenerales metodos = new MetodosGenerales();

  
			//String jsonn=metodos.ArrayJson(ubicacionUsuario.toString(), "records");
			//System.out.println(jsonn);
            //JSONPObject obj = new JSONPObject(getcadena(), ubicacionUsuario);
             
            
			//instanciar usuario por ejemplo
			//llenas
			//conviertes objeto usuario a string formato json
			//y transmitir como cadena
			//String cadena="{\"records\":[{\"Name\":\"1\",\"City\":\"123\",\"Country\":\"A\"}]}";
			//System.out.println(cadena);
			return ubicacionUsuario;
		}
	*/	
		@RequestMapping(value="/guardarUbicacion/{recursoJson}", 
		 	    method= RequestMethod.GET)
		public Long getRecursoById(@PathVariable("recursoJson") String jsoncompleto) {
			System.out.println(jsoncompleto);
			
			Date inicio= new Date();
			System.out.println(inicio);
			
			Calendar fecha = Calendar.getInstance();
			System.out.println(fecha);
			
			String  json1 = jsoncompleto.toString().replaceAll("&"," ");
			String  json2 = json1.replace("*",".");
           
		    System.out.println(json2);
		   		    
		    //crear un objeto gson
			final Gson gson = new Gson();
		    //crear el objeto de la clase y mandar todo el gson 			
			final UbicacionUsuario ubicacionUsuario = gson.fromJson(json2, UbicacionUsuario.class);
		    
			//asignar la fecha del lado del web services
		    ubicacionUsuario.setUsuUbiHoraInicio(inicio);
		    
		    //guardar 
		    ubicacionUsuarioRepository.save(ubicacionUsuario);
		    
		    //retorno el ultimo registro insertado
		    System.out.println("id ubic: "+ubicacionUsuario.getIdubicacion());
		    return ubicacionUsuario.getIdubicacion();
		   
			//return (ubicacionUsuario.toString());
		}
		
		/**
	     * Actualizar una ubicacion de un usuario
	     * @param id
	     */
		  @RequestMapping(value = "/actualizarUbicacion/{id}", 
			        method = RequestMethod.GET)
		    @ResponseStatus(HttpStatus.OK)
		    public boolean updateUsuario(@PathVariable("id") final Long id) {
			  
			  try {
				  Date fin= new Date();
				  System.out.println(fin);
				  Calendar fecha = Calendar.getInstance();
					System.out.println(fecha);
				  
				  
				  UbicacionUsuario ubicacionUsuario = ubicacionUsuarioRepository.findOne(id);
			        if ( ubicacionUsuario == null) {
			        	throw new RuntimeException("No encontrada");
			        }
			       
			        ubicacionUsuario.setUsuUbiHoraFin(fin);
			        ubicacionUsuarioRepository.save(ubicacionUsuario);
			        return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
				// TODO: handle exception
			}
			  
			 
		    }
		
		
		
		
}
