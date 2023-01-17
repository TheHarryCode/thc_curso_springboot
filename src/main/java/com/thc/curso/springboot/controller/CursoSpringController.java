package com.thc.curso.springboot.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thc.curso.springboot.model.MarcaDTO;
import com.thc.curso.springboot.model.RequestMarcas;
import com.thc.curso.springboot.model.ResponseGeneric;
import com.thc.curso.springboot.service.ICursoSpringService;
// CTRL + L
@RestController
@RequestMapping("/service")
public class CursoSpringController {

	//Reorder the modifiers to comply with the Java Language Specification.
	private static final String NAME_USER = "HARRY";
	
	//ALT + ENTER
	
	@Autowired
	ICursoSpringService service;

	@Value("${spring.datasource.url}")
	private String url;

	@PostMapping("/uploadFile")
	@ResponseStatus(HttpStatus.CREATED)
	public MarcaDTO uploadFile(@RequestParam("file") MultipartFile file) {
		return MarcaDTO.builder().idMarca(100L).nombreMarca("You successfully uploaded ").build();
	}

	//GET --> Obtener
	@GetMapping("/getMarcas")
	@ResponseStatus(HttpStatus.OK)
	public List<MarcaDTO> getMarcas(@RequestHeader("Autorizador") String token){		
		return service.getMarcas(token);
	}

	@GetMapping("/getMarcasAll")
	@ResponseStatus(HttpStatus.OK)
	public List<MarcaDTO> getMarcasAll(){

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println("Petición a las "+dtf.format(LocalDateTime.now()));

		return service.getMarcas("");
	}

	@GetMapping("/getMarcaxId/{idMarca}")
	public ResponseEntity<MarcaDTO> getMarcaxId(@PathVariable Long idMarca){
		service.getMarcaxId(idMarca);

		return new ResponseEntity<>(new MarcaDTO(), HttpStatus.OK);
	}

	//POST --> Insertar
	@PostMapping("/saveMarca")
	@ResponseStatus(HttpStatus.CREATED)
	public MarcaDTO save(@RequestBody MarcaDTO request) {
		request.setNombreMarca(NAME_USER);
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

//	DELETE --> Eliminar
	@DeleteMapping("/deleteMarca/{idMarca}")
	public ResponseEntity<String> delete(@PathVariable Long idMarca) {		
		String resp = service.deleteMarca(idMarca);
		if("OK".equalsIgnoreCase(resp)) {
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}

	//CTRL + SHIT + X = PONER EN MAYUSCULA
	//CTRL + SHIT + Y = poner en miniscula

	@DeleteMapping("/deleteMarcas")
	public ResponseEntity<String> deleteMarcas() {		
		String resp = service.deleteMarcas();
		if("OK".equalsIgnoreCase(resp)) {
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}



}		


