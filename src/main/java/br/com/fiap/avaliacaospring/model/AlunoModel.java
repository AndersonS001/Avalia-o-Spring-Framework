package br.com.fiap.avaliacaospring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel {

    private String nome;
    private long ra;
    
}
