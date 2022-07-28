package com.thc.curso.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thc.curso.springboot.model.MarcaDTO;
import com.thc.curso.springboot.model.RequestMarcas;
import com.thc.curso.springboot.model.ResponseGeneric;
import com.thc.curso.springboot.service.ICursoSpringService;

@RestController
@RequestMapping("/service")
public class CursoSpringController {

	@Autowired
	ICursoSpringService service;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	//GET --> Obtener
	@GetMapping("/getMarcas")
	@ResponseStatus(HttpStatus.OK)
	public List<MarcaDTO> getMarcas(@RequestHeader("Autorizador") String token){
		System.out.println("URL DE la BD "+url);
		return service.getMarcas(token);
	}

	@GetMapping("/getMarcaxId/{idMarca}")
	public ResponseEntity<MarcaDTO> getMarcaxId(@PathVariable Long idMarca){
		MarcaDTO response = service.getMarcaxId(idMarca);

		if(response == null) {
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	//POST --> Insertar
	@PostMapping("/saveMarca")
	@ResponseStatus(HttpStatus.CREATED)
	public MarcaDTO save(@RequestBody MarcaDTO request) {
		return service.saveMarca(request);
	}

	//POST --> Insertar
	@PostMapping("/saveAllMarcas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseGeneric saveAll(@RequestBody RequestMarcas request) {
		return service.saveAll(request);
	}

	//PUT --> Actualizar
	@PutMapping("/updateMarca")
	@ResponseStatus(HttpStatus.OK)
	public MarcaDTO update(@RequestBody MarcaDTO request) {
		return service.updateMarca(request);
	}

	//DELETE --> Eliminar
	@DeleteMapping("/deleteMarca/{idMarca}")
	public ResponseEntity<String> delete(@PathVariable Long idMarca) {		
		String resp = service.deleteMarca(idMarca);
		if("OK".equalsIgnoreCase(resp)) {
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteMarcas")
	public ResponseEntity<String> deleteMarcas() {		
		String resp = service.deleteMarcas();
		if("OK".equalsIgnoreCase(resp)) {
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}

	//	@DeleteMapping("/deleteMarca/{idMarca}")
	//	public ResponseEntity<String> delete(@PathVariable Long idMarca) {
	//		if(idMarca==1L) {
	//			return new ResponseEntity<>("DATO INVALIDO", HttpStatus.BAD_REQUEST);
	//		}
	//		
	//		if(idMarca>3L) {
	//			return new ResponseEntity<>("NO EXISTE", HttpStatus.NOT_FOUND);
	//		}else {
	//			return new ResponseEntity<>("OK", HttpStatus.NO_CONTENT);
	//		}
	//	}


}
