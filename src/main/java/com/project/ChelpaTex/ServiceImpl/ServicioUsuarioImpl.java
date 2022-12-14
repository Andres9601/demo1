package com.project.ChelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ChelpaTex.DTO.RegistroDTO;
import com.project.ChelpaTex.DTO.RolDTO;
import com.project.ChelpaTex.DTO.UsuarioDTO;
import com.project.ChelpaTex.DTO.UsuarioRolDTO;
import com.project.ChelpaTex.Entity.Usuario;
import com.project.ChelpaTex.Entity.UsuarioRolPK;
import com.project.ChelpaTex.Repository.ManejadorUsuario;
import com.project.ChelpaTex.Service.ServicioUsuario;
import com.project.ChelpaTex.Service.ServicioUsuarioRol;



@Service
public class ServicioUsuarioImpl implements ServicioUsuario {
	
	private static final Logger logger =  Logger.getLogger(ServicioUsuario.class.getName());
	
	@Autowired
	ManejadorUsuario manejadorUsuario;
	
	@Autowired
	ServicioUsuarioRol servicioUsuarioRol;
		

	

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
		Optional<Usuario> usuarioExiste = manejadorUsuario.findOneByEmail(usuarioDTO.getEmail());
		try {
			if(!usuarioExiste.isPresent()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(usuarioDTO.getIdUsuario());	
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setNombre(usuarioDTO.getNombre());
			usuario.setTelefono(usuarioDTO.getTelefono());
			usuario.setActivo(usuarioDTO.getActivo());
			manejadorUsuario.save(usuario);
		}
		}catch(Exception e){
			logger.info(e.getMessage() + e.getCause());
			return null;
		}
			
		return usuarioDTO;
	}


	@Override
	public RegistroDTO registrarUsuario(RegistroDTO registroDTO) {
		UsuarioDTO usuarioDto = registroDTO.getUsuarioDTO();
		RolDTO rolDto = registroDTO.getRolDTO();
		Optional<Usuario> usuarioExiste = manejadorUsuario.findOneByEmail(usuarioDto.getEmail());
		try {
			if(!usuarioExiste.isPresent()) {
				this.crear(usuarioDto);
				UsuarioRolPK usuRolPk = new UsuarioRolPK();
				usuRolPk.setIdUsuario(usuarioDto.getIdUsuario());
				usuRolPk.setIdRol(rolDto.getIdRol());
				UsuarioRolDTO usuRolDto = new UsuarioRolDTO();
				usuRolDto.setUsuarioRolPK(usuRolPk);
				usuRolDto.setActivo(rolDto.getActivo());
				servicioUsuarioRol.crear(usuRolDto);
				return registroDTO;

			}
		}
			catch(Exception e){
				logger.info(e.getMessage() + e.getCause());
				return null;
			}
				
		return registroDTO;
	}
}
