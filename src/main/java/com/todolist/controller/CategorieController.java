package com.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.entity.Categorie;
import com.todolist.repository.CategorieRepository;
import com.todolist.service.CategorieService;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
	
	@Autowired
	private CategorieService categorieService;
	
	//creer une categorie
	@PostMapping(path = "creerCategorie", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addCategorie(@RequestBody Categorie categorie) {
		categorieService.creerCategorie(categorie);	
	}

}
