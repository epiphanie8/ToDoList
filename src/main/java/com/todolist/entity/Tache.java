package com.todolist.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tache {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle_tach;
	private LocalDate date;
	private LocalTime heure;
	private Boolean statut_tach;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
}
