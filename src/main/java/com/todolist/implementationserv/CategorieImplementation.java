package com.todolist.implementationserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.Categorie;
import com.todolist.repository.CategorieRepository;
import com.todolist.service.CategorieService;

@Service
public class CategorieImplementation implements CategorieService{

	@Autowired
	private CategorieRepository categorieRepository;
	
	//creer une categorie
	@Override
	public void creerCategorie(Categorie categorie) {
		
		categorieRepository.save(categorie);
	}

}
