package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the entidades_emergencia database table.
 * 
 */
@Entity
@Table(name="entidades_emergencia")
@NamedQuery(name="EntidadesEmergencia.findAll", query="SELECT e FROM EntidadesEmergencia e")
public class EntidadesEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identidades_emergencia")
	private int identidadesEmergencia;

	@Column(name="usu_enti_correo")
	private String usuEntiCorreo;

	@Column(name="usu_enti_descripcion")
	private String usuEntiDescripcion;

	@Column(name="usu_enti_direccion")
	private String usuEntiDireccion;

	@Column(name="usu_enti_estado")
	private String usuEntiEstado;

	@Column(name="usu_enti_telefono")
	private String usuEntiTelefono;

	//bi-directional many-to-one association to AtencionAlerta
	@OneToMany(mappedBy="entidadesEmergencia")
	private List<AtencionAlerta> atencionAlertas;

	public EntidadesEmergencia() {
	}

	public int getIdentidadesEmergencia() {
		return this.identidadesEmergencia;
	}

	public void setIdentidadesEmergencia(int identidadesEmergencia) {
		this.identidadesEmergencia = identidadesEmergencia;
	}

	public String getUsuEntiCorreo() {
		return this.usuEntiCorreo;
	}

	public void setUsuEntiCorreo(String usuEntiCorreo) {
		this.usuEntiCorreo = usuEntiCorreo;
	}

	public String getUsuEntiDescripcion() {
		return this.usuEntiDescripcion;
	}

	public void setUsuEntiDescripcion(String usuEntiDescripcion) {
		this.usuEntiDescripcion = usuEntiDescripcion;
	}

	public String getUsuEntiDireccion() {
		return this.usuEntiDireccion;
	}

	public void setUsuEntiDireccion(String usuEntiDireccion) {
		this.usuEntiDireccion = usuEntiDireccion;
	}

	public String getUsuEntiEstado() {
		return this.usuEntiEstado;
	}

	public void setUsuEntiEstado(String usuEntiEstado) {
		this.usuEntiEstado = usuEntiEstado;
	}

	public String getUsuEntiTelefono() {
		return this.usuEntiTelefono;
	}

	public void setUsuEntiTelefono(String usuEntiTelefono) {
		this.usuEntiTelefono = usuEntiTelefono;
	}

	public List<AtencionAlerta> getAtencionAlertas() {
		return this.atencionAlertas;
	}

	public void setAtencionAlertas(List<AtencionAlerta> atencionAlertas) {
		this.atencionAlertas = atencionAlertas;
	}

	public AtencionAlerta addAtencionAlerta(AtencionAlerta atencionAlerta) {
		getAtencionAlertas().add(atencionAlerta);
		atencionAlerta.setEntidadesEmergencia(this);

		return atencionAlerta;
	}

	public AtencionAlerta removeAtencionAlerta(AtencionAlerta atencionAlerta) {
		getAtencionAlertas().remove(atencionAlerta);
		atencionAlerta.setEntidadesEmergencia(null);

		return atencionAlerta;
	}

}