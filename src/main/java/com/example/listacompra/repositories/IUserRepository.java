package com.example.listacompra.repositories;

import com.example.listacompra.dto.UsuarioDTO;

public interface IUserRepository {
	public 	UsuarioDTO findbyUsername(String nombre);
}
