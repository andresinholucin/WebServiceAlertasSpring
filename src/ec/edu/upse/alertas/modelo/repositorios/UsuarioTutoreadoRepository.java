package ec.edu.upse.alertas.modelo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.Usuario;
import ec.edu.upse.alertas.modelo.Notificacione;

@Repository
public interface UsuarioTutoreadoRepository extends JpaRepository<Usuario, Long>{
	
	/*
	 * usuarios del tutor
	
	@Query("SELECT u FROM Usuario u INNER JOIN u.Notificacione")
			//+ " WHERE u.usuario1.idusuario = : idusuario")
	public List<Usuario> usuariosDelTutor();
	
	//@Param("idusuario") Long idusuario  //JOIN u.Notificacione n
	
	@Query("SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
	public List<Usuario> usuarioporid(@Param("idusuario") Long idusuario);
	 */
}



