package com.sara.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sara.filmes.model.AnaliseModel;

@Repository
public interface AnaliseRepository extends JpaRepository<AnaliseModel, Integer>{
    
}
