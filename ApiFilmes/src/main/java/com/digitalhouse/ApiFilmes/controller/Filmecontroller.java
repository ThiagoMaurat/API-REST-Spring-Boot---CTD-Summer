package com.digitalhouse.ApiFilmes.controller;

import java.util.List;

import com.digitalhouse.ApiFilmes.model.Filme;
import com.digitalhouse.ApiFilmes.service.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class Filmecontroller {
    
    @Autowired
    private FilmeService service;

    @GetMapping
    public List<Filme> getAll() {
        return service.selectAll();
    }

    @GetMapping("/{id}")
    public Filme getById(@PathVariable Integer id) {
        return service.select(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Deletado com sucesso";
    }


}
