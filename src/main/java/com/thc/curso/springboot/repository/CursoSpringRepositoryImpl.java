package com.thc.curso.springboot.repository;

import java.util.List;
// CTRL +F
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thc.curso.springboot.model.MarcaDTO;

@Repository
public class CursoSpringRepositoryImpl implements ICursoSpringRepositoryJDBC{

	
	//CTRL + SHIT + R
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MarcaDTO> getMarcas() {
		List<MarcaDTO> ltMarcas = null;

		ltMarcas = jdbcTemplate.query("SELECT * FROM FRO MARCAS", (rs, rowNum)->
		new MarcaDTO(
				rs.getLong("ID"),
				rs.getString("NOMBRE")
				)
				);
		return ltMarcas;
	}

	@Override
	public MarcaDTO saveMarca(MarcaDTO request) {
		int cantRegUpd = jdbcTemplate.update("INSERT INTO MARCAS(`NOMBRE`) VALUES (?) ",request.getNombreMarca() );
		System.out.println(" cantRegUpd "+cantRegUpd);
		return request;
	}

	@Override
	public MarcaDTO updateMarca(MarcaDTO request) {
		int cantRegUpd = jdbcTemplate.update("UPDATE MARCAS SET NOMBRE=? WHERE ID = ? ",request.getNombreMarca(), 
				request.getIdMarca());
		System.out.println(" cantRegUpd "+cantRegUpd);
		return request;
	}

	@Override
	public String deleteMarca(Long idMarca) {
		int cantRegUpd = jdbcTemplate.update("DELETE FROM MARCAS WHERE ID = ? ", idMarca);
		System.out.println(" cantRegUpd "+cantRegUpd);

		if(cantRegUpd > 0) {
			return "OK";
		}else{
			return "NOT FOUND";
		}
	}

}
