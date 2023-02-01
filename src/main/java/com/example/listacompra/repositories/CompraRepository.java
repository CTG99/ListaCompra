package com.example.listacompra.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.listacompra.dto.categoriadto;
import com.example.listacompra.dto.compradto;
import com.example.listacompra.mapper.CategoriaRowMapper;
import com.example.listacompra.mapper.CompraRowMapper;


@Repository
public class CompraRepository implements ICompraRepository{

	@Autowired
	@Qualifier("jdbcTemplateDB1")
	JdbcTemplate jdbctemplate;
	
	@Autowired
	@Qualifier("jdbcTemplateDB2")
	JdbcTemplate jdbctemplateDB2;
	
	
	
	@Override
	public boolean guardarCompra(compradto compra) {
		// TODO Auto-generated method stub
	/*	Object[] obj= {
				compra.getDescripcion()
		};*///Por si necesitas recibir un array de datos(Es mas util)
		
		
		//jdbctemplateDB2.execute("INSERT INTO proveedor VALUES (12,'saslsls')" );
		try {
			String sql=String.format("INSERT INTO compra(descripcion,categoria) VALUES ('%s',%d)",compra.getDescripcion(),compra.getCategoria());//Como el id es autoincremento no se le puede pasar el id
			jdbctemplate.execute(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return true;
	}

	@Override
	public boolean updateCompra(compradto c) {
		// TODO Auto-generated method stub
		String sql=String.format("UPDATE compra SET descripcion=('%s') WHERE id=('%d')",c.getDescripcion(),c.getId());
		String sql2=String.format("UPDATE compra SET categoria=('%s') WHERE id=('%d')",c.getCategoria(),c.getId());
		jdbctemplate.execute(sql);
		jdbctemplate.execute(sql2);
		return true;
		
		
	}

	@Override
	public List<compradto> getAllCompras() {
		// TODO Auto-generated method stub
		return jdbctemplate.query("SELECT descripcion,categorias.categoria FROM compra,categorias WHERE compra.categoria=categorias.Id", new CompraRowMapper());
		//"SELECT descripcion,categorias.categoria FROM compra,categorias WHERE compra.categoria=categorias.Id
		
	}
	
	public List<categoriadto> getAllCategorias(){
		return jdbctemplate.query("SELECT * FROM categoria", new CategoriaRowMapper());
	}

	@Override
	public compradto getCompraById(int id) {
		String d=String.format("SELECT * FROM compra WHERE id='%d'", id);
		return jdbctemplate.queryForObject(d,new CompraRowMapper());
	
		
		
	}

	@Override
	public boolean deleteCompra(int id) {
		// TODO Auto-generated method stub
		try {
		String sql=String.format("DELETE FROM compra WHERE id=(%d)",id);
		jdbctemplate.execute(sql);
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		return false;
	}
		
	}

	@Override
	public List<categoriadto> getCategorias() {
		 return jdbctemplate.query("SELECT * FROM categorias", new CategoriaRowMapper());
		
	}

	
	
}
