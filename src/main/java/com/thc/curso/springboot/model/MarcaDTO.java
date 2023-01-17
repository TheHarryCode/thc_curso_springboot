package com.thc.curso.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MARCAS")
@Where(clause = "creador = 'Harry'")
@Builder
public class MarcaDTO {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMarca;
	
	@Column(name = "NOMBRE")
	private String nombreMarca;
	
	@Column(name = "CREADOR")
	private String creador;
	
}
