package com.example.listacompra.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.listacompra.dto.UsuarioDTO;

public class UsuarioRowMapper implements RowMapper<UsuarioDTO>{
	
	
	@Autowired
	@Qualifier("jdbctemplatedb1")
	JdbcTemplate jdbctemplate;
	@Override
	public UsuarioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
