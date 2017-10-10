package ec.edu.upse.alertas.modelo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.PerimetroSensado;

@Repository
public interface PerimetroRepository extends JpaRepository<PerimetroSensado, Long>{

}
