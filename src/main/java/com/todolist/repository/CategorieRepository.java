package com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {


}
