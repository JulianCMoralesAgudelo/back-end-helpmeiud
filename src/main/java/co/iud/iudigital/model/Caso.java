package co.iud.iudigital.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "casos")
public class Caso implements Serializable {

	// id INT NOT NULL AUTO_INCREMENT,
	// PRIMARY KEY(id)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// fecha_hora DATETIME NULL DEFAULT now(),
	@Column(name = "fecha_hora")
	private LocalDate fechaHora;
	
	// latitud FLOAT NULL,
	@Column(name = "latitud")
	private Double latitud;
	
	// longitud FLOAT NULL,
	@Column(name = "longitud")
	private Double longitud;
	
	// altitud FLOAT NULL,
	@Column(name = "altitud")
	private Double altitud;
	// visible TINYINT NULL DEFAULT 1,
	
	@Column(name = "visible")
	private Boolean visible;
	
	// descripcion VARCHAR(200) NULL,	
	private String descripcion;
	
	// url_map TEXT NULL,
	private String url_map;

	// rmi_url TEXT NULL,
	private String rmi_url;

	// usuarios_id INT NOT NULL,
	

	// delitos_id INT NOT NULL,

	// FOREIGN KEY (usuarios_id) REFERENCES usuarios(id),
	// FOREIGN KEY (delitos_id) REFERENCES delitos(id)
}
