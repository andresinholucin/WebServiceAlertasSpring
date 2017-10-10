package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atencion_alerta database table.
 * 
 */
@Entity
@Table(name="atencion_alerta")
@NamedQuery(name="AtencionAlerta.findAll", query="SELECT a FROM AtencionAlerta a")
public class AtencionAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idatencion_alerta")
	private int idatencionAlerta;

	@Column(name="usu_aten_estado")
	private String usuAtenEstado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="usu_aten_fecha_atendida")
	private Date usuAtenFechaAtendida;

	@Column(name="usu_aten_observaciones")
	private String usuAtenObservaciones;

	//bi-directional many-to-one association to EmisionAlerta
	@ManyToOne
	@JoinColumn(name="idemision_alerta")
	private EmisionAlerta emisionAlerta;

	//bi-directional many-to-one association to EntidadesEmergencia
	@ManyToOne
	@JoinColumn(name="identidades")
	private EntidadesEmergencia entidadesEmergencia;

	public AtencionAlerta() {
	}

	public int getIdatencionAlerta() {
		return this.idatencionAlerta;
	}

	public void setIdatencionAlerta(int idatencionAlerta) {
		this.idatencionAlerta = idatencionAlerta;
	}

	public String getUsuAtenEstado() {
		return this.usuAtenEstado;
	}

	public void setUsuAtenEstado(String usuAtenEstado) {
		this.usuAtenEstado = usuAtenEstado;
	}

	public Date getUsuAtenFechaAtendida() {
		return this.usuAtenFechaAtendida;
	}

	public void setUsuAtenFechaAtendida(Date usuAtenFechaAtendida) {
		this.usuAtenFechaAtendida = usuAtenFechaAtendida;
	}

	public String getUsuAtenObservaciones() {
		return this.usuAtenObservaciones;
	}

	public void setUsuAtenObservaciones(String usuAtenObservaciones) {
		this.usuAtenObservaciones = usuAtenObservaciones;
	}

	public EmisionAlerta getEmisionAlerta() {
		return this.emisionAlerta;
	}

	public void setEmisionAlerta(EmisionAlerta emisionAlerta) {
		this.emisionAlerta = emisionAlerta;
	}

	public EntidadesEmergencia getEntidadesEmergencia() {
		return this.entidadesEmergencia;
	}

	public void setEntidadesEmergencia(EntidadesEmergencia entidadesEmergencia) {
		this.entidadesEmergencia = entidadesEmergencia;
	}

}