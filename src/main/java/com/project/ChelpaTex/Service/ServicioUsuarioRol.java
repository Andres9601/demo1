package com.project.ChelpaTex.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.ChelpaTex.DTO.UsuarioRolDTO;


@Service
public interface ServicioUsuarioRol {
	
	@Qualifier("ServicioUsuarioRolImpl")
	public UsuarioRolDTO crear(UsuarioRolDTO usuarioRolDTO);

}
