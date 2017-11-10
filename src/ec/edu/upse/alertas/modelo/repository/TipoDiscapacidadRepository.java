package ec.edu.upse.alertas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.upse.alertas.modelo.TipoDiscapacidad;

@Repository
public interface TipoDiscapacidadRepository extends JpaRepository<TipoDiscapacidad, Long> {

}
