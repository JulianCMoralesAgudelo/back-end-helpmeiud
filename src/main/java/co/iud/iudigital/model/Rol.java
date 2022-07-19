package co.iud.iudigital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

	private static final long serialVersionUID = 7054249435026857198L;
	// id INT NOT NULL AUTO_INCREMENT,
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// nombre VARHCAR(45) NOT NULL,
	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;
	// descripcion TEXT NOT NULL,
	private String descripcion;

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
