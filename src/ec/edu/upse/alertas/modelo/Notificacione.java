package ec.edu.upse.alertas.modelo;

import java.io.Serializable;
import java.util.Date;

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
 * The persistent class for the notificaciones database table.
 * 
 */
@Entity
@Table(name="notificaciones")
@NamedQuery(name="Notificacione.findAll", query="SELECT n FROM Notificacione n")
@NoArgsConstructor
public class Notificacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private Long idnotificaciones;

	@Getter @Setter private String descripcion;

	@Getter @Setter private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter private Date fecha;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariox")
	@Getter @Setter private Usuario usuario;

	
}