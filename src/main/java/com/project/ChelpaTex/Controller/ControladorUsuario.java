package com.project.ChelpaTex.Controller;


import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ChelpaTex.DTO.RegistroDTO;
import com.project.ChelpaTex.Service.ServicioUsuario;


@RestController
@RequestMapping("/webresources/controller/controladorUsuario")
public class ControladorUsuario {

	@Autowired(required = true)
	ServicioUsuario servicioUsuario;
	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultar() throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioUsuario.consultar());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	
	@PostMapping(path = "/registrarUsuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUserFirebase(@RequestBody RegistroDTO registroDTO )throws Exception {
    	try {
    		return ResponseEntity.ok(servicioUsuario.registrarUsuario(registroDTO));
    	}catch(Exception e){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede registrar el usuario "+ e);
    	}
	}
	
	
	@GetMapping(path="/mensaje")
	public String mensaje() {
		return "Hola Azure";
	}
}
