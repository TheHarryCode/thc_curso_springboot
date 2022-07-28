package com.thc.curso.springboot.persistence;

import org.springframework.data.repository.CrudRepository;

import com.thc.curso.springboot.model.MarcaDTO;

public interface ICursoSpringRepositoryJPA extends CrudRepository <MarcaDTO, Long>{

}
