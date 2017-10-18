package ec.edu.upse.alertas.ws;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import ec.edu.upse.alertas.modelo.PerimetroSensado;
import ec.edu.upse.alertas.modelo.TiempoSensado;
import ec.edu.upse.alertas.modelo.TipoDiscapacidad;
import ec.edu.upse.alertas.modelo.Usuario;
import ec.edu.upse.alertas.modelo.UsuarioAsignado;
import ec.edu.upse.alertas.modelo.repositorios.PerimetroRepository;
import ec.edu.upse.alertas.modelo.repositorios.TiempoSensadoRepository;
import ec.edu.upse.alertas.modelo.repositorios.TipoDiscapacidadRepository;
import ec.edu.upse.alertas.modelo.repositorios.UsuarioAsignadoRepository;
import ec.edu.upse.alertas.modelo.repositorios.UsuarioRepository;


@RestController 
@RequestMapping(value="/usuariotutoreado")
public class WsUsuarioTuroreado {
	@Autowired
	UsuarioRepository usuariorepository;
	@Autowired
	UsuarioAsignadoRepository usuarioAsignadoRepository;
	@Autowired
	TiempoSensadoRepository tiemposensadoRepository;
	@Autowired
	PerimetroRepository perimetroRepository;
	@Autowired
	TipoDiscapacidadRepository tipoDiscapacidadRepository;
	
	/*
	 * Usuario por id
	 */
	@RequestMapping(value = "/{idusuario}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        ) 
	public Usuario getUsuario(@PathVariable Long idusuario){
		System.out.println(idusuario);
		return usuariorepository.findOne(idusuario);
	}
	
	/*
	 * lista de todos los usuarios
	 */
	@RequestMapping(value = "/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        ) 
	public List<Usuario> getUsuario(){
		return usuariorepository.findAll();
	}
	
	
	/*
	 * lista de todos los Perimetros para ser llenado en un combo o lista
	 */
	@RequestMapping(value = "/perimetros/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        ) 
	public List<PerimetroSensado> getPerimetros(){
		return perimetroRepository.findAll();
	}
	
	/*
	 * lista de todos los Tiempos-Sensados para ser llenado en un combo o lista
	 */
	@RequestMapping(value = "/tiempos/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        ) 
	public List<TiempoSensado> getTiempos(){
		return tiemposensadoRepository.findAll();
	}
	
	/*
	 * lista de todos los Tipos de discapacidad para ser llenado en un combo o lista
	 */
	@RequestMapping(value = "/tiposdiscapacidad/", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        ) 
	public List<TipoDiscapacidad> getTipos(){
		return tipoDiscapacidadRepository.findAll();
	}
	
	/*
	 * lista de tutoreados por tutor - udt(usuarios del tutor)
	 */
	@RequestMapping(value = "/udt/{idusuario}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        ) 
	public List<Usuario> getUsuariosDelTutor(@PathVariable Long idusuario){
		Usuario usuariotutor= new Usuario();
		UsuarioAsignado usuarioasignado=new UsuarioAsignado();
		usuariotutor=usuariorepository.findOne(idusuario);
		ArrayList<Usuario> usuariosTutoreados = new ArrayList<Usuario>();
		for(int i=0; i<usuariotutor.getUsuarioAsignados1().size();i++){
			Long id=usuariotutor.getUsuarioAsignados1().get(i).getIdusuarioAsignado();
			System.out.println(id);
			usuarioasignado=usuarioAsignadoRepository.findOne(id);
			usuariosTutoreados.add(usuariorepository.findOne(usuarioasignado.getUsuario2().getIdusuario()));
		}		
		return usuariosTutoreados;
	}
	
	
	
	/*
	 * 10 ultimas ubicaciones del usuario -
	 */
	@RequestMapping(value = "/ultimasubicaciones/{idusuario}", 
	        method = RequestMethod.GET, 
	        headers="Accept=application/json"
	        ) 
	public List<Usuario> getUbicacionUsuario(@PathVariable Long idusuario){
		Usuario usuariotutor= new Usuario();
		UsuarioAsignado usuarioasignado=new UsuarioAsignado();
		usuariotutor=usuariorepository.findOne(idusuario);
		ArrayList<Usuario> usuariosTutoreados = new ArrayList<Usuario>();
		for(int i=0; i<usuariotutor.getUsuarioAsignados1().size();i++){
			Long id=usuariotutor.getUsuarioAsignados1().get(i).getIdusuarioAsignado();
			System.out.println(id);
			usuarioasignado=usuarioAsignadoRepository.findOne(id);
			usuariosTutoreados.add(usuariorepository.findOne(usuarioasignado.getUsuario2().getIdusuario()));
		}		
		return usuariosTutoreados;
	}
	
	/*
	 * grabar Usuario usando metodo post
	 */
	@RequestMapping(value = "/registraUsuarioTutoreado/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrapersona(@RequestBody Usuario usuario, HttpServletResponse response) {
		try {
			
			Preconditions.checkNotNull(usuario);
			System.out.println(usuario);
	        return usuariorepository.save(usuario);
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	
	/*
	 * metodo post para prueba
	 */
	@RequestMapping(value = "/pruebapost/", 
	        method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public Object registrapersonaprueba(@RequestBody String usuario, HttpServletResponse response) {
		try {
			Preconditions.checkNotNull(usuario);
			System.out.println(usuario);
	        return usuario;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	
	
	
}