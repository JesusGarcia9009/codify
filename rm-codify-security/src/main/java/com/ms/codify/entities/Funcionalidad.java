/**
 * 
 */
package com.ms.codify.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase Entidad Funcionalidades, contiene todos los datos referentes a las funcionalidades del sistema
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Entity
@Table(name = "funcionalidad")
public class Funcionalidad implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionalidad", nullable = false)
    private Long idFuncionalidad;
 
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    
    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;
    
    @OneToMany(mappedBy = "funcionalidad",cascade = CascadeType.ALL)
    private List<PerfilFuncionalidad> perfilFuncionalidadList = new ArrayList<>();

	public Funcionalidad(Long idFuncionalidad, String nombre, String descripcion,
			List<PerfilFuncionalidad> perfilFuncionalidadList) {
		super();
		this.idFuncionalidad = idFuncionalidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.perfilFuncionalidadList = perfilFuncionalidadList;
	}

	public Funcionalidad() {
		super();
	}

	public Long getIdFuncionalidad() {
		return idFuncionalidad;
	}

	public void setIdFuncionalidad(Long idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PerfilFuncionalidad> getPerfilFuncionalidadList() {
		return perfilFuncionalidadList;
	}

	public void setPerfilFuncionalidadList(List<PerfilFuncionalidad> perfilFuncionalidadList) {
		this.perfilFuncionalidadList = perfilFuncionalidadList;
	}
    
    
}
