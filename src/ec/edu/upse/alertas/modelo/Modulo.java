package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modulos database table.
 * 
 */
@Entity
@Table(name="modulos")
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idModulos;

	@Column(name="ad_mod_descripcion")
	private String adModDescripcion;

	@Column(name="ad_mod_estado")
	private String adModEstado;

	@Column(name="ad_mod_observaciones")
	private String adModObservaciones;

	//bi-directional many-to-one association to ConfiguracionesGenerale
	@ManyToOne
	@JoinColumn(name="idconfiguraciones_generales")
	private ConfiguracionesGenerale configuracionesGenerale;

	//bi-directional many-to-one association to Opcione
	@OneToMany(mappedBy="modulo")
	private List<Opcione> opciones;

	public Modulo() {
	}

	public int getIdModulos() {
		return this.idModulos;
	}

	public void setIdModulos(int idModulos) {
		this.idModulos = idModulos;
	}

	public String getAdModDescripcion() {
		return this.adModDescripcion;
	}

	public void setAdModDescripcion(String adModDescripcion) {
		this.adModDescripcion = adModDescripcion;
	}

	public String getAdModEstado() {
		return this.adModEstado;
	}

	public void setAdModEstado(String adModEstado) {
		this.adModEstado = adModEstado;
	}

	public String getAdModObservaciones() {
		return this.adModObservaciones;
	}

	public void setAdModObservaciones(String adModObservaciones) {
		this.adModObservaciones = adModObservaciones;
	}

	public ConfiguracionesGenerale getConfiguracionesGenerale() {
		return this.configuracionesGenerale;
	}

	public void setConfiguracionesGenerale(ConfiguracionesGenerale configuracionesGenerale) {
		this.configuracionesGenerale = configuracionesGenerale;
	}

	public List<Opcione> getOpciones() {
		return this.opciones;
	}

	public void setOpciones(List<Opcione> opciones) {
		this.opciones = opciones;
	}

	public Opcione addOpcione(Opcione opcione) {
		getOpciones().add(opcione);
		opcione.setModulo(this);

		return opcione;
	}

	public Opcione removeOpcione(Opcione opcione) {
		getOpciones().remove(opcione);
		opcione.setModulo(null);

		return opcione;
	}

}