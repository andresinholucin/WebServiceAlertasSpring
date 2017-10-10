package ec.edu.upse.alertas.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.UsuarioAsignado;

@Repository
public interface UsuarioAsignadoRepository extends JpaRepository<UsuarioAsignado, Long>{

	/*
	 * 
	 
	@Query("SELECT ua FROM UsuarioAsignado ua INNER JOIN Usuario u "
			+ " WHERE ua.usuario1.idusuario = :idusuario")
	public List<Usuario> usuariosDelTutor(@Param("idusuario") Long idusuario);
	*/
}
