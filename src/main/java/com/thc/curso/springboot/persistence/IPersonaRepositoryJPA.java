package com.thc.curso.springboot.persistence;

import org.springframework.data.repository.CrudRepository;

import com.thc.curso.springboot.model.PersonaDTO;

public interface IPersonaRepositoryJPA extends CrudRepository <PersonaDTO, Long>{

}
