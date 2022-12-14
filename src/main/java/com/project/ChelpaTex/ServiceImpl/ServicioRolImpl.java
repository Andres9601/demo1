package com.project.ChelpaTex.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ChelpaTex.DTO.RolDTO;
import com.project.ChelpaTex.Entity.Rol;
import com.project.ChelpaTex.Repository.ManejadorRol;
import com.project.ChelpaTex.Service.ServicioRol;



@Service
public class ServicioRolImpl implements ServicioRol{

	@Autowired
	ManejadorRol manejadorRol;
	
	@Override
	public List<RolDTO> consultar() {
		List<Rol> rolesTemp = manejadorRol.findAll();
		List<RolDTO> roles = new ArrayList<RolDTO>();
		for (Rol rol : rolesTemp) {
			RolDTO rolDto = new RolDTO();
			rolDto.setIdRol(rol.getIdRol());
			rolDto.setRol(rol.getRol());
			rolDto.setActivo(rol.getActivo());
			roles.add(rolDto);
		}
	return roles;
	}

}
