package com.example.listacompra.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.listacompra.dto.RecetaDTO;
import com.example.listacompra.dto.RecetasResponseDTO;
import com.google.gson.Gson;

@Service
public class RecetasService {

	
	private final static String uriMealAPIRandom="https://www.themealdb.com/api/json/v1/1/random.php";
	private final static String uriMealByIdMeal="www.themealdb.com/api/json/v1/1/lookup.php?i=";
	

	private static RestTemplate rest;
	
	
	
	
	public static RecetaDTO getRecetasFromAPI(){
	
		
				rest=new RestTemplate();
			String result = rest.getForObject(uriMealAPIRandom, String.class);
		
		
		Gson gson=new Gson();
		
		RecetasResponseDTO recetas= gson.fromJson(result, RecetasResponseDTO.class);
		
		
		
		
		return getResponsebyString(result).getMeals().get(0);
		
		
	}
	
	public ArrayList<RecetaDTO> getListRecetasRandom(){
		
		ArrayList<RecetaDTO> recetas= new ArrayList<RecetaDTO>();
		for (int i=0;i<=5;i++) {
			recetas.add(getRecetasFromAPI());
		}
		return recetas;
		
		
	}
	
	public RecetasResponseDTO getRecetaRandomFromApi() {
		return null;
		
		
	
		
	}
	
	public static RecetasResponseDTO getResponsebyString(String result) {
		
		Gson gson=new Gson();
		
		RecetasResponseDTO recetas =gson.fromJson(result,RecetasResponseDTO.class);
		
		return recetas;
		
	}

	public RecetaDTO getIngredientsByIdMeal(int id) {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		RecetasResponseDTO recetas=gson.fromJson(id, RecetasResponseDTO.class);
		return recetas;
	}

}
