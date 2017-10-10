package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the opciones database table.
 * 
 */
@Entity
@Table(name="opciones")
@NamedQuery(name="Opcione.findAll", query="SELECT o FROM Opcione o")
public class Opcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idopciones;

	@Column(name="ad_opc_descripcion")
	private String adOpcDescripcion;

	@Column(name="ad_opc_estado")
	private String adOpcEstado;

	@Column(name="ad_opc_observaciones")
	private String adOpcObservaciones;

	//bi-directional many-to-one association to Modulo
	@ManyToOne
	@JoinColumn(name="idmodulos")
	private Modulo modulo;

	//bi-directional many-to-one association to OpcionesRole
	@OneToMany(mappedBy="opcione")
	private List<OpcionesRole> opcionesRoles;

	public Opcione() {
	}

	public int getIdopciones() {
		return this.idopciones;
	}

	public void setIdopciones(int idopciones) {
		this.idopciones = idopciones;
	}

	public String getAdOpcDescripcion() {
		return this.adOpcDescripcion;
	}

	public void setAdOpcDescripcion(String adOpcDescripcion) {
		this.adOpcDescripcion = adOpcDescripcion;
	}

	public String getAdOpcEstado() {
		return this.adOpcEstado;
	}

	public void setAdOpcEstado(String adOpcEstado) {
		this.adOpcEstado = adOpcEstado;
	}

	public String getAdOpcObservaciones() {
		return this.adOpcObservaciones;
	}

	public void setAdOpcObservaciones(String adOpcObservaciones) {
		this.adOpcObservaciones = adOpcObservaciones;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<OpcionesRole> getOpcionesRoles() {
		return this.opcionesRoles;
	}

	public void setOpcionesRoles(List<OpcionesRole> opcionesRoles) {
		this.opcionesRoles = opcionesRoles;
	}

	public OpcionesRole addOpcionesRole(OpcionesRole opcionesRole) {
		getOpcionesRoles().add(opcionesRole);
		opcionesRole.setOpcione(this);

		return opcionesRole;
	}

	public OpcionesRole removeOpcionesRole(OpcionesRole opcionesRole) {
		getOpcionesRoles().remove(opcionesRole);
		opcionesRole.setOpcione(null);

		return opcionesRole;
	}

}