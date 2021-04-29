package br.com.fiap.avaliacaospring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.avaliacaospring.domain.AlunoDomain;

public interface AlunoRepository extends MongoRepository<AlunoDomain, String> {
    
    public Optional<AlunoDomain> findByRa(long ra);
}
