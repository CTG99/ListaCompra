package com.example.listacompra.dto;

public class categoriadto {

	private long id;
	private String categoria;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return  categoria  ;
	}
	
	
}
