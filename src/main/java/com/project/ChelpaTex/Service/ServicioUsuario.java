package com.project.ChelpaTex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.ChelpaTex.DTO.RegistroDTO;
import com.project.ChelpaTex.DTO.UsuarioDTO;


@Service
public interface ServicioUsuario {

	@Qualifier("ServicioUsuarioImpl")
	public List<UsuarioDTO> consultar();
	
	@Qualifier("ServicioUsuarioImpl")
	public UsuarioDTO crear(UsuarioDTO usuarioDTO);
	
	@Qualifier("ServicioUsuarioImpl")
	public RegistroDTO registrarUsuario (RegistroDTO registroDTO);
}