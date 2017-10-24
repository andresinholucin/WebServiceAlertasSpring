package ec.edu.upse.alertas.modelo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.Usuario;


@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> usuariosConCriterio(String nombreUsuario);
	
	public List<Usuario> usuariosConCriterio1(String nombreUsuario);
	
	@Query("SELECT u FROM Usuario u WHERE u.usuUApellidos = :apellido")
	public List<Usuario> usuariosPorApellido(@Param("apellido") String apellido);
	
	
	@Query("SELECT u.usuUCedula FROM Usuario u WHERE u.usuUCedula = :cedula")
	public List<String> validacedula(@Param("cedula") String cedula);
}
