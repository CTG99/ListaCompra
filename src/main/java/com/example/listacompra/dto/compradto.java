package com.example.listacompra.dto;

public class compradto {
	
private long id;	
private String descripcion;
private int categoria;

//private static int counterById=1;//Como el autoincremento (Cuando usemos base de datos no hara falta)

/*public static int getCounterById() {
	return counterById++;//Aqui se autoincrementa cada vez que se usa
}*/

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public int getCategoria() {
	return categoria;
}
public void setCategoria(int categoria) {
	this.categoria = categoria;
}

@Override
public String toString() {
	return "compradto [id=" + id + ", descripcion=" + descripcion + " categoria= " + categoria + "]";
}


}
