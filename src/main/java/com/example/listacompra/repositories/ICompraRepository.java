package com.example.listacompra.repositories;

import java.util.List;

import com.example.listacompra.dto.categoriadto;
import com.example.listacompra.dto.compradto;

public interface ICompraRepository {

	public boolean guardarCompra(compradto compra);
	public boolean updateCompra(compradto c);
	public List<compradto> getAllCompras();
	public compradto getCompraById(int id);
	public boolean deleteCompra(int id);
	public List<categoriadto>getCategorias();
}
