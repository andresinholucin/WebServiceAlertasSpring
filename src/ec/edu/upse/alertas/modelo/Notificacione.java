package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the notificaciones database table.
 * 
 */
@Entity
@Table(name="notificaciones")
@NamedQuery(name="Notificacione.findAll", query="SELECT n FROM Notificacione n")
public class Notificacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idnotificaciones;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariox")
	private Usuario usuario;

	public Notificacione() {
	}

	public int getIdnotificaciones() {
		return this.idnotificaciones;
	}

	public void setIdnotificaciones(int idnotificaciones) {
		this.idnotificaciones = idnotificaciones;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}