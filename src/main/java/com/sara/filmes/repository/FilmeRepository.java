package com.sara.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sara.filmes.model.FilmeModel;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, Integer>{
    
}
