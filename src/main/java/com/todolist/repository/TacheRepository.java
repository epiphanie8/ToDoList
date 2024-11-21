package com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.entity.Tache;

public interface TacheRepository extends JpaRepository<Tache, Integer> {

}
