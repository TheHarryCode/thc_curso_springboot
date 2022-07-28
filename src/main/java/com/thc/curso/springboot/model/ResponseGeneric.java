package com.thc.curso.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGeneric {

	private boolean exitoso;
	private String mensajeError;
	
}
