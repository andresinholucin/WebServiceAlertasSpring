package ec.edu.upse.alertas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.EmisionAlerta;
import ec.edu.upse.alertas.modelo.Usuario;

@Repository 
public interface AlertaRepository extends JpaRepository<EmisionAlerta, Long>{
	
	//@Query("SELECT e.idusuario FROM EmisionAlerta e WHERE u.usuUNombres = :nombre")
	//public Integer idusuarioPorNombre(@Param("nombre") String nombre);
	
	//@Query("SELECT e FROM EmisionAlerta e WHERE e.usuUApellidos = :apellido")
	@Query("SELECT e FROM EmisionAlerta e WHERE e.usuAlerPais = :pais")
	public List<EmisionAlerta> emisionAlertaPorPais(@Param("pais") String pais);

	@Query("SELECT e FROM EmisionAlerta e WHERE e.usuario = :usuario")
	public List<EmisionAlerta> emisionAlertaPorUsuario(@Param("usuario") Usuario usuario);

}
