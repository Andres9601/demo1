package com.example.demo.Controller;


import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ManejadorUsuario;
import com.example.demo.Service.ServicioUsuario;


@RestController
public class ControladorUsuario {
	
	
	@Autowired
	ManejadorUsuario manejadorUsuario;
	
	@Autowired
	ServicioUsuario servicioUsuario;

	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultar() throws URISyntaxException{
		
		try { 
			return ResponseEntity.ok(servicioUsuario.consultar());
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se puede responder a tu solicitud en este momento "+e);
		}
		
	}
	
	
	@GetMapping(path="/mensaje")
	public String mensaje() {
		return "Hola Azure";
	}
}
