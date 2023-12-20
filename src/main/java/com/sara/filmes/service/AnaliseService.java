package com.sara.filmes.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sara.filmes.model.AnaliseModel;
import com.sara.filmes.repository.AnaliseRepository;

import jakarta.validation.Valid;

@Service
public class AnaliseService {

    @Autowired
    AnaliseRepository analiseRepository;

    public List<AnaliseModel> getAll() {
        return analiseRepository.findAll();
    }

    public AnaliseModel getById(Integer id) {
        return analiseRepository.findById(id).get();
    }

    public AnaliseModel save(@Valid AnaliseModel analiseModel) {
        return analiseRepository.save(analiseModel);
    }

    public AnaliseModel updateById(@Valid AnaliseModel analiseModel, Integer id) {
        if (!analiseRepository.existsById(id)) {
            return null;
        }

        var analiseAtualizada = analiseRepository.findById(id);

        BeanUtils.copyProperties(analiseModel, analiseAtualizada);
        analiseRepository.save(analiseModel);
        return analiseModel;
    }

    public boolean deleteById(Integer id) {
        if (!analiseRepository.existsById(id)) {
            return false;
        }

        analiseRepository.deleteById(id);
        return true;
    }

    public boolean exists(Integer id) {
        return analiseRepository.existsById(id);
    }

}
