package com.project.ChelpaTex.DTO;

import java.io.Serializable;

import com.project.ChelpaTex.Entity.UsuarioRolPK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioRolDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioRolPK usuarioRolPK;
	
	private Boolean activo;
	

}
