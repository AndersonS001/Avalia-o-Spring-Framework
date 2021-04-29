package br.com.fiap.avaliacaospring.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "compras")
public class CompraDomain {

    @Id
    private String id;

    private BigDecimal valor;

    private long ra;

    @Field("nome_loja")
    private String nomeLoja;

    public CompraDomain(BigDecimal valor, long ra, String nomeLoja) {
        this.valor = valor;
        this.ra = ra;
        this.nomeLoja = nomeLoja;
    }

}
