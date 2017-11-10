package ec.edu.upse.alertas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ec.edu.upse.alertas.modelo.TipoAlerta;

@Repository 
public interface TipoAlertaRepository extends JpaRepository<TipoAlerta, Long> {

	
	
}
