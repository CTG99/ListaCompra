package com.example.listacompra.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.listacompra.dto.categoriadto;
import com.example.listacompra.dto.compradto;

public class CompraRowMapper implements RowMapper<compradto>{

	@Override
	public compradto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		compradto compra= new compradto();
		compra.setId(rs.getInt(1));
		compra.setDescripcion(rs.getString(2));//El 2 es el numero de la columna en este caso "descripcion"
		return compra;
	}

}


