package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the opciones_roles database table.
 * 
 */
@Entity
@Table(name="opciones_roles")
@NamedQuery(name="OpcionesRole.findAll", query="SELECT o FROM OpcionesRole o")
public class OpcionesRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idopciones_roles")
	private int idopcionesRoles;

	@Column(name="ad_opc_rol_estado")
	private String adOpcRolEstado;

	@Column(name="ad_opc_rol_observaciones")
	private String adOpcRolObservaciones;

	//bi-directional many-to-one association to Opcione
	@ManyToOne
	@JoinColumn(name="idopciones")
	private Opcione opcione;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idroles")
	private Role role;

	public OpcionesRole() {
	}

	public int getIdopcionesRoles() {
		return this.idopcionesRoles;
	}

	public void setIdopcionesRoles(int idopcionesRoles) {
		this.idopcionesRoles = idopcionesRoles;
	}

	public String getAdOpcRolEstado() {
		return this.adOpcRolEstado;
	}

	public void setAdOpcRolEstado(String adOpcRolEstado) {
		this.adOpcRolEstado = adOpcRolEstado;
	}

	public String getAdOpcRolObservaciones() {
		return this.adOpcRolObservaciones;
	}

	public void setAdOpcRolObservaciones(String adOpcRolObservaciones) {
		this.adOpcRolObservaciones = adOpcRolObservaciones;
	}

	public Opcione getOpcione() {
		return this.opcione;
	}

	public void setOpcione(Opcione opcione) {
		this.opcione = opcione;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}