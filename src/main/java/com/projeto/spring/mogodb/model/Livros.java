package com.projeto.spring.mogodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "livros")
public class Livros {


    @Id
    private String id;

    private String titulo;
    private Double valor;
    private String autor;

}
