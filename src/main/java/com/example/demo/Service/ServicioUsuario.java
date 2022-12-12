package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UsuarioDTO;


@Service
public interface ServicioUsuario {

	@Qualifier("ServicioUsuarioImpl")
	public List<UsuarioDTO> consultar();
}
