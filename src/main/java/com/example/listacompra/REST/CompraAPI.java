package com.example.listacompra.REST;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.listacompra.dto.compradto;
import com.example.listacompra.repositories.CompraRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController("/api")
public class CompraAPI {

	@Autowired
	CompraRepository comprarepository;
	
	
	/*@ApiResponse(responseCode="404",description="No se ha encontrado la compra")//Definir los codigos de respuesta http
	@ApiResponse(responseCode="400" ,description="Error 400")
	@Operation(summary="Obtiene todas las compras")
	@GetMapping("/allCompras")
	public ResponseEntity<List<compradto>> getCompras(){
	if(Response.isEmpty()) {
		return new ResponseEntity<List<compradto>>(compras,HttpStatus.OK);
	}else {
		return new ResponseEntity<List<compradto>>(compras,HttpStatus.NO_CONTENT);
	}
				
	}
	@CacheEvict(value="compras")
	@ApiResponse(responseCode="400",description="Alguno de los objetos no ha sido encontrado")
	@Operation(summary="Obtiene una compra")
	@GetMapping("/compras")
	public boolean saveCompras(compradto c) {
		
		comprarepository.guardarCompra(c);
		
		return true;
		

		
	}
	
	}
	
	*/
}



