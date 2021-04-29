package br.com.fiap.avaliacaospring.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.avaliacaospring.domain.AlunoDomain;
import br.com.fiap.avaliacaospring.domain.CompraDomain;
import br.com.fiap.avaliacaospring.model.CompraModel;
import br.com.fiap.avaliacaospring.repository.AlunoRepository;
import br.com.fiap.avaliacaospring.repository.CompraRepository;

@Service
public class CompraService {

    private final CompraRepository cRepository;
    private final AlunoRepository aRepository;

    public CompraService(CompraRepository cRepository, AlunoRepository aRepository) {
        this.cRepository = cRepository;
        this.aRepository = aRepository;
    }

    public void compraAluno(CompraModel compra) {

        AlunoDomain aluno = obtemAluno(compra.getRa());

        CompraDomain compraDomain = new CompraDomain(compra.getValor(), compra.getRa(), compra.getNomeLoja());
        compraDomain = cRepository.save(compraDomain);

        aluno.adicionaCompra(compraDomain);

        aRepository.save(aluno);
    }

    public List<CompraModel> extrato(long ra) {

        AlunoDomain aluno = obtemAluno(ra);

        return aluno.getCompras().stream().map(x -> new CompraModel(x.getValor(), x.getRa(), x.getNomeLoja()))
                .collect(Collectors.toList());

    }

    private AlunoDomain obtemAluno(long ra) {
        Optional<AlunoDomain> alunoMongo = aRepository.findByRa(ra);

        if (!alunoMongo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não cadastrado");
        }

        return alunoMongo.get();
    }

}
