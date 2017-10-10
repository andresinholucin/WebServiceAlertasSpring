package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the ubicacion_usuario database table.
 * 
 */
@Entity
@Table(name="ubicacion_usuario")
@NoArgsConstructor
@NamedQuery(name="UbicacionUsuario.findAll", query="SELECT u FROM UbicacionUsuario u")
public class UbicacionUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private int idubicacion;

	@Column(name="usu_ubi_ciudad")
	@Getter @Setter private String usuUbiCiudad;

	@Column(name="usu_ubi_codigopais")
	@Getter @Setter private String usuUbiCodigopais;

	@Column(name="usu_ubi_estado")
	@Getter @Setter private String usuUbiEstado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="usu_ubi_hora_fin")
	@Getter @Setter private Date usuUbiHoraFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="usu_ubi_hora_inicio")
	@Getter @Setter private Date usuUbiHoraInicio;

	@Column(name="usu_ubi_latitud")
	@Getter @Setter private String usuUbiLatitud;

	@Column(name="usu_ubi_longitud")
	@Getter @Setter private String usuUbiLongitud;

	@Column(name="usu_ubi_pais")
	@Getter @Setter private String usuUbiPais;

	@Column(name="usu_ubi_provincia")
	@Getter @Setter private String usuUbiProvincia;

	@Column(name="usu_ubi_viapublica")
	@Getter @Setter private String usuUbiViapublica;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	@Getter @Setter private Usuario usuario;

	
}