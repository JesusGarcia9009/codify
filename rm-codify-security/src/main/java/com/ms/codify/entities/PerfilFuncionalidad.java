/**
 * 
 */
package com.ms.codify.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * Clase Entidad perfil_funcionalidad, contiene la asoiacion entre perfil y funcionalidad con los permisos asociados
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Entity
@Table(name = "perfil_funcionalidad")
public class PerfilFuncionalidad implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil_funcionalidad", nullable = false)
    private Long idUsuarioPerfil;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean lectura;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean escritura;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil", nullable = false)
    private Perfil perfil;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionalidad", nullable = false)
    private Funcionalidad funcionalidad;

	public PerfilFuncionalidad(Long idUsuarioPerfil, boolean lectura, boolean escritura, Perfil perfil,
			Funcionalidad funcionalidad) {
		super();
		this.idUsuarioPerfil = idUsuarioPerfil;
		this.lectura = lectura;
		this.escritura = escritura;
		this.perfil = perfil;
		this.funcionalidad = funcionalidad;
	}

	public PerfilFuncionalidad() {
		super();
	}

	public Long getIdUsuarioPerfil() {
		return idUsuarioPerfil;
	}

	public void setIdUsuarioPerfil(Long idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}

	public boolean isLectura() {
		return lectura;
	}

	public void setLectura(boolean lectura) {
		this.lectura = lectura;
	}

	public boolean isEscritura() {
		return escritura;
	}

	public void setEscritura(boolean escritura) {
		this.escritura = escritura;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Funcionalidad getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	@Override
	public String toString() {
		return "PerfilFuncionalidad [idUsuarioPerfil=" + idUsuarioPerfil + ", lectura=" + lectura + ", escritura="
				+ escritura + ", perfil=" + perfil + ", funcionalidad=" + funcionalidad + "]";
	}
    
    

}
