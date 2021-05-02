package br.com.fiap.avaliacaospring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientePotencialModel {
    private long ra;

    private String nome;
}
