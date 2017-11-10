package ec.edu.upse.alertas.modelo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.UbicacionUsuario;
import ec.edu.upse.alertas.modelo.Usuario;;
@Repository 
public interface UbicacionUsuarioRepository  extends JpaRepository<UbicacionUsuario, Long>{
	
	//@Query("SELECT u.idubicacion FROM UbicacionUsuario u WHERE u.idubicacion =: usuario")
	@Query("SELECT MAX(u.idubicacion),u.usuUbiLatitud,u.usuUbiLongitud FROM UbicacionUsuario u WHERE u.usuario = :usuario")
	public List<UbicacionUsuario> UltimaUbicacion (@Param("usuario") Usuario usuario);
	
	
}
