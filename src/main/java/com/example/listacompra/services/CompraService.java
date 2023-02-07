package com.example.listacompra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.listacompra.dto.RecetaDTO;
import com.example.listacompra.dto.compradto;
import com.example.listacompra.repositories.CompraRepository;

@Service
public class CompraService {
	
	public static String uriImagenIngrediente="https://www.themealdb.com//images//ingredients///'%s'.png";
	public JdbcTemplate jdbctemplate;
	@Autowired
	public CompraRepository compraRepo;
	

	
	public boolean insertIngredientByApiMeal(RecetaDTO recetadto) {
		
		for(String ingrediente : recetadto.getIngredients()) {
			String urlImagen=String.format(uriImagenIngrediente, ingrediente);
			
			
			compradto compra=new compradto(ingrediente,cat,urlImagen);
		}
		
		return compraRepo.guardarCompra(null);
		
	}
	
	public boolean updateCompraEnabled(compradto compra) {
		
		String sql=String.format("UPDATE compras SET enable=1 WHERE id = '%d'", compra.getId());
		
		
		jdbctemplate.execute(sql);
		
		return true;
	}
	
	
	
	
	
}
