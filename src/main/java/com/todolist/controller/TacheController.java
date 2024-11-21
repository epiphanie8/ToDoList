package com.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.dto.TacheDTO;
import com.todolist.entity.Categorie;
import com.todolist.entity.Tache;
import com.todolist.entity.Utilisateur;
import com.todolist.repository.CategorieRepository;
import com.todolist.repository.TacheRepository;
import com.todolist.service.TacheService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/tache")
public class TacheController {
	
	@Autowired
	private TacheService tacheService;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private TacheRepository tacheRepository;
	
	//creer une tache
	@PostMapping(path="creerTache", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> creerTache(@RequestBody TacheDTO tacheDTO, HttpSession session) {
		//recuperer l'utilisateur connecter
				Utilisateur utilisateurlogin = (Utilisateur) session.getAttribute("user");
				
				if(utilisateurlogin == null) {
					
					return ResponseEntity.status(401).body("Utilisateur introuvable! veuillez vous reconnecter !");
				}
				else {
			        // Récupérer la catégorie par ID
			        Categorie categorie = categorieRepository.findById(tacheDTO.getCategorie_id())
			                .orElseThrow(() -> new RuntimeException("Catégorie introuvable"));
			     
			        // Créer la nouvelle tâche
			        
			        Tache tache = new Tache();
			        tache.setLibelle_tach(tacheDTO.getLibelle());
			        tache.setDate(tacheDTO.getDate());
			        tache.setHeure(tacheDTO.getHeure());
			        tache.setCategorie(categorie);
			        tache.setUtilisateur(utilisateurlogin);
			        tache.setStatut_tach(false);
			        
			        tacheRepository.save(tache);
			        
			        return ResponseEntity.status(201).body("Tache créer avec succès");
				}
				
				
		
		//tacheService.creerTache(tacheDTO, session);
		
	}

}
