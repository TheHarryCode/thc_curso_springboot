package com.thc.curso.springboot.service;

import java.util.List;

import com.thc.curso.springboot.model.MarcaDTO;
import com.thc.curso.springboot.model.RequestMarcas;
import com.thc.curso.springboot.model.ResponseGeneric;

public interface ICursoSpringService {

	public List<MarcaDTO> getMarcas(String token);
	
	public MarcaDTO saveMarca(MarcaDTO request);
	
	public MarcaDTO updateMarca(MarcaDTO request);
	
	public String deleteMarca(Long idMarca);

	public MarcaDTO getMarcaxId(Long idMarca);

	public String deleteMarcas();

	public ResponseGeneric saveAll(RequestMarcas request);
}
