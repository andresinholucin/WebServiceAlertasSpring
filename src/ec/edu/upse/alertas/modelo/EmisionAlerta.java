package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the emision_alerta database table.
 * 
 */
@Entity
@Table(name="emision_alerta")
@NamedQuery(name="EmisionAlerta.findAll", query="SELECT e FROM EmisionAlerta e")
public class EmisionAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idemision_alerta")
	private int idemisionAlerta;

	@Column(name="usu_aler_ciudad")
	private String usuAlerCiudad;

	@Column(name="usu_aler_codigopais")
	private String usuAlerCodigopais;

	@Column(name="usu_aler_estado")
	private String usuAlerEstado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="usu_aler_fecha")
	private Date usuAlerFecha;

	@Column(name="usu_aler_latitud")
	private String usuAlerLatitud;

	@Column(name="usu_aler_longitud")
	private String usuAlerLongitud;

	@Column(name="usu_aler_pais")
	private String usuAlerPais;

	@Column(name="usu_aler_provincia")
	private String usuAlerProvincia;

	@Column(name="usu_aler_viapublica")
	private String usuAlerViapublica;

	//bi-directional many-to-one association to AtencionAlerta
	@OneToMany(mappedBy="emisionAlerta")
	private List<AtencionAlerta> atencionAlertas;

	//bi-directional many-to-one association to TipoAlerta
	@ManyToOne
	@JoinColumn(name="idtipo_alerta")
	private TipoAlerta tipoAlerta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public EmisionAlerta() {
	}

	public int getIdemisionAlerta() {
		return this.idemisionAlerta;
	}

	public void setIdemisionAlerta(int idemisionAlerta) {
		this.idemisionAlerta = idemisionAlerta;
	}

	public String getUsuAlerCiudad() {
		return this.usuAlerCiudad;
	}

	public void setUsuAlerCiudad(String usuAlerCiudad) {
		this.usuAlerCiudad = usuAlerCiudad;
	}

	public String getUsuAlerCodigopais() {
		return this.usuAlerCodigopais;
	}

	public void setUsuAlerCodigopais(String usuAlerCodigopais) {
		this.usuAlerCodigopais = usuAlerCodigopais;
	}

	public String getUsuAlerEstado() {
		return this.usuAlerEstado;
	}

	public void setUsuAlerEstado(String usuAlerEstado) {
		this.usuAlerEstado = usuAlerEstado;
	}

	public Date getUsuAlerFecha() {
		return this.usuAlerFecha;
	}

	public void setUsuAlerFecha(Date usuAlerFecha) {
		this.usuAlerFecha = usuAlerFecha;
	}

	public String getUsuAlerLatitud() {
		return this.usuAlerLatitud;
	}

	public void setUsuAlerLatitud(String usuAlerLatitud) {
		this.usuAlerLatitud = usuAlerLatitud;
	}

	public String getUsuAlerLongitud() {
		return this.usuAlerLongitud;
	}

	public void setUsuAlerLongitud(String usuAlerLongitud) {
		this.usuAlerLongitud = usuAlerLongitud;
	}

	public String getUsuAlerPais() {
		return this.usuAlerPais;
	}

	public void setUsuAlerPais(String usuAlerPais) {
		this.usuAlerPais = usuAlerPais;
	}

	public String getUsuAlerProvincia() {
		return this.usuAlerProvincia;
	}

	public void setUsuAlerProvincia(String usuAlerProvincia) {
		this.usuAlerProvincia = usuAlerProvincia;
	}

	public String getUsuAlerViapublica() {
		return this.usuAlerViapublica;
	}

	public void setUsuAlerViapublica(String usuAlerViapublica) {
		this.usuAlerViapublica = usuAlerViapublica;
	}

	public List<AtencionAlerta> getAtencionAlertas() {
		return this.atencionAlertas;
	}

	public void setAtencionAlertas(List<AtencionAlerta> atencionAlertas) {
		this.atencionAlertas = atencionAlertas;
	}

	public AtencionAlerta addAtencionAlerta(AtencionAlerta atencionAlerta) {
		getAtencionAlertas().add(atencionAlerta);
		atencionAlerta.setEmisionAlerta(this);

		return atencionAlerta;
	}

	public AtencionAlerta removeAtencionAlerta(AtencionAlerta atencionAlerta) {
		getAtencionAlertas().remove(atencionAlerta);
		atencionAlerta.setEmisionAlerta(null);

		return atencionAlerta;
	}

	public TipoAlerta getTipoAlerta() {
		return this.tipoAlerta;
	}

	public void setTipoAlerta(TipoAlerta tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}