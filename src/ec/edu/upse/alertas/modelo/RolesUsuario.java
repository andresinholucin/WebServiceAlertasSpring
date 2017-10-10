package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles_usuario database table.
 * 
 */
@Entity
@Table(name="roles_usuario")
@NamedQuery(name="RolesUsuario.findAll", query="SELECT r FROM RolesUsuario r")
public class RolesUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idroles_usuario")
	private int idrolesUsuario;

	@Column(name="ad_rol_usu_estado")
	private String adRolUsuEstado;

	@Column(name="ad_rol_usu_observaciones")
	private String adRolUsuObservaciones;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idroles")
	private Role role;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public RolesUsuario() {
	}

	public int getIdrolesUsuario() {
		return this.idrolesUsuario;
	}

	public void setIdrolesUsuario(int idrolesUsuario) {
		this.idrolesUsuario = idrolesUsuario;
	}

	public String getAdRolUsuEstado() {
		return this.adRolUsuEstado;
	}

	public void setAdRolUsuEstado(String adRolUsuEstado) {
		this.adRolUsuEstado = adRolUsuEstado;
	}

	public String getAdRolUsuObservaciones() {
		return this.adRolUsuObservaciones;
	}

	public void setAdRolUsuObservaciones(String adRolUsuObservaciones) {
		this.adRolUsuObservaciones = adRolUsuObservaciones;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}