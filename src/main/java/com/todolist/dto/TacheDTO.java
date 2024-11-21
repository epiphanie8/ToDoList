package com.todolist.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacheDTO {

	private int id;
	private String libelle;
	private LocalDate date;
	private LocalTime heure;
	private Integer categorie_id;
	
}
