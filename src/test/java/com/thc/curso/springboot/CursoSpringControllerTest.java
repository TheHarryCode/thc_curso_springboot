package com.thc.curso.springboot;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.thc.curso.springboot.controller.CursoSpringController;
import com.thc.curso.springboot.model.MarcaDTO;
import com.thc.curso.springboot.service.ICursoSpringService;

class CursoSpringControllerTest {
	
	CursoSpringController controler;
	
	@Mock
	ICursoSpringService service;
	
	@BeforeEach
	public void setup() {
		
		MockitoAnnotations.openMocks(this);
		controler = new CursoSpringController();
		
		ReflectionTestUtils.setField(controler, "service", service);
		Mockito.when(service.getMarcas(any())).thenReturn(crearLtMarcas());
	}


	@Test
	void getMarcasAllTest() {
		List<MarcaDTO> lt= controler.getMarcasAll();
		Assertions.assertNotNull(lt);
	}

	private List<MarcaDTO> crearLtMarcas() {
		List<MarcaDTO> lt = new ArrayList<>();
		lt.add(crearMarca());
		return lt;
	}


	private MarcaDTO crearMarca() {
		return MarcaDTO.builder().idMarca(10L).build();
	}



}
