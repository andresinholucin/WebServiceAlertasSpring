package ec.edu.upse.alertas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.Usuario;

/**
 * Esta clase reemplaza a lo que denominabamos DAO
 * @author gitwyn_pc
 *
 */
/*
 * Esta anotacion indica que este es un epositorio de informacion (Lugar donde se almacena informacion) para Spring
 * Cuando la clase hereda de JpaRepository automaticamente cera metodos para manejo de persistencia que los hereda de JpaRepository
 * Como parametros de JpaRepository van la clase que va a gestionar (clase del modelo) y el tipo de datos del ID.
 */
@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * Este es el metodo personalizado. 
	 * La consulta nombrada se debe llamar como se llama el metodo
	 * @param nombreUsuario
	 * @return
	 */
	public List<Usuario> usuariosConCriterio(String nombreUsuario);
	
	//public List<Usuario> usuariosConCriterio1(String nombreUsuario);
	
	
	
	@Query("SELECT u FROM Usuario u WHERE u.usuUApellidos = :apellido")
	public List<Usuario> usuariosPorApellido(@Param("apellido") String apellido);
	
	@Query("SELECT u.idusuario FROM Usuario u WHERE u.usuUUsuario = :usuario and u.usuUClave =:clave")
	public Long loginUsuario(@Param("usuario") String usuario,@Param("clave") String clave);
	// Asi voy adicionando mas metodos que necesite.	
	//void update(Usuario usuario);
	@Query("SELECT u.usuUCedula FROM Usuario u WHERE u.usuUCedula = :cedula")
	public List<String> validacedula(@Param("cedula") String cedula);
}
