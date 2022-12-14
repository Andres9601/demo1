package com.project.ChelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ChelpaTex.DTO.RegistroDTO;
import com.project.ChelpaTex.DTO.UsuarioDTO;
import com.project.ChelpaTex.Entity.Usuario;
import com.project.ChelpaTex.Repository.ManejadorUsuario;
import com.project.ChelpaTex.Service.ServicioUsuario;



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




	@Override
	public UsuarioDTO crear(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public RegistroDTO registrarUsuario(RegistroDTO registroDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
