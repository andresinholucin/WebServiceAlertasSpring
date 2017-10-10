package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idroles;

	@Column(name="ad_rol_descripcion")
	private String adRolDescripcion;

	@Column(name="ad_rol_estado")
	private String adRolEstado;

	@Column(name="ad_rol_observaciones")
	private String adRolObservaciones;

	//bi-directional many-to-one association to OpcionesRole
	@OneToMany(mappedBy="role")
	private List<OpcionesRole> opcionesRoles;

	//bi-directional many-to-one association to RolesUsuario
	@OneToMany(mappedBy="role")
	private List<RolesUsuario> rolesUsuarios;

	public Role() {
	}

	public int getIdroles() {
		return this.idroles;
	}

	public void setIdroles(int idroles) {
		this.idroles = idroles;
	}

	public String getAdRolDescripcion() {
		return this.adRolDescripcion;
	}

	public void setAdRolDescripcion(String adRolDescripcion) {
		this.adRolDescripcion = adRolDescripcion;
	}

	public String getAdRolEstado() {
		return this.adRolEstado;
	}

	public void setAdRolEstado(String adRolEstado) {
		this.adRolEstado = adRolEstado;
	}

	public String getAdRolObservaciones() {
		return this.adRolObservaciones;
	}

	public void setAdRolObservaciones(String adRolObservaciones) {
		this.adRolObservaciones = adRolObservaciones;
	}

	public List<OpcionesRole> getOpcionesRoles() {
		return this.opcionesRoles;
	}

	public void setOpcionesRoles(List<OpcionesRole> opcionesRoles) {
		this.opcionesRoles = opcionesRoles;
	}

	public OpcionesRole addOpcionesRole(OpcionesRole opcionesRole) {
		getOpcionesRoles().add(opcionesRole);
		opcionesRole.setRole(this);

		return opcionesRole;
	}

	public OpcionesRole removeOpcionesRole(OpcionesRole opcionesRole) {
		getOpcionesRoles().remove(opcionesRole);
		opcionesRole.setRole(null);

		return opcionesRole;
	}

	public List<RolesUsuario> getRolesUsuarios() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios(List<RolesUsuario> rolesUsuarios) {
		this.rolesUsuarios = rolesUsuarios;
	}

	public RolesUsuario addRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().add(rolesUsuario);
		rolesUsuario.setRole(this);

		return rolesUsuario;
	}

	public RolesUsuario removeRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().remove(rolesUsuario);
		rolesUsuario.setRole(null);

		return rolesUsuario;
	}

}