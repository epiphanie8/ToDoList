package com.todolist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.dto.UtilisateurDTO;
import com.todolist.entity.Utilisateur;
import com.todolist.repository.UtilisateurRepository;
import com.todolist.service.UtilisateurService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	//ajouter un utilisateur
	@PostMapping(path = "creeUtilisateur", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addUtilisateur(@RequestBody Utilisateur utilisateur) {
		
		utilisateurService.creerUtilisateur(utilisateur);
	}

	//login par session
	@PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody UtilisateurDTO utilisateurDTO, HttpSession session) {
	    Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findByEmail(utilisateurDTO.getEmail());
	    
	    if (optionalUtilisateur.isPresent()) {
	        Utilisateur utilisateur = optionalUtilisateur.get();
	        
	        // Comparaison simple du mot de passe
	        if (utilisateur.getPassword().equals(utilisateurDTO.getPassword())) {
	            session.setAttribute("user", utilisateur);
	            return ResponseEntity.ok("L'utilisateur " + utilisateur.getEmail() + " est connecté !");
	        } else {
	        	//mot de passe incorrecte
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect pour l'utilisateur " + utilisateurDTO.getEmail() + " !");
	        }
	    } else {
	    	//utilisateur inexistent
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'utilisateur " + utilisateurDTO.getEmail() + " est introuvable !");
	    }
	}

}
