package br.com.fiap.avaliacaospring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.avaliacaospring.domain.ClientePotencialDomain;

public interface ClientePotencialRepository extends MongoRepository<ClientePotencialDomain, Long> {

}
