package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_alerta database table.
 * 
 */
@Entity
@Table(name="tipo_alerta")
@NamedQuery(name="TipoAlerta.findAll", query="SELECT t FROM TipoAlerta t")
public class TipoAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtipo_alerta")
	private int idtipoAlerta;

	@Column(name="usu_tipoalerta_descripcion")
	private String usuTipoalertaDescripcion;

	@Column(name="usu_tipoalerta_estado")
	private String usuTipoalertaEstado;

	//bi-directional many-to-one association to EmisionAlerta
	@OneToMany(mappedBy="tipoAlerta")
	private List<EmisionAlerta> emisionAlertas;

	public TipoAlerta() {
	}

	public int getIdtipoAlerta() {
		return this.idtipoAlerta;
	}

	public void setIdtipoAlerta(int idtipoAlerta) {
		this.idtipoAlerta = idtipoAlerta;
	}

	public String getUsuTipoalertaDescripcion() {
		return this.usuTipoalertaDescripcion;
	}

	public void setUsuTipoalertaDescripcion(String usuTipoalertaDescripcion) {
		this.usuTipoalertaDescripcion = usuTipoalertaDescripcion;
	}

	public String getUsuTipoalertaEstado() {
		return this.usuTipoalertaEstado;
	}

	public void setUsuTipoalertaEstado(String usuTipoalertaEstado) {
		this.usuTipoalertaEstado = usuTipoalertaEstado;
	}

	public List<EmisionAlerta> getEmisionAlertas() {
		return this.emisionAlertas;
	}

	public void setEmisionAlertas(List<EmisionAlerta> emisionAlertas) {
		this.emisionAlertas = emisionAlertas;
	}

	public EmisionAlerta addEmisionAlerta(EmisionAlerta emisionAlerta) {
		getEmisionAlertas().add(emisionAlerta);
		emisionAlerta.setTipoAlerta(this);

		return emisionAlerta;
	}

	public EmisionAlerta removeEmisionAlerta(EmisionAlerta emisionAlerta) {
		getEmisionAlertas().remove(emisionAlerta);
		emisionAlerta.setTipoAlerta(null);

		return emisionAlerta;
	}

}