package ec.edu.upse.alertas.modelo;

import java.io.Serializable;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the usuario_asignado database table.
 * 
 */
@Entity
@Table(name="usuario_asignado")
@NamedQuery(name="UsuarioAsignado.findAll", query="SELECT u FROM UsuarioAsignado u")

@NoArgsConstructor
public class UsuarioAsignado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusuario_asignado")
	@Getter @Setter private Long idusuarioAsignado;

	@Getter @Setter private String estado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idtutor")
	@JsonIgnore
	@Getter @Setter private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	@JsonIgnore
	@Getter @Setter private Usuario usuario2;
}