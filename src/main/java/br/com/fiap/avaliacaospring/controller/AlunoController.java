package br.com.fiap.avaliacaospring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.fiap.avaliacaospring.model.AlunoModel;
import br.com.fiap.avaliacaospring.service.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService aService;

    public AlunoController(AlunoService aService) {
        this.aService = aService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void cadastraAluno(@RequestBody AlunoModel aluno) {
        aService.cadastraAluno(aluno);
    }

}
