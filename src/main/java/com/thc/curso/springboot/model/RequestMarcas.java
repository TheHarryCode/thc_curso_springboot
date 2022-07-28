package com.thc.curso.springboot.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMarcas {

	//listado de marcas a insertar
	private List<MarcaDTO> marcas;
	
}
