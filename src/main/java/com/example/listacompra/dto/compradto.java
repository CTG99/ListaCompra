package com.example.listacompra.dto;

public class compradto {
	
private long id;	
private String descripcion;
private String categoria;
private String imageURL;
private boolean enable;

//private static int counterById=1;//Como el autoincremento (Cuando usemos base de datos no hara falta)

/*public static int getCounterById() {
	return counterById++;//Aqui se autoincrementa cada vez que se usa
}*/

public compradto() {
	this.id=id;
	this.descripcion=descripcion;
	this.categoria=categoria;
	this.imageURL=imageURL;
	this.enable=enable;
	
}


public String getImageURL() {
	return imageURL;
}
public void setImageURL(String imageURL) {
	this.imageURL = imageURL;
}
public boolean isEnable() {
	return enable;
}
public void setEnable(boolean enable) {
	this.enable = enable;
}
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

public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}

@Override
public String toString() {
	return "compradto [id= " + id + ", descripcion=" + descripcion + " categoria= " + categoria + "]";
}


}
