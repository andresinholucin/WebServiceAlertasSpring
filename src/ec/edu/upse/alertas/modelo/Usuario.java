package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @NamedQuery permite definir consultas personalizadas utilizando JPQL (una variante de SQL adaptada para JPA).
 * @author gitwyn_pc
 * El parametro: nombreUsuario entra como ?1, si hubiera otro parametro entra como ?2 y asi sucesivamente.
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.usuariosConCriterio", 
            	query="SELECT u FROM Usuario u WHERE u.usuUUsuario = ?1 ")
	}
)
@NoArgsConstructor
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private Long idusuario;

	@Column(name="usu_u_anio")
	@Getter @Setter private String usuUAnio;

	@Column(name="usu_u_apellidos")
	@Getter @Setter private String usuUApellidos;

	@Column(name="usu_u_cedula")
	@Getter @Setter private String usuUCedula;

	@Column(name="usu_u_clave")
	@Getter @Setter private String usuUClave;

	@Column(name="usu_u_correo")
	@Getter @Setter private String usuUCorreo;

	@Column(name="usu_u_dia")
	@Getter @Setter private String usuUDia;

	@Column(name="usu_u_direccion")
	@Getter @Setter private String usuUDireccion;

	@Column(name="usu_u_estado")
	@Getter @Setter private String usuUEstado;

	@Column(name="usu_u_mes")
	@Getter @Setter private String usuUMes;

	@Column(name="usu_u_nombres")
	@Getter @Setter private String usuUNombres;

	@Column(name="usu_u_sms")
	@Getter @Setter private String usuUSms;

	@Column(name="usu_u_telefono")
	@Getter @Setter private String usuUTelefono;

	@Column(name="usu_u_usuario")
	@Getter @Setter private String usuUUsuario;

	//bi-directional many-to-one association to EmisionAlerta
	@OneToMany(mappedBy="usuario")
	@JsonIgnore 
	@Getter @Setter private List<EmisionAlerta> emisionAlertas;

	//bi-directional many-to-one association to Notificacione
	@OneToMany(mappedBy="usuario")
	@JsonIgnore  
	@Getter @Setter private List<Notificacione> notificaciones;

	//bi-directional many-to-one association to RolesUsuario
	@OneToMany(mappedBy="usuario")
	@JsonIgnore                            // Esta anotacion evita que el conversor automatico de Json avance por esta propiedad.
	@Getter @Setter private List<RolesUsuario> rolesUsuarios;

	//bi-directional many-to-one association to UbicacionUsuario
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	@Getter @Setter private List<UbicacionUsuario> ubicacionUsuarios;

	//bi-directional many-to-one association to PerimetroSensado
	@ManyToOne
	@JoinColumn(name="idtiempo_perimetro")
	//@JsonIgnore
	@Getter @Setter private PerimetroSensado perimetroSensado;

	//bi-directional many-to-one association to TiempoSensado
	@ManyToOne
	@JoinColumn(name="idtiempo_sensado")
	//@JsonIgnore
	@Getter @Setter private TiempoSensado tiempoSensado;

	//bi-directional many-to-one association to TipoDiscapacidad
	@ManyToOne
	@JoinColumn(name="idtipo_discapacidad")
	//@JsonIgnore
	@Getter @Setter private TipoDiscapacidad tipoDiscapacidad;

	//bi-directional many-to-one association to UsuarioAsignado
	@OneToMany(mappedBy="usuario1")
	@JsonIgnore
	@Getter @Setter private List<UsuarioAsignado> usuarioAsignados1;

	//bi-directional many-to-one association to UsuarioAsignado
	@OneToMany(mappedBy="usuario2")
    @JsonIgnore
	@Getter @Setter private List<UsuarioAsignado> usuarioAsignados2;

}