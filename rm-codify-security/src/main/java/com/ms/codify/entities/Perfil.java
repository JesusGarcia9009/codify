/**
 * 
 */
package com.ms.codify.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "perfil")
public class Perfil {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;
 
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    
    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;
    
    @OneToMany(mappedBy = "perfil",cascade = CascadeType.ALL)
    private List<PerfilFuncionalidad> perfilFuncionalidadList = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "perfil")
    private Set<Usuario> usuario = new HashSet<>();
    
	public Perfil() {
		super();
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
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

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public List<PerfilFuncionalidad> getPerfilFuncionalidadList() {
		return perfilFuncionalidadList;
	}

	public void setPerfilFuncionalidadList(List<PerfilFuncionalidad> perfilFuncionalidadList) {
		this.perfilFuncionalidadList = perfilFuncionalidadList;
	}

}
