package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the atencion_alerta database table.
 * 
 */
@Entity
@Table(name="atencion_alerta")
@NamedQuery(name="AtencionAlerta.findAll", query="SELECT a FROM AtencionAlerta a")
@NoArgsConstructor
public class AtencionAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idatencion_alerta")
	@Getter @Setter private Long idatencionAlerta;

	@Column(name="usu_aten_estado")
	@Getter @Setter private String usuAtenEstado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="usu_aten_fecha_atendida")
	@Getter @Setter private Date usuAtenFechaAtendida;

	@Column(name="usu_aten_observaciones")
	@Getter @Setter private String usuAtenObservaciones;

	//bi-directional many-to-one association to EmisionAlerta
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idemision_alerta")
	@Getter @Setter private EmisionAlerta emisionAlerta;

	//bi-directional many-to-one association to EntidadesEmergencia
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="identidades")
	@Getter @Setter private EntidadesEmergencia entidadesEmergencia;

	 
}