package br.com.fiap.avaliacaospring.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompraModel {
        
    public CompraModel(BigDecimal valor, long ra, String nomeLoja) {
        this.valor = valor;
        this.ra = ra;
        this.nomeLoja = nomeLoja;
    }

    private BigDecimal valor;
    
    private long ra;

    @JsonProperty("nome_loja")
    private String nomeLoja;
}
