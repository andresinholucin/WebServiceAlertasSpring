package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the tiempo_sensado database table.
 * 
 */
@Entity
@Table(name="tiempo_sensado")
@NoArgsConstructor
@NamedQuery(name="TiempoSensado.findAll", query="SELECT t FROM TiempoSensado t")
public class TiempoSensado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtiempo_sensado")
	@Getter @Setter private Long idtiempoSensado;

	@Column(name="usu_tiempo_descripcion")
	@Getter @Setter private int usuTiempoDescripcion;

	@Column(name="usu_tiempo_estado")
	@Getter @Setter private String usuTiempoEstado;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tiempoSensado")
	@JsonIgnore
	@Getter @Setter private List<Usuario> usuarios;

}