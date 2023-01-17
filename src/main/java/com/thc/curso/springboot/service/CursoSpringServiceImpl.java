package com.thc.curso.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thc.curso.springboot.model.MarcaDTO;
import com.thc.curso.springboot.model.RequestMarcas;
import com.thc.curso.springboot.model.ResponseGeneric;
import com.thc.curso.springboot.persistence.ICursoSpringRepositoryJPA;
import com.thc.curso.springboot.repository.ICursoSpringRepositoryJDBC;

@Service
public class CursoSpringServiceImpl implements ICursoSpringService{

	@Autowired
	ICursoSpringRepositoryJDBC repoJdbc;

	@Autowired
	ICursoSpringRepositoryJPA repoJpa;

	String resp = "Harry";
	
	// Using JPA
	@Override
	public List<MarcaDTO> getMarcas(String token) {
		return (List<MarcaDTO>) repoJpa.findAll();
	}

	@Override
	public MarcaDTO getMarcaxId(Long idMarca) {
		 Optional<MarcaDTO> optMarca = repoJpa.findById(idMarca);
		 if(optMarca.isPresent()) {
			 return optMarca.get();
		 }else {
			 return null;
		 }
	}
	
	@Override
	public MarcaDTO saveMarca(MarcaDTO request) {
		repoJpa.save(request);
		return request;
	}

	@Override
	public MarcaDTO updateMarca(MarcaDTO request) {
		repoJpa.save(request);
		return request;
	}


	@Override
	public ResponseGeneric saveAll(RequestMarcas request) {
		ResponseGeneric response = new ResponseGeneric();
		repoJpa.saveAll(request.getMarcas());
		response.setExitoso(true);
		return response;
	}
	
	@Override
	public String deleteMarca(Long idMarca) {
		repoJpa.deleteById(idMarca);
		return "OK";
	}

	@Override
	public String deleteMarcas() {
		repoJpa.deleteAll();
		return "OK";
	}
	
	// Using JDBC

	//	@Override
	//	public List<MarcaDTO> getMarcas(String token) {
	//		//Validaciones del Negocio
	//		//Llamados a BD, Servicios, ETC... - //Retorne la información
	//		return repoJdbc.getMarcas();
	//	}
	//
	//	@Override
	//	public MarcaDTO saveMarca(MarcaDTO request) {
	//		repoJdbc.saveMarca(request);
	//		return request;
	//	}
	//
	//	@Override
	//	public MarcaDTO updateMarca(MarcaDTO request) {
	//		repoJdbc.updateMarca(request);
	//		return request;
	//	}
	//	
	//	@Override
	//	public String deleteMarca(Long idMarca) {
	//		return repoJdbc.deleteMarca(idMarca);
	//	}

}
