package br.com.fiap.avaliacaospring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.avaliacaospring.domain.AlunoDomain;
import br.com.fiap.avaliacaospring.model.AlunoModel;
import br.com.fiap.avaliacaospring.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository aRepository;

    public AlunoService(AlunoRepository aRepository) {
        this.aRepository = aRepository;
    }

    public void cadastraAluno(AlunoModel aluno) {
        aRepository.save(new AlunoDomain(aluno.getNome(), aluno.getRa()));
    }

    public List<AlunoModel> getAlunos() {
        return aRepository.findAll().stream().map(x -> new AlunoModel(x.getNome(), x.getRa()))
                .collect(Collectors.toList());
    }

    public void deleteAlunos() {
        aRepository.deleteAll();
    }

}
