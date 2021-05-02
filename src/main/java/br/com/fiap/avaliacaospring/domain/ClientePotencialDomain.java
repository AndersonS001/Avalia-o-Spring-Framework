package br.com.fiap.avaliacaospring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "cliente_potencial")
@Data
@AllArgsConstructor
public class ClientePotencialDomain {
    
    @Id
    private long ra;

    private String nome;

}
