package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the tipo_discapacidad database table.
 * 
 */
@Entity
@Table(name="tipo_discapacidad")
@NamedQuery(name="TipoDiscapacidad.findAll", query="SELECT t FROM TipoDiscapacidad t")
@NoArgsConstructor
public class TipoDiscapacidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtipo_discapacidad")
	@Getter @Setter private Long idtipoDiscapacidad;

	@Column(name="usu_tipo_descripcion")
	@Getter @Setter private String usuTipoDescripcion;

	@Column(name="usu_tipo_estado")
	@Getter @Setter private String usuTipoEstado;

	@Column(name="usu_tipo_observaciones")
	@Getter @Setter private String usuTipoObservaciones;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoDiscapacidad")
	@JsonIgnore
	@Getter @Setter private List<Usuario> usuarios;

	
}