package com.todolist.implementationserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.Utilisateur;
import com.todolist.repository.UtilisateurRepository;
import com.todolist.service.UtilisateurService;

@Service
public class UtilisateurImplementation implements UtilisateurService{
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	//creation d'utilisateur
	@Override
	public void creerUtilisateur(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		
	}
	
	
	

}
