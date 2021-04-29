package br.com.fiap.avaliacaospring.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

    @DBRef
    private List<CompraDomain> compras;

    public void adicionaCompra(CompraDomain compra) {

        if (compras == null)
            compras = new ArrayList<>();

        compras.add(compra);

    }

}
