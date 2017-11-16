package ec.edu.upse.alertas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.Usuario;
import ec.edu.upse.alertas.modelo.UsuarioAsignado;

@Repository
public interface UsuarioAsignadoRepository extends JpaRepository<UsuarioAsignado, Long>{

	/*
	 * 
	 
	@Query("SELECT ua FROM UsuarioAsignado ua INNER JOIN Usuario u "
			+ " WHERE ua.usuario1.idusuario = :idusuario")
	public List<Usuario> usuariosDelTutor(@Param("idusuario") Long idusuario);
	*/
	
	@Query("SELECT u.usuario1 FROM UsuarioAsignado u WHERE u.usuario1 = :usuario AND u.estado='A'")
	public List<Long> loginUsuarioAsignado(@Param("usuario") Usuario usuario);
	
	
}
