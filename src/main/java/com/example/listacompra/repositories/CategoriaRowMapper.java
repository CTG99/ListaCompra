package com.example.listacompra.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.listacompra.dto.categoriadto;


public class CategoriaRowMapper {


	public categoriadto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		categoriadto categoria= new categoriadto();
		categoria.setId(rs.getLong(1));
		categoria.setCategoria(rs.getString(2));
		return categoria;
	}
}
