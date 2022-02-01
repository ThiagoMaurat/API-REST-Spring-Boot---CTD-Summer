package com.digitalhouse.ApiFilmes.service;

import java.util.List;
import com.digitalhouse.ApiFilmes.model.Filme;
import com.digitalhouse.ApiFilmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    
    @Autowired
    private FilmeRepository repository;

    public List<Filme> selectAll() {
        return repository.findAll();
    }

    public Filme select(Integer id) {
        return repository.findById(id).get();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Filme create(Filme filme){
        return repository.save(filme);
    }

    public Filme update(Filme filme) {
        Filme filmeUpdate = repository.findById(filme.getId()).get();
        filmeUpdate.setTitulo(filme.getTitulo());
        filmeUpdate.setUrlImg(filme.getUrlImg());        
        return repository.save(filmeUpdate);
    }

}
