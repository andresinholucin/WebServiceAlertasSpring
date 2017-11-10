package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;


/**
 * The persistent class for the emision_alerta database table.
 * 
 */
@Entity
@Table(name="emision_alerta")
@NamedQuery(name="EmisionAlerta.findAll", query="SELECT e FROM EmisionAlerta e")
@NoArgsConstructor
public class EmisionAlerta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idemision_alerta")
	@Getter @Setter private Long idemisionAlerta;

	@Column(name="usu_aler_ciudad")
	@Getter @Setter private String usuAlerCiudad;

	@Column(name="usu_aler_codigopais")
	@Getter @Setter private String usuAlerCodigopais;

	@Column(name="usu_aler_estado")
	@Getter @Setter private String usuAlerEstado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="usu_aler_fecha")
	@Getter @Setter private Date usuAlerFecha;

	@Column(name="usu_aler_latitud")
	@Getter @Setter private String usuAlerLatitud;

	@Column(name="usu_aler_longitud")
	@Getter @Setter private String usuAlerLongitud;

	@Column(name="usu_aler_pais")
	@Getter @Setter private String usuAlerPais;

	@Column(name="usu_aler_provincia")
	@Getter @Setter private String usuAlerProvincia;

	@Column(name="usu_aler_viapublica")
	@Getter @Setter private String usuAlerViapublica;

	//bi-directional many-to-one association to AtencionAlerta
	@OneToMany(mappedBy="emisionAlerta")
	@JsonIgnore
	@Getter @Setter private List<AtencionAlerta> atencionAlertas;

	//bi-directional many-to-one association to TipoAlerta
	@ManyToOne
	@JoinColumn(name="idtipo_alerta")
	@JsonIgnore
	@Getter @Setter private TipoAlerta tipoAlerta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	@Getter @Setter private Usuario usuario;
	
}