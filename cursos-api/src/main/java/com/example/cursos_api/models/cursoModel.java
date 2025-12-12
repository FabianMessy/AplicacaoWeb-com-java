package com.example.cursos_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "cursos")

public class cursoModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)

    private String nome;

    private String categoria;

    private Integer cargaHoraria;

    
    public cursoModel(
        String nome, 
        String categoria, 
        Integer cargaHoraria
    ){
        this.nome = nome;
        this.categoria = categoria;
        this.cargaHoraria = cargaHoraria;
    }

    public long getId() {return id;}
}