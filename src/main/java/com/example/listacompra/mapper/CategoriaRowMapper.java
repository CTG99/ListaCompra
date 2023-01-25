package com.example.listacompra.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.example.listacompra.dto.categoriadto;

public class CategoriaRowMapper implements RowMapper<categoriadto>{

	@Override
	public categoriadto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		categoriadto categoria= new categoriadto();
		categoria.setId(rs.getInt(1));
		categoria.setCategoria(rs.getString(2));
		

		return categoria;
	}

	
	
}
