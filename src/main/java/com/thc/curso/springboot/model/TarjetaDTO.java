package com.thc.curso.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TARJETAS")
@Builder
public class TarjetaDTO {

	@Id
	@Column(name = "ID_TARJETA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTarjeta;
	
	@Column(name = "NOMBRE_TARJETA")
	private String nombre;
	
	@Column(name = "ID_PERSONA")
	private Long idPersona;
	
}
