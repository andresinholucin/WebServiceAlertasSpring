package ec.edu.upse.alertas.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Preconditions;

import ec.edu.upse.alertas.config.AuxDevolucion;
import ec.edu.upse.alertas.modelo.MetodosGenerales;
import ec.edu.upse.alertas.modelo.UbicacionUsuario;
import ec.edu.upse.alertas.modelo.Usuario;
import ec.edu.upse.alertas.modelo.UsuarioAsignado;
import ec.edu.upse.alertas.modelo.repository.UsuarioAsignadoRepository;
import ec.edu.upse.alertas.modelo.repository.UsuarioRepository;

/**
 * Gestiona los servicios de usuarios.
 * @author gitwyn_pc
 *
 */
@RestController 
@RequestMapping(value="/usuario")
public class WsUsuario {
	
	// Automaticamente instancia un objeto de tipo Repositoty 
	// que contiene todoslos metods CRUD
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioAsignadoRepository usuarioAsignadoRepository;

	//@Autowired
	//UsuarioAsignadoRepositorio usuarioAsignadoRepositorio;
	
	@RequestMapping(value = "/buscaPorId/{id}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public Usuario getUsuario(@PathVariable long id) {
		return usuarioRepository.findOne(id);
	}
	
	/**
	 * retorna el id del usuario cuando inicia sesion
	 * @return
	 */
	/*
	@RequestMapping(value = "/login/{usuario}/{clave}", 
	        method = RequestMethod.GET,
	        headers="Accept=application/json") 
	public Long getLoginUsurio (@PathVariable String usuario,@PathVariable String clave) {
		 
		System.out.println(usuario +" - "+clave);
		
		Usuario usu = new Usuario();
		//UsuarioAsignado usuarioAsignado = new UsuarioAsignado();
		Long id = usuarioRepository.loginUsuario(usuario,clave);
		
		usu = usuarioRepository.findOne(id);
		
	    List<Long> lstUsuario = new ArrayList<>(); 
	    
	    lstUsuario=usuarioAsignadoRepository.loginUsuarioAsignado(usu);
	    
	    if (lstUsuario.size()!=0)
	    	return (long) 1;	    	
	    else
	    	return (long) 2;
	    
	    //return usuarioRepository.loginUsuario(usuario,clave);
	}
	*/
	
	
	/**
	 * retorna la clase AuxDevolucion que contiene el id del usuario y el tipo si es tutor o tutoreado
	 * 1 tutor 2 tutoredo
	 * @return
	 */
	
	@RequestMapping(value = "/login/{usuario}/{clave}", 
	        method = RequestMethod.GET,
	        headers="Accept=application/json") 
	public AuxDevolucion getLoginUsurio (@PathVariable String usuario,@PathVariable String clave) {
		Usuario usu = new Usuario();
		
		AuxDevolucion auxIdTipo=new AuxDevolucion();
		//UsuarioAsignado usuarioAsignado = new UsuarioAsignado();
		Long id = usuarioRepository.loginUsuario(usuario,clave);
		System.out.println(id);
		if (id!= null){
			usu = usuarioRepository.findOne(id);
		    List<Long> lstUsuario = new ArrayList<>(); 
		    lstUsuario=usuarioAsignadoRepository.loginUsuarioAsignado(usu);
		    auxIdTipo.setIdUsuario(id);
		    
		    if (lstUsuario.size()!=0)
		    	auxIdTipo.setTipoUsuario((long)1);	    	
		    else
		    	auxIdTipo.setTipoUsuario((long)2);
		    
		    System.out.println(auxIdTipo);
		   
		}
		else{
			auxIdTipo.setIdUsuario(null);
			auxIdTipo.setTipoUsuario(null);
		}
			
		
		
	    return auxIdTipo;
	}
	
	/**
	 * retorna la lista de usuarios sin relaciones
	 * @return
	 */
	@RequestMapping(value = "/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public List<Usuario> getUsuarios() {
		
		List<Usuario> retorno = new ArrayList<Usuario>();
		List<Usuario> lista = usuarioRepository.findAll();
		for(Usuario usuario : lista) {
			Usuario usuarioAux = new Usuario();
			usuarioAux.setIdusuario(usuario.getIdusuario());
			//.... asi con el resto de propiedades
			retorno.add(usuarioAux);
		}
		return retorno;
	}
	
	
	/**
	 * retorna el usuario que viene como parametro
	 * @return
	 */
	@RequestMapping(value = "/buscaPorNombre/{nombreUsuario}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public Usuario getUsuarioPorNombre(@PathVariable String nombreUsuario) {
		
		List<Usuario> lista = usuarioRepository.usuariosConCriterio(nombreUsuario);
		if (lista != null && lista.size() > 0) {
			return lista.get(0);
		}
		
		return null;
	}

	/**
	 * retorna el usuario que viene como parametro
	 * @return
	 */
	@RequestMapping(value = "/buscaPorApellido/{apellido}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public List<Usuario> getUsuarioPorApellido(@PathVariable String apellido) {
		return usuarioRepository.usuariosPorApellido(apellido);
	}
	
	/**
     * Borra una persona por ID
     * @param id
     */
    @RequestMapping(value = "/eliminaporId/{id}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsuario(@PathVariable("id") final Long id) {
        Usuario usuario = usuarioRepository.findOne(id);
        if ( usuario == null) {
        	throw new RuntimeException("Persona no encontrada");
        }
        usuario.setUsuUEstado("E");
        usuarioRepository.save(usuario);
    }
    /*
     * lista de tutoreados por tutor
     */
    @RequestMapping(value = "/udt/{idusuario}", 
            method = RequestMethod.GET, 
            headers="Accept=application/json"
            ) 
    public List<Usuario> getUsuariosDelTutor(@PathVariable Long idusuario){
        Usuario usuariotutor= new Usuario();
        UsuarioAsignado usuarioasignado=new UsuarioAsignado();
        
        usuariotutor=usuarioRepository.findOne(idusuario);
        ArrayList<Usuario> milista = new ArrayList<Usuario>();
        
        for(int i=0; i<usuariotutor.getUsuarioAsignados1().size();i++){
        
            Long id=usuariotutor.getUsuarioAsignados1().get(i).getIdusuarioAsignado();
            
            usuarioasignado=usuarioAsignadoRepository.findOne(id);
            milista.add(usuarioRepository.findOne(usuarioasignado.getUsuario2().getIdusuario()));
           // milista.add(usuarioasignado.getUsuario2());
            System.out.println("imprime lista : "+ milista.get(i).getUsuUNombres());  
        }
           
        return milista;
    }


    
    /**
     * Actualiza una persona. Se invoca al Web Service con el objeto en el cuerpo y el ID en el 
     * parametro.
     * @param id
     * @param resource
     */
   
    /*
    @RequestMapping(value = "updateporID/{id}", method = RequestMethod.GET, 
	        headers="Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public void updateporId(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
    	WsUsuario wsusuario ;
    	Preconditions.checkNotNull(usuario);
    	usuario.setIdusuario(null);
    	usuario.setUsuUNombres("Denny");
        if (usuarioRepository.findOne(id) == null) {
        	throw new RuntimeException("Persona no encontrada");
        }
        usuarioRepository.save(usuario);
    }
	*/
}
