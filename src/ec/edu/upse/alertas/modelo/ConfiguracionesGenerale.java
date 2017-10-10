package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the configuraciones_generales database table.
 * 
 */
@Entity
@Table(name="configuraciones_generales")
@NamedQuery(name="ConfiguracionesGenerale.findAll", query="SELECT c FROM ConfiguracionesGenerale c")
public class ConfiguracionesGenerale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idconfiguraciones_generales")
	private int idconfiguracionesGenerales;

	@Column(name="ad_conf_dias_almacenamiento")
	private int adConfDiasAlmacenamiento;

	@Column(name="ad_conf_estadi")
	private String adConfEstadi;

	@Column(name="ad_conf_linkapp")
	private String adConfLinkapp;

	@Column(name="ad_conf_tiempo_sms")
	private int adConfTiempoSms;

	//bi-directional many-to-one association to Modulo
	@OneToMany(mappedBy="configuracionesGenerale")
	private List<Modulo> modulos;

	public ConfiguracionesGenerale() {
	}

	public int getIdconfiguracionesGenerales() {
		return this.idconfiguracionesGenerales;
	}

	public void setIdconfiguracionesGenerales(int idconfiguracionesGenerales) {
		this.idconfiguracionesGenerales = idconfiguracionesGenerales;
	}

	public int getAdConfDiasAlmacenamiento() {
		return this.adConfDiasAlmacenamiento;
	}

	public void setAdConfDiasAlmacenamiento(int adConfDiasAlmacenamiento) {
		this.adConfDiasAlmacenamiento = adConfDiasAlmacenamiento;
	}

	public String getAdConfEstadi() {
		return this.adConfEstadi;
	}

	public void setAdConfEstadi(String adConfEstadi) {
		this.adConfEstadi = adConfEstadi;
	}

	public String getAdConfLinkapp() {
		return this.adConfLinkapp;
	}

	public void setAdConfLinkapp(String adConfLinkapp) {
		this.adConfLinkapp = adConfLinkapp;
	}

	public int getAdConfTiempoSms() {
		return this.adConfTiempoSms;
	}

	public void setAdConfTiempoSms(int adConfTiempoSms) {
		this.adConfTiempoSms = adConfTiempoSms;
	}

	public List<Modulo> getModulos() {
		return this.modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public Modulo addModulo(Modulo modulo) {
		getModulos().add(modulo);
		modulo.setConfiguracionesGenerale(this);

		return modulo;
	}

	public Modulo removeModulo(Modulo modulo) {
		getModulos().remove(modulo);
		modulo.setConfiguracionesGenerale(null);

		return modulo;
	}

}