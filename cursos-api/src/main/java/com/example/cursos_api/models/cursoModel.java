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

    public cursoModel(){}

    public cursoModel(
        String nome, 
        String categoria, 
        Integer cargaHoraria
    ){
        this.nome = nome;
        this.categoria = categoria;
        this.cargaHoraria = cargaHoraria;
    }

    public Long getId() {return id;}
    public void setId(Long id){this.id=id;}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}

    public String getCategoria(){return categoria;}
    public void setCategoria(String categoria) {
        this.categoria=categoria;
    }

    public Integer getCargaHoraria(){return cargaHoraria;}
    public void setCargaHoraria(Integer cargaHoraria){this.cargaHoraria=cargaHoraria;}
}