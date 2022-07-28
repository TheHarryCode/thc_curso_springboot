package com.thc.curso.springboot.repository;

import java.util.List;

import com.thc.curso.springboot.model.MarcaDTO;

public interface ICursoSpringRepositoryJDBC {

	public List<MarcaDTO> getMarcas();

	public MarcaDTO saveMarca(MarcaDTO request);

	public MarcaDTO updateMarca(MarcaDTO request);

	public String deleteMarca(Long idMarca);
}
