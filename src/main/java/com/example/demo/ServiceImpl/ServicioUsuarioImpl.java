package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Entity.Usuario;
import com.example.demo.Repository.ManejadorUsuario;
import com.example.demo.Service.ServicioUsuario;



@Service
public class ServicioUsuarioImpl implements ServicioUsuario {
	
	//private static final Logger logger =  Logger.getLogger(ServicioUsuario.class.getName());
	
	@Autowired
	ManejadorUsuario manejadorUsuario;
		

	

	@Override
	public List<UsuarioDTO> consultar() {
		List<Usuario> usuariosTemp = manejadorUsuario.findAll();
		UsuarioDTO usuarioDto = new UsuarioDTO();
		List<UsuarioDTO> usuarios= new ArrayList<UsuarioDTO>();
		for (Usuario usuarioTemp:usuariosTemp) {
			usuarioDto.setIdUsuario(usuarioTemp.getIdUsuario());
			usuarioDto.setEmail(usuarioTemp.getEmail());
			usuarioDto.setNombre(usuarioTemp.getNombre());
			usuarioDto.setTelefono(usuarioTemp.getTelefono());
			usuarioDto.setActivo(usuarioTemp.getActivo());
			usuarios.add(usuarioDto);
		}
		return usuarios;
	}
}
