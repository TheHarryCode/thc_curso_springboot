package com.thc.curso.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONAS")
@Builder
public class PersonaDTO {

	@Id
	@Column(name = "ID_PERSONA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPersona;
	
	@Column(name = "NOMBRE1")
	private String nombre1;
	
	@Column(name = "APELLIDO1")
	private String apellido1;
	
	@Column(name = "APELLIDO2")
	private String apellido2;
	
	@ManyToOne
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
	private TarjetaDTO tarjetas;
	
}
