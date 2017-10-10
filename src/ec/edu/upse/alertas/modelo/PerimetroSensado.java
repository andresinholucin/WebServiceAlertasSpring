package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the perimetro_sensado database table.
 * 
 */
@Entity
@Table(name="perimetro_sensado")
@NoArgsConstructor
public class PerimetroSensado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idperimetro_sensado")
	@Getter @Setter private Long idperimetroSensado;

	@Column(name="usu_perimetro_descripcion")
	@Getter @Setter private String usuPerimetroDescripcion;

	@Column(name="usu_perimetro_estado")
	@Getter @Setter private String usuPerimetroEstado;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="perimetroSensado")
	@JsonIgnore
	@Getter @Setter private List<Usuario> usuarios;

}