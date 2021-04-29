package br.com.fiap.avaliacaospring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.avaliacaospring.domain.CompraDomain;

public interface CompraRepository extends MongoRepository<CompraDomain, String> {
    
}
