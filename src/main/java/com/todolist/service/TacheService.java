package com.todolist.service;

import org.springframework.http.ResponseEntity;

import com.todolist.dto.TacheDTO;
import com.todolist.entity.Tache;

import jakarta.servlet.http.HttpSession;

public interface TacheService {

	ResponseEntity<String> creerTache(TacheDTO tacheDTO, HttpSession session);
}
