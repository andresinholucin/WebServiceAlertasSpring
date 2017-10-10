package ec.edu.upse.alertas.ws;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.base.Preconditions;
import com.google.common.net.MediaType;

import ec.edu.upse.alertas.modelo.MetodosGenerales;
import ec.edu.upse.alertas.modelo.Usuario;
import ec.edu.upse.alertas.modelo.repositorios.UsuarioRepository;


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
	
	@RequestMapping(value = "/buscaPorId/{id}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json") 
	public Usuario getUsuario(@PathVariable long id) {
		return usuarioRepository.findOne(id);
	}
	
	/**
	 * retorna la lista de usuarios sin relaciones
	 * @return
	 */
	@RequestMapping(value = "/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json",
	        produces="application/json"
	        ) 
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
	 * Crea un usuario. Se invoca al Web Service sin parametro pero con el objeto
	 * JSON en el cuerpo.
	 * @param resource
	 * @param response
	 * @return
	 */
	
    @RequestMapping(method = RequestMethod.GET,
    		value = "/ingresa/{apellido}",
    		headers="Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Usuario create(@RequestBody Usuario usuario, HttpServletResponse response) {
        Preconditions.checkNotNull(usuario);
        usuarioRepository.save(usuario);
        return usuario;
    }
    
    /**
	 * Ingresar Un Usuario completo
	 */
	
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Usuario IngresaUsuarioCompleto(@RequestBody Usuario usuario, HttpServletResponse response) {
        Preconditions.checkNotNull(usuario);
        usuarioRepository.save(usuario);
        
        
        return usuario;
    }
    
	@RequestMapping(value = "/busca/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        
	        ) 
	public String getcadena(){
		//instanciar usuario por ejemplo
		//llenas
		//conviertes objeto usuario a string formato json
		//y transmitir como cadena
		//String cadena="{\"records\":[{\"Name\":\"1\",\"City\":\"123\",\"Country\":\"A\"}, {\"Name\":\"Ana Trujillo Emparedados y helados\",\"City\":\"México D.F.\",\"Country\":\"Mexico\"}]}";
		//String cadena="{\"\":[{\"Name\":\"1\",\"City\":\"123\",\"Country\":\"A\"}, {\"Name\":\"Ana Trujillo Emparedados y helados\",\"City\":\"México D.F.\",\"Country\":\"Mexico\"}]}";
		String jsonn="[{\"Name\":\"1\",\"City\":\"123\",\"Country\":\"A\"}, {\"Name\":\"Ana Trujillo Emparedados y helados\",\"City\":\"México D.F.\",\"Country\":\"Mexico\"}]";
		
	     MetodosGenerales metodos = new MetodosGenerales();

	    
		jsonn=metodos.ArrayJson(jsonn, "records");
		 System.out.println(jsonn);
		//jsonpObject.
		//System.out.println(jsonpObject);
		//String cadena = "{\"records\":" + jsonn + "}";
		//System.out.println(jsonpObject);
		return jsonn;
	}
	
	
}
