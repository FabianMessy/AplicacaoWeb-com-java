package com.example.cursos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursos_api.models.cursoModel;

public interface cursoRepository extends JpaRepository<cursoModel, Long>{}