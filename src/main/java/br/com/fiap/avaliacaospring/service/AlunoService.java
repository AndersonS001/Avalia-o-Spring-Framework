package br.com.fiap.avaliacaospring.service;

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
    

}
