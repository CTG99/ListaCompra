package com.example.listacompra.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyErrorsController implements ErrorController{

	@RequestMapping("/error")
	public String showPageError404(Exception e,HttpServletResponse req) {
		String vista;
		
		switch(req.getStatus()) {
		case HttpServletResponse.SC_NOT_FOUND:{
			vista = "404error";
			
		}case HttpServletResponse.SC_INTERNAL_SERVER_ERROR:{
			
		return "500vista";
			
		}
		default:{
			//Poner excepcion general
			
		}
		
		}
		
		return "404error";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String showPageErrorGeneric(Exception e) {
		
		
		return "ExceptionPage";
	}
}
