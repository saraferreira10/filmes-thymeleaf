package com.sara.filmes.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sara.filmes.model.FilmeModel;
import com.sara.filmes.repository.FilmeRepository;

import jakarta.validation.Valid;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    public List<FilmeModel> getAll() {
        return filmeRepository.findAll();
    }

    public FilmeModel getById(Integer id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public FilmeModel save(@Valid FilmeModel filmeModel) {
        return filmeRepository.save(filmeModel);
    }

    public FilmeModel updateById(@Valid FilmeModel filmeModel, Integer id) {

        if (!filmeRepository.existsById(id)) {
            return null;
        }

        var filmeAtualizado = filmeRepository.findById(id);
        BeanUtils.copyProperties(filmeModel, filmeAtualizado);
        filmeRepository.save(filmeModel);

        return filmeModel;
    }

    public boolean deleteById(Integer id) {
        if (!filmeRepository.findById(id).isPresent()) {
            return false;
        }

        filmeRepository.deleteById(id);
        return true;
    }

    public boolean exists(Integer id) {
        return filmeRepository.existsById(id);
    }

}
