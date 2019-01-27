package com.projeto.spring.mogodb.repository;

import com.projeto.spring.mogodb.model.Livros;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosRepository extends MongoRepository<Livros, String> {

    List<Livros> findByValorLessThan(Double maxValor);

}
