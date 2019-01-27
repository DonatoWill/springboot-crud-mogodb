package com.projeto.spring.mogodb.controller;

import com.projeto.spring.mogodb.model.Livros;
import com.projeto.spring.mogodb.repository.LivrosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class LivrosController {

    private LivrosRepository livrosRepository;

    public LivrosController(LivrosRepository livrosRepository){
        this.livrosRepository = livrosRepository;
    }

    @GetMapping("/livros")
    public List<Livros> getAll(){
        return this.livrosRepository.findAll();
    }

    @PutMapping("/cadastrar")
    public void insert(@RequestBody Livros livro){
        this.livrosRepository.insert(livro);
    }

    @PostMapping("/atualizar")
    public void update(@RequestBody Livros livro){
        this.livrosRepository.save(livro);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable("id") String id){
        this.livrosRepository.deleteById(id);
    }

    @GetMapping("/valor/{maxValor}")
    public List<Livros> getByValor(@PathVariable("maxValor") Double maxValor){

        return this.livrosRepository.findByValorLessThan(maxValor);
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<Livros> getById(@PathVariable("id") String id){
        return this.livrosRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

}
