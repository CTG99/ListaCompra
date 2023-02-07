package com.example.listacompra.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.listacompra.dto.compradto;
import com.example.listacompra.repositories.CompraRepository;

@Controller
public class WelcomeController {
	
	@Autowired
	CompraRepository comprarepository;
	
	public ArrayList<compradto> listacompras=new ArrayList<compradto>();
	
	
	@GetMapping("/")
	public String goToIndex(Model model) {
		
		return "index";
		
	}
	
	/**
	 * Shift + alt + J
	 * Para informar sobre el metodo
	 * @param model
	 * @return vista a pantalla compras
	 */
	@GetMapping("/go-to-lista")
	public String goToLista(Model model) {
		
	/*	compradto compra=new compradto();
		compra.setDescripcion("Productos");
		
		listacompras.add(compra);
		model.addAttribute("productos",listacompras);*/
		
		model.addAttribute("productos",comprarepository.getAllCompras());
		//model.addAttribute("categorias",comprarepository.getAllCategorias());
		
		
		return "plista";
		
	}
	
	@GetMapping("/add-producto")
	public String goToFormProducto(Model model) {
		
		compradto producto=new compradto();
		
		model.addAttribute("compra",producto);
		model.addAttribute("categorias",comprarepository.getCategorias());
		
		
		return "pAddProducto";
		
	}
	
	
	@PostMapping("/add-producto")
	public String goProductoToList(@ModelAttribute("producto") compradto producto) {
		System.out.println(producto);
		
		if(producto.getId()!=0){
			comprarepository.updateCompra(producto);
			
		}else{
			
			comprarepository.guardarCompra(producto);
		
		}
		
		
		
		
	
		
		/*int posicion;
		if(producto.getId()>0) {
			for(int i=0;i<listacompras.size();i++) {
				if(producto.getId()==listacompras.get(i).getId()) {
					posicion=i;
					listacompras.remove(i);
				}
			}
		}
		
		
		ModelAndView n= new ModelAndView();
		producto.setId(compradto.getCounterById());
		listacompras.add(producto);*/
		
		return "redirect:/go-to-lista";
	}
	
	@GetMapping("/delete-producto")
	public String deleteProductoById(@RequestParam("id") int id) {
		comprarepository.deleteCompra(id);
		//Deletecategoria
		
	/*for(int i=0;i<listacompras.size();i++) {
			if(id==listacompras.get(i).getId()) {
				listacompras.remove(i);
			}
		}*/
		
		return "redirect:/go-to-lista";
		
	}
	
	@GetMapping("/update-producto")
	public String updateProductoById(@RequestParam("id") int id,Model model) {
		
		compradto d=new compradto();
		d.setId(id);
		d.setDescripcion(comprarepository.getCompraById(id).getDescripcion());
		
		model.addAttribute("compra",d);
	//	comprarepository.updateCompra(d);
		
		/*compradto producto=new compradto();
		
		for(int i=0;i<listacompras.size();i++) {
			if(id==listacompras.get(i).getId()) {
				listacompras.remove(i);
			}
		}
		modelo.addAttribute("producto",producto);*/
		
		
		return "pAddProducto";
	}
	
	/*@RequestMapping("/error")
	public String showError404Generic(Exception ex) {
		return "404error";
	}*/
	
}
