package com.thc.curso.springboot.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

@RestController
@RequestMapping("/service")
public class CursoSpringController {

	@Autowired
	ICursoSpringService service;

	@Value("${spring.datasource.url}")
	private String url;

	private static final Logger LOGGER = Logger.getLogger("com.thc.curso.springboot.controller.CursoSpringController");
	
	@PostMapping("/uploadFile")
	@ResponseStatus(HttpStatus.CREATED)
	public MarcaDTO uploadFile(@RequestParam("file") MultipartFile file) {
		return MarcaDTO.builder().idMarca(100L).nombreMarca("You successfully uploaded ").build();
	}

	@GetMapping("/getMarcas")
	@ResponseStatus(HttpStatus.OK)
	public List<MarcaDTO> getMarcas(@RequestHeader(value = "Autorizador", required = true) String token){
		return service.getMarcas(token);
	}

	@GetMapping("/getMarcasAll")
	@ResponseStatus(HttpStatus.OK)
	public List<MarcaDTO> getMarcasAll(){
		System.err.println("Estas en getMarcasAll");
		return service.getMarcas("");
	}

	@GetMapping("/getMarcaxId/{idMarca}")
	public ResponseEntity<MarcaDTO> getMarcaxId(@PathVariable Long idMarca){
		service.getMarcaxId(idMarca);

		return new ResponseEntity<>(new MarcaDTO(), HttpStatus.OK);
	}

	@PostMapping("/saveMarca")
	@ResponseStatus(HttpStatus.CREATED)
	public MarcaDTO save(@RequestBody MarcaDTO request) {
		return service.saveMarca(request);
	}

	@PostMapping("/saveAllMarcas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseGeneric saveAll(@RequestBody RequestMarcas request) {
		return service.saveAll(request);
	}

	@PutMapping("/updateMarca")
	@ResponseStatus(HttpStatus.OK)
	public MarcaDTO update(@RequestBody MarcaDTO request) {
		return service.updateMarca(request);
	}

	@DeleteMapping("/deleteMarca/{idMarca}")
	public ResponseEntity<String> delete(@PathVariable Long idMarca) {		
		String resp = service.deleteMarca(idMarca);
		if("OK".equalsIgnoreCase(resp)) {
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
	}

}
