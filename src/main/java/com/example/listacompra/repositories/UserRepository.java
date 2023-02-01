package com.example.listacompra.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.listacompra.dto.UsuarioDTO;
import com.example.listacompra.mapper.UsuarioRowMapper;

@Repository
public class UserRepository implements IUserRepository{
	
	@Autowired
	@Qualifier("jdbcTemplateDB1")
	JdbcTemplate jdbctemplate;

	
public 	UsuarioDTO findbyUsername(String nombre) {
	String sql=String.format("SELECT username,password from users where username='%s'",nombre);
	return jdbctemplate.queryForObject(sql, new UsuarioRowMapper());
	
}


}
