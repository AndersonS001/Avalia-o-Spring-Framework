package br.com.fiap.avaliacaospring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "usuario")
@Data
public class AlunoDomain {

    public AlunoDomain(String nome, long ra) {
        this.nome = nome;
        this.ra = ra;
    }

    @Id
    private String id;

    private String nome;

    private long ra;
    
}
