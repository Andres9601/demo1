package com.example.demo.Entity;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String ENTIDAD_USUARIO_ID_USUARIO = "idUsuario";
	public static final String ENTIDAD_USUARIO_EMAIL = "email";
	public static final String ENTIDAD_USUARIO_NOMBRE= "nombre";
	public static final String ENTIDAD_USUARIO_TELEFONO= "telefono";
	public static final String ENTIDAD_USUARIO_ACTIVO= "activo";
	private static final String[] ATRIBUTOS_ENTIDAD_USUARIO = { ENTIDAD_USUARIO_ID_USUARIO, ENTIDAD_USUARIO_EMAIL,ENTIDAD_USUARIO_NOMBRE, ENTIDAD_USUARIO_TELEFONO,
			ENTIDAD_USUARIO_ACTIVO };
	
	

	@Id
	@Column(name = "id_usuario")
	private String idUsuario;

	@Column(name = "email")
	private String email;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "telefono")
	private Long telefono;

	@Column(name = "activo")
	private Boolean activo;
	
	/*@ManyToOne(optional = false)
	@JoinColumn(name= "id_rol")
	private UsuarioRol idRol;
	*/

	
	
	
	public Usuario(String idUsuario, String email, String nombre, Long telefono, Boolean activo) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
		this.activo = activo;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(activo, email, idUsuario, nombre, telefono);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(activo, other.activo) && Objects.equals(email, other.email)
				&& Objects.equals(idUsuario, other.idUsuario) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}



	public String getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Long getTelefono() {
		return telefono;
	}



	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}



	public Boolean getActivo() {
		return activo;
	}



	public void setActivo(Boolean activo) {
		this.activo = activo;
	}



	public Usuario() {
		super();
	}



	public static boolean contieneAtributo(String atributo) {
	boolean contiene = false;
	for (final String atr : ATRIBUTOS_ENTIDAD_USUARIO) {
		if (atr.equals(atributo)) {
			contiene = true;
		}
	}

	return contiene;
	}


	public static String[] getAtributosEntidadUsuario() {
	return ATRIBUTOS_ENTIDAD_USUARIO;
	}
	

}
