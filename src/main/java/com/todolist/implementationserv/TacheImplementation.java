package com.todolist.implementationserv;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todolist.dto.TacheDTO;
import com.todolist.entity.Categorie;
import com.todolist.entity.Tache;
import com.todolist.entity.Utilisateur;
import com.todolist.repository.CategorieRepository;
import com.todolist.repository.TacheRepository;
import com.todolist.service.TacheService;

import jakarta.servlet.http.HttpSession;

@Service
public class TacheImplementation implements TacheService{

	@Autowired
	private TacheRepository tacheRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Override
	public ResponseEntity<String> creerTache(TacheDTO tacheDTO, HttpSession session) {
		
		//recuperer l'utilisateur connecter
		Utilisateur utilisateurlogin = (Utilisateur) session.getAttribute("user");
		
		if(utilisateurlogin == null) {
			
			return ResponseEntity.status(401).body("Utilisateur introuvable");
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
	        
	        tacheRepository.save(tache);
	        
	        return ResponseEntity.status(201).body("Tache créer avec succès");
		}
		
		
		
		
	}

}
