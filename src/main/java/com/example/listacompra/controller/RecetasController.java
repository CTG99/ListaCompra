package com.example.listacompra.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.listacompra.dto.RecetaDTO;
import com.example.listacompra.services.CompraService;
import com.example.listacompra.services.RecetasService;

@Controller
public class RecetasController {

	@Autowired
	RecetasService recetasService;
	
	@Autowired
	CompraService compraservice;
	
	@GetMapping("/go-to-Recetas")
	public String goToPageListRecetas(Model modelo) {
		
		
		
		
		ArrayList<RecetaDTO> recetas=recetasService.getListRecetasRandom();
		modelo.addAttribute("recetas",recetas);
		
		return "Recetas/pListaRecetas";
		
	}
	
	@GetMapping("/add-ingredients") 
	public String addIngredientsByIdMeal(@RequestParam("idMeal")int id,Model model) {
		
		RecetaDTO receta=recetasService.getIngredientsByIdMeal(id);
		receta=RecetasService.getRecetasFromAPI();
		compraservice.getIngredientsByIdMeal(receta);
		
		return "redirect:/go-to-lista";
	}
	
	

	
}
