/**
 * 
 */
package com.ms.codify.entities;

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
 * Clase Entidad Usuario, contiene todos los datos de los usuarios del sistema
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Entity
@Table(name = "tenant")
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tenant", nullable = false)
	public Long idTenant;

	@Column(name = "nombre", length = 50, nullable = false)
	public String nombre;

	@Column(name = "llave", length = 50, nullable = false)
	public String llave;

	@OneToMany(mappedBy = "tenant",cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();


	public Tenant() {
		super();
	}


	public Long getIdTenant() {
		return idTenant;
	}


	public void setIdTenant(Long idTenant) {
		this.idTenant = idTenant;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLlave() {
		return llave;
	}


	public void setLlave(String llave) {
		this.llave = llave;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	

}
